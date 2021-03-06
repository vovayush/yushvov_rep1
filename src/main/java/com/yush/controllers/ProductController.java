package com.yush.controllers;

import com.yush.dao.ProductsDAO;
import com.yush.dao.ProductsDAOImpl;
import com.yush.entity.Product;
import com.yush.servlets.product.ProductParams;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.yush.servlets.product.ProductParams.*;

@Controller
public class ProductController {
    private static final Logger LOG = Logger.getLogger(ProductController.class);

    @RequestMapping("/newproductaddserv")
    public ModelAndView productAdd(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView errorModelAndView = new ModelAndView("someErrorHappened");

        if (isSomeFieldNotFilled(request)) {
            errorModelAndView.addObject("errorMessage", "Some parameters field does not filled");
            errorModelAndView.addObject("backUrl", "/newproductadd");
            errorModelAndView.addObject("urlMessage", "return and fill all field in form");
            return errorModelAndView;
        }
        String name = request.getParameter(PRODUCT_NAME.toString());
        String description = request.getParameter(DESCRIPTION.toString());
        Double price;
        Integer quantity;
        String productGroup = request.getParameter(PRODUCT_GROUP.toString());
        String vendor = request.getParameter(VENDOR.toString());
        String detail = request.getParameter(DETAIL.toString());
        try {
            price = Double.parseDouble(request.getParameter(PRICE.toString()));
            quantity = Integer.parseInt(request.getParameter(QUANTITY.toString()));
        } catch (NumberFormatException e) {
            LOG.debug("bad product parameter for price or quantity");
            errorModelAndView.addObject("errorMessage", "Price or quantity field does not correct");
            errorModelAndView.addObject("backUrl", "/newproductadd");
            errorModelAndView.addObject("urlMessage", "return and fill all field in form");
            return errorModelAndView;
        }

        Product createdProduct = new Product(name, description, price, quantity,
                productGroup, vendor, detail);
        LOG.debug("createdProduct = " + createdProduct);
        ProductsDAO productsDAO = new ProductsDAOImpl();
        productsDAO.insert(createdProduct);
        ModelAndView modelAndView = new ModelAndView("product/productAdded");
        modelAndView.addObject("createdProduct", createdProduct);

        return modelAndView;
    }

    private boolean isSomeFieldNotFilled(HttpServletRequest request) {
        if (request.getParameter(PRODUCT_NAME.toString()).isEmpty() ||
                request.getParameter(PRICE.toString()).isEmpty() ||
                request.getParameter(QUANTITY.toString()).isEmpty() ||
                request.getParameter(VENDOR.toString()).isEmpty() ||
                request.getParameter(DESCRIPTION.toString()).isEmpty() ||
                request.getParameter(DETAIL.toString()).isEmpty() ||
                request.getParameter(PRODUCT_GROUP.toString()).isEmpty()) {
            return true;
        }
        return false;
    }

    @RequestMapping("/productview")
    public ModelAndView productView() {
        LOG.debug("productView");
        ProductsDAO productDao = new ProductsDAOImpl();
        List<Product> productsList = productDao.getAll();
        ModelAndView modelAndView = new ModelAndView("product/productView");
        modelAndView.addObject("productsList", productsList);
        return modelAndView;
    }

    @RequestMapping("/singleproductview")
    public ModelAndView singleProductView(@RequestParam("productId") String productId) {
        LOG.debug("singleProductView");
        LOG.debug("productId=" + productId);
        ProductsDAO productDao = new ProductsDAOImpl();
        long productIdL = Long.parseLong(productId);
        Product product = (Product)productDao.getByID(productIdL);
        ModelAndView modelAndView = new ModelAndView("product/singleProductView");
        modelAndView.addObject("product", product);
        return modelAndView;
    }
    @RequestMapping("/productadd")
    public ModelAndView productAddToBasket(@RequestParam("productId") String productId,
                                           //@RequestParam(value="shoppingBasket", required = false) HashMap<Long, Product> shoppingBasket,
                                           HttpServletRequest request) {
        LOG.debug("productAddToBasket");
        LOG.debug("productId=" + productId);
        ModelAndView errorModelAndView = new ModelAndView("someErrorHappened");
        if (productId == null || productId.isEmpty()) {
            errorModelAndView.addObject("errorMessage", "Some error happened with buying");
            errorModelAndView.addObject("backUrl", "/productview");
            errorModelAndView.addObject("urlMessage", "return to all product");
        }
        HashMap<Long, Product> shoppingBasket = (HashMap<Long, Product>)request.getSession().getAttribute("shoppingBasket");
        if (shoppingBasket == null) {
            shoppingBasket = new HashMap<Long, Product>();
        }

        Product basketProduct = new Product();
        ProductsDAO productDao = new ProductsDAOImpl();
        Long productIdL = Long.parseLong(productId);
        Product product = (Product)productDao.getByID(productIdL);
        int quantity = product.getQuantity();
        if (quantity <= 0) {
            errorModelAndView.addObject("errorMessage", "You can't buy this product. The product has already ended");
            errorModelAndView.addObject("backUrl", "/productview");
            errorModelAndView.addObject("urlMessage", "return to all product");
        }
        if (shoppingBasket.get(productIdL) == null) {
            Product.copyProduct(product, basketProduct);
            basketProduct.setQuantity(1);
            shoppingBasket.put(productIdL, basketProduct);
        } else {
            int basketQuantity = shoppingBasket.get(productIdL).getQuantity();
            shoppingBasket.get(productIdL).setQuantity(++basketQuantity);
        }
        request.getSession().setAttribute("shoppingBasket", shoppingBasket);
        ModelAndView modelAndView = new ModelAndView("product/productAddedToBasket");
        modelAndView.addObject("shoppingBasket", shoppingBasket);
        modelAndView.addObject("changedProduct", basketProduct);
        return modelAndView;
    }


    @RequestMapping("/main")
    public ModelAndView main (HttpServletRequest request, HttpServletResponse response) {
        LOG.debug("Main page");
        ProductsDAO productsDAO = new ProductsDAOImpl();
        List<Product> productsList = productsDAO.getAll();
        ModelAndView modelAndView = new ModelAndView("mainView");
        modelAndView.addObject("productsList", productsList);
        return modelAndView;
    }

    @RequestMapping("/productdeleteserv")
    public ModelAndView productDelete(HttpServletRequest request, HttpServletResponse response) {

        LOG.debug("ProductDelete Start");
        Product delProduct;
        ProductsDAOImpl productsDAO = new ProductsDAOImpl();
        String productID = request.getParameter(ProductParams.PRODUCT_ID.toString());
        LOG.debug("productID=" + productID);
        ModelAndView errorModelAndView = new ModelAndView("someErrorHappened");
        if (productID.isEmpty()) {
            errorModelAndView.addObject("errorMessage", "Some parameters field does not filled");
            errorModelAndView.addObject("backUrl", "/productdel");
            errorModelAndView.addObject("urlMessage", "return and fill all field in form");
            return errorModelAndView;
        }
        long id;
        try {
            id = Long.parseLong(productID);
            LOG.debug("id=" + id);
        } catch (NumberFormatException e) {
            errorModelAndView.addObject("errorMessage", "ID field does not correct");
            errorModelAndView.addObject("backUrl", "/productdel");
            errorModelAndView.addObject("urlMessage", "return and fill all field in form");
            return errorModelAndView;
        }
        delProduct = productsDAO.getByID(id);
        LOG.debug("setId");
        if (delProduct == null) {
            errorModelAndView.addObject("errorMessage", "Product with this id: " + productID + " is absent");
            errorModelAndView.addObject("backUrl", "/productdel");
            errorModelAndView.addObject("urlMessage", "return and fill all field in form");
            return errorModelAndView;
        }

        productsDAO.delete(delProduct);
        LOG.debug("delete");

        ModelAndView modelAndView = new ModelAndView("product/productDeleted");
        modelAndView.addObject("deletedProduct", delProduct);

        LOG.debug("ProductDelete End");
        return modelAndView;
    }


    @RequestMapping("/productupdateserv")
    public ModelAndView productUpdate(HttpServletRequest request, HttpServletResponse response) {

        LOG.debug("ProductUpdate Start");
        Product filledProduct = getProductFromRequestContext(request);

        ProductsDAOImpl productsDAO = new ProductsDAOImpl();
        Integer productId = Integer.parseInt(request.getParameter(PRODUCT_ID.toString()));
        filledProduct.setId(productId);

        Product productFromDatabase = productsDAO.getByID(productId);
        Product productForUpdate = updateProductParameter(filledProduct, productFromDatabase);

        productsDAO.update(productForUpdate);
        ModelAndView modelAndView = new ModelAndView("product/productUpdated");
        modelAndView.addObject("updatedProduct", productForUpdate);
        return modelAndView;
    }

    private Product updateProductParameter(Product filledProduct, Product productFromDatabase) {
        Product productForUpdate = new Product();

        productForUpdate.setId(filledProduct.getID());

        String filledProductName = filledProduct.getName();
        productForUpdate.setName((filledProductName == null) ? productFromDatabase.getName()
                : filledProductName);

        String filledProductDescription = filledProduct.getDescription();
        productForUpdate.setDescription((filledProductDescription == null) ? productFromDatabase.getDescription()
                : filledProductDescription);

        Double filledProductPrice = filledProduct.getPrice();
        productForUpdate.setPrice((filledProductPrice == null) ? productFromDatabase.getPrice()
                : filledProductPrice);

        Integer filledProductQuantity = filledProduct.getQuantity();
        productForUpdate.setQuantity(filledProductQuantity == null ? productFromDatabase.getQuantity()
                : filledProductQuantity + productFromDatabase.getQuantity());

        String filledProductGroup = filledProduct.getGroup();
        productForUpdate.setGroup(filledProductGroup == null ? productFromDatabase.getGroup()
                : filledProductGroup);

        String filledProductVendor = filledProduct.getVendor();
        productForUpdate.setVendor(filledProductVendor == null ? productFromDatabase.getVendor()
                : filledProductVendor);

        String filledProductDetail = filledProduct.getDetail();
        productForUpdate.setDetail(filledProductDetail == null ? productFromDatabase.getDetail()
                : filledProductDetail);
        return productForUpdate;
    }

    private Product getProductFromRequestContext(HttpServletRequest request) {
        Product product = new Product();
        try {
            String parameter = getParameterFromContext(request, PRODUCT_ID);
            product.setId(parameter.isEmpty() ? null : Integer.parseInt(parameter));

            parameter = getParameterFromContext(request, PRODUCT_NAME);
            product.setName(parameter.isEmpty() ? null : parameter);

            parameter = getParameterFromContext(request, DESCRIPTION);
            product.setDescription(parameter.isEmpty() ? null : parameter);

            parameter = getParameterFromContext(request, PRODUCT_GROUP);
            product.setGroup(parameter.isEmpty() ? null : parameter);

            parameter = getParameterFromContext(request, VENDOR);
            product.setVendor(parameter.isEmpty() ? null : parameter);

            parameter = getParameterFromContext(request, DETAIL);
            product.setDetail(parameter.isEmpty() ? null : parameter);

            parameter = getParameterFromContext(request, PRICE);
            product.setPrice(parameter.isEmpty() ? null : Double.parseDouble(parameter));

            parameter = getParameterFromContext(request, QUANTITY);
            product.setQuantity(parameter.isEmpty() ? null : Integer.parseInt(parameter));
        } catch (NumberFormatException e) {
            LOG.debug("bad product parameter for price or quantity");
        }
        return product;
    }

    private String getParameterFromContext(HttpServletRequest request, ProductParams parameter) {
        LOG.debug("request.getParameter(parameter.toString()) " + request.getParameter(parameter.toString())
                + "equals" + request.getParameter(parameter.toString()).equals(""));
        return request.getParameter(parameter.toString());
    }


}

package com.yush.servlets.product;

import com.yush.dao.ProductsDAOImpl;
import com.yush.entity.Product;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.yush.servlets.product.ProductParams.*;


@WebServlet(name = "ProductUpdate")
public class ProductUpdate extends HttpServlet {
    private static final Logger log = Logger.getLogger(ProductUpdate.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("ProductUpdate Start");
        ProductParams[] arrayProductParams = values();
        for (ProductParams params : arrayProductParams) {
            log.debug(params + " " + request.getParameter(params.toString()));
            response.getWriter().println(params + " " + request.getParameter(params.toString()));
        }
        Product filledProduct = getProductFromRequestContext(request);
        response.getWriter().println("filledProduct " + filledProduct);

        ProductsDAOImpl productsDAO = new ProductsDAOImpl();
        if (productsDAO == null) {
            log.debug("productsDAO==null");
        }
        Integer productId = Integer.parseInt(request.getParameter(PRODUCT_ID.toString()));
        filledProduct.setId(productId);
        response.getWriter().println("productId " + productId);

        Product productFromDatabase = productsDAO.getByID(productId);
        response.getWriter().println("productFromDatabase " + productFromDatabase);
        Product productForUpdate = updateProductParemeter(filledProduct, productFromDatabase);

        response.getWriter().println("productForUpdate " + productForUpdate);
        productsDAO.update(productForUpdate);
    }

    private Product updateProductParemeter(Product filledProduct, Product productFromDatabase) {
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
            log.debug("bad product parameter for price or quantity");
        }
        return product;
    }

    private String getParameterFromContext(HttpServletRequest request, ProductParams parameter) {
        log.debug("request.getParameter(parameter.toString()) " + request.getParameter(parameter.toString())
                + "equals" + request.getParameter(parameter.toString()).equals(""));
        return request.getParameter(parameter.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

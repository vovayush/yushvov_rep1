package com.yush.controllers;


import com.yush.dao.ProductsDAO;
import com.yush.dao.ProductsDAOImpl;
import com.yush.entity.Product;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class NewProductAddController {
    private static final Logger LOG = Logger.getLogger(NewProductAddController.class);

    @RequestMapping("/newproductaddserv")
    public ModelAndView productAdd(HttpServletRequest request, HttpServletResponse response){
        ModelAndView errorModelAndView = new ModelAndView("someErrorHappened");

        if (isSomeFieldNotFilled(request)) {
            errorModelAndView.addObject("errorMessage", "Some parameters field does not filled");
            errorModelAndView.addObject("backUrl", "/newproductadd");
            errorModelAndView.addObject("urlMessage", "return and fill all field in form");
            return errorModelAndView;
        }
        String name = request.getParameter("productName");
        String description = request.getParameter("description");
        Double price;
        Integer quantity;
        String productGroup = request.getParameter("productGroup");
        String vendor = request.getParameter("vendor");
        String detail = request.getParameter("detail");
        try {
            price = Double.parseDouble(request.getParameter("price"));
            quantity = Integer.parseInt(request.getParameter("Quantity"));
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
        ModelAndView modelAndView = new ModelAndView("productAdded");
        modelAndView.addObject("createdProduct", createdProduct);
        ProductsDAO productsDAO = new ProductsDAOImpl();
        productsDAO.insert(createdProduct);
        return modelAndView;
    }

    private boolean isSomeFieldNotFilled(HttpServletRequest request) {
        if (request.getParameter("productName").isEmpty() ||
                request.getParameter("price").isEmpty() ||
                request.getParameter("Quantity").isEmpty() ||
                request.getParameter("vendor").isEmpty() ||
                request.getParameter("description").isEmpty() ||
                request.getParameter("detail").isEmpty() ||
                request.getParameter("productGroup").isEmpty()) {
            return true;
        }
        return false;
    }
}

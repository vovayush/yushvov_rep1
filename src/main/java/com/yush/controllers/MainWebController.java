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
import java.util.List;

@Controller
public class MainWebController {
    private static final Logger LOG = Logger.getLogger(MainWebController.class);

    @RequestMapping("/main")
    public ModelAndView main (HttpServletRequest request, HttpServletResponse response) {
        LOG.debug("Main page");
        ProductsDAO productsDAO = new ProductsDAOImpl();
        List<Product> productsList = productsDAO.getAll();
        /*if (productList != null) {
            for (Product value : productList) {
                response.getWriter().println("Name: " + value.getName());
                response.getWriter().println("Description: " + value.getDescription());
                response.getWriter().println("Price: " + value.getPrice());
                response.getWriter().println("Vendor: " + value.getVendor());
            }
        } else {
            LOG.debug("list=null");
        }*/
        ModelAndView modelAndView = new ModelAndView("mainView");
        LOG.debug("productsList = " + productsList);
        modelAndView.addObject("productsList", productsList);
        return modelAndView;
    }
}

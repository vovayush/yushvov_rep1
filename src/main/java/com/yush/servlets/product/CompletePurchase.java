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
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "CompletePurchase")
public class CompletePurchase extends HttpServlet {
    private static final Logger log = Logger.getLogger(CompletePurchase.class);
    ProductsDAOImpl productDao = new ProductsDAOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("doPst CompletePurchse");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashMap<Integer, Product> shoppingBacketMap = (HashMap) request.getSession().getAttribute("shoppingBasket");
        if (shoppingBacketMap != null) {
            if (verifyQuantityProduct(shoppingBacketMap)) {
                response.getWriter().println("verify true");
                changeProductInDao(shoppingBacketMap);
                response.getWriter().println("you bought");
                Double totalCost = 0.0;
                for (Map.Entry<Integer, Product> entry : shoppingBacketMap.entrySet()) {

                    Product value = entry.getValue();
                    response.getWriter().println(value.getName());
                    response.getWriter().println(value.getDescription());
                    response.getWriter().println(value.getQuantity());
                    totalCost += value.getPrice() * value.getQuantity();
                }
                response.getWriter().println("Total cost = " + totalCost);
                request.getSession().setAttribute("shoppingBacket", new HashMap<Integer, Product>());
            } else {
                response.getWriter().println("not enough things in warehouse");
            }
        } else {
            response.getWriter().println("shopping backet is empty");
        }

        response.getWriter().println("end");
    }

    private void changeProductInDao(HashMap<Integer, Product> map) {

        for (Map.Entry<Integer, Product> entry : map.entrySet()) {
            Product backetProduct = entry.getValue();
            Product baseProduct = productDao.getByID(backetProduct.getID());
            Integer quantity = baseProduct.getQuantity();
            if (quantity - backetProduct.getQuantity() >= 0) {
                baseProduct.setQuantity(quantity - backetProduct.getQuantity());
                productDao.update(baseProduct);
            }
        }
    }

    private boolean verifyQuantityProduct(HashMap<Integer, Product> map) {
        boolean result = true;
        for (Map.Entry<Integer, Product> entry : map.entrySet()) {
            Product value = entry.getValue();
            if (value.getQuantity() > productDao.getByID(entry.getKey()).getQuantity()) {
                result = false;
            }
        }
        return result;
    }
}

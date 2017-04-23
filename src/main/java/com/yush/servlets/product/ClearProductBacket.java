package com.yush.servlets.product;

import com.yush.entity.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;


@WebServlet(name = "ClearProductBacket")
public class ClearProductBacket extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("shoppingBacket", new HashMap<Integer, Product>());
        ServletContext context = getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/view/viewShoppingBasket.jsp");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("shoppingBacket", new HashMap<Integer, Product>());
        ServletContext context = getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/view/viewShoppingBasket.jsp");
        rd.forward(request, response);
    }
}

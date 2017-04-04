package com.yush.servlets.product;

import com.yush.dao.ProductsDAO;
import com.yush.dao.ProductsDAOImpl;
import com.yush.entity.Product;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductAdd")
public class ProductAdd extends HttpServlet {
    private static final Logger log = Logger.getLogger(ProductAdd.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.debug("ProductAdd Start");
        ServletContext context = getServletContext();
        if (isFullOptionInRequest(request)) {
            String name = request.getParameter("productName");
            String description = request.getParameter("decription");
            Double price = null;
            Integer quantity = null;
            String productGroup = request.getParameter("productGroup");
            String vendor = request.getParameter("vendor");
            String detail = request.getParameter("detail");
            try {
                price = Double.parseDouble(request.getParameter("price"));
                quantity = Integer.parseInt(request.getParameter("Quantity"));
            } catch (NumberFormatException e) {
                log.debug("bad product parameter for price or quantity");

                RequestDispatcher rd = context.getRequestDispatcher("/newproductadd");
                rd.forward(request, response);
            }

            Product createdProduct = new Product(name, description, price, quantity,
                    productGroup, vendor, detail);
            response.getWriter().println("New product added");
            response.getWriter().println("name: " + createdProduct.getName());
            response.getWriter().println("Description: " + createdProduct.getDescription());
            response.getWriter().println("price: " + createdProduct.getPrice());
            response.getWriter().println("quantity: " + createdProduct.getQuantity());
            response.getWriter().println("group: " + createdProduct.getGroup());
            response.getWriter().println("vendor: " + createdProduct.getVendor());
            response.getWriter().println("detail: " + createdProduct.getDetail());
            ProductsDAO productsDAO = new ProductsDAOImpl();
            productsDAO.insert(createdProduct);

            log.debug("ADD product");
        } else {
            RequestDispatcher rd = context.getRequestDispatcher("/newproductadd");
            rd.forward(request, response);
        }
    }

    private boolean isFullOptionInRequest(HttpServletRequest request) {
        if (request.getParameter("productName").isEmpty() ||
                request.getParameter("price").isEmpty() ||
                request.getParameter("Quantity").isEmpty() ||
                request.getParameter("vendor").isEmpty() ||
                request.getParameter("decription").isEmpty() ||
                request.getParameter("detail").isEmpty() ||
                request.getParameter("productGroup").isEmpty()) {
            return false;
        }
        return true;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

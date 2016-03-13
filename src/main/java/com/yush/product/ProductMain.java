package com.yush.product;

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
import java.util.List;


@WebServlet(name = "ProductMain")
public class ProductMain extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(ProductMain.class);


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/view/authentication.jsp");
        rd.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.debug("Main page");
        ProductsDAOImpl productsDAO = new ProductsDAOImpl();
        List<Product> productList = productsDAO.getAll();
        if (productList != null) {
            for (Product value : productList) {
                response.getWriter().println("Name: " + value.getName());
                response.getWriter().println("Description: " + value.getDescription());
                response.getWriter().println("Price: " + value.getPrice());
                response.getWriter().println("Vendor: " + value.getVendor());
            }
        } else {
            LOG.debug("list=null");
        }
        Product product2 = productsDAO.getByID(4);

        if (product2 != null) {
            response.getWriter().println("Name: " + product2.getName());
            response.getWriter().println("Description: " + product2.getDescription());
            response.getWriter().println("Price: " + product2.getPrice());
            response.getWriter().println("Vendor: " + product2.getVendor());
        } else {
            if (LOG.isDebugEnabled()) {
                LOG.debug("product2==null");
            }
        }
    }
}
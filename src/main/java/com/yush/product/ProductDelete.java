package com.yush.product;

import com.yush.dao.DAO;
import com.yush.dao.ProductsDAO;
import com.yush.dao.ProductsDAOImpl;
import com.yush.entity.Product;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "ProductDelete")
public class ProductDelete extends HttpServlet {
    private static final Logger log = Logger.getLogger(ProductDelete.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("ProductDelete Start");
        Product delProduct;
        ProductsDAOImpl productsDAO = new ProductsDAOImpl();
        String productID = request.getParameter(ProductParams.PRODUCT_ID.toString());
        log.debug("productID=" + productID);
        response.getWriter().println("productID" + productID);
        if (!productID.isEmpty()) {
            try {
                long id = Long.parseLong(productID);
                log.debug("id=" + id);
                delProduct = productsDAO.getByID(id);
                log.debug("setId");
                response.getWriter().println("delProduct" + delProduct);
                if (delProduct == null) {
                    response.getWriter().println("no product with this id" + productID);
                } else {
                    productsDAO.delete(delProduct);
                    log.debug("delete");
                    response.getWriter().println("Delete was successful");
                }
            } catch (Exception e) {
                log.info("Exception in ProductDelete" + e);
            }
        }
        log.debug("ProductDelete End");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

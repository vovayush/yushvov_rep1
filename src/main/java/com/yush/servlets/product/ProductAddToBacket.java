package com.yush.servlets.product;

import com.yush.dao.ProductsDAOImpl;
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


@WebServlet(name = "ProductAddToBacket")
public class ProductAddToBacket extends HttpServlet {
    HashMap<Integer, Product> shoppingBacket;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idS = request.getParameter("id");
        shoppingBacket = (HashMap) request.getSession().getAttribute("shoppingBacket");
        if (shoppingBacket == null) {
            shoppingBacket = new HashMap<Integer, Product>();
        }
        Integer id;
        Product product;
        Product backetProduct = new Product();
        ProductsDAOImpl productDao = new ProductsDAOImpl();

        if (idS != null && !idS.isEmpty()) {
            id = Integer.parseInt(idS);
            product = productDao.getByID(id);
            int quantity = product.getQuantity();
            if (quantity > 0) {

                if (shoppingBacket.get(id) == null) {
                    Product.copyProduct(product, backetProduct);
                    backetProduct.setQuantity(1);
                    shoppingBacket.put(id, backetProduct);
                } else {
                    int backetQuantity = shoppingBacket.get(id).getQuantity();
                    shoppingBacket.get(id).setQuantity(++backetQuantity);
                }
            }
            request.getSession().setAttribute("shoppingBacket", shoppingBacket);

        }
        ServletContext context = getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/view/singleProductView.jsp?id=" + idS);
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

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
    HashMap<Integer, Product> shoppingBasket;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idS = request.getParameter("id");

        shoppingBasket = (HashMap) request.getSession().getAttribute("shoppingBasket");
        if (shoppingBasket == null) {
            shoppingBasket = new HashMap<Integer, Product>();
        }
        Integer id;
        Product product;
        Product basketProduct = new Product();
        ProductsDAOImpl productDao = new ProductsDAOImpl();

        if (idS != null && !idS.isEmpty()) {
            id = Integer.parseInt(idS);
            product = productDao.getByID(id);
            int quantity = product.getQuantity();
            if (quantity > 0) {

                if (shoppingBasket.get(id) == null) {
                    Product.copyProduct(product, basketProduct);
                    basketProduct.setQuantity(1);
                    shoppingBasket.put(id, basketProduct);
                } else {
                    int basketQuantity = shoppingBasket.get(id).getQuantity();
                    shoppingBasket.get(id).setQuantity(++basketQuantity);
                }
            }
            request.getSession().setAttribute("shoppingBasket", shoppingBasket);

        }
        ServletContext context = getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/singleproductview?productId=" + idS);
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

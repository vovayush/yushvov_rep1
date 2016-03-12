<%@ page import="com.yush.entity.Product" %>
<%@ page import="com.yush.dao.ProductsDAO" %>
<%@ page import="com.yush.dao.ProductsDAOImpl" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
<p>Product map</p>
<p>
  <%
    ProductsDAO productDao = new ProductsDAOImpl();
    List<Product> productsList = productDao.getAll();
    for(Product product : productsList) {
      request.setAttribute("key",product.getID());
      request.setAttribute("name", product.getName());
      request.setAttribute("description", product.getDescription());
      request.setAttribute("cost", product.getPrice());

  %>
   Name=${name} <br>
  description=${description} <br>
  cost=${cost} <br>
  /view/singleProductView.jsp?id=${key} <br>
  <a href="/view/singleProductView.jsp?id=${key}">View more information</a> <br>
  <%}
  %>
</p>
</body>
</html>

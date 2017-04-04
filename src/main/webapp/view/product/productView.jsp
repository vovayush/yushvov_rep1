<%@ page import="com.yush.entity.Product" %>
<%@ page import="com.yush.dao.ProductsDAO" %>
<%@ page import="com.yush.dao.ProductsDAOImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="com.yush.entity.components.PrComment" %>
<%@ page import="com.yush.entity.components.Characteristic" %>
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
  <a href="/view/product/singleProductView.jspView.jsp?id=${key}">View more information</a> <br>
  <br>
  <%
      for(PrComment prComment : product.getPrComments()) {
        request.setAttribute("prComment", prComment.toString());

  %>

  Comment = ${prComment} <br>

  <%
      }
  %>
  <br>
  <%
    for(Characteristic characteristic : product.getCharacteristics()) {
      request.setAttribute("characteristic", characteristic.toString());

  %>

  Characteristic = ${characteristic} <br>

  <%
    }
  %>
  <br>
  <br>
  <%
    }
  %>
</p>
</body>
</html>

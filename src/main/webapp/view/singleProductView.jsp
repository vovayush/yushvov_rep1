<%@ page import="com.yush.entity.Product" %>
<%@ page import="com.yush.dao.ProductsDAOImpl" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product View</title>
</head>
<body>
<%
String ids = request.getParameter("id");
%>
<% if (ids != null && !ids.equals("")) {
    long id = Long.parseLong(ids);
    ProductsDAOImpl productDao = new ProductsDAOImpl();
    Product product = productDao.getByID(id);
    request.setAttribute("name", product.getName());
    request.setAttribute("description", product.getDescription());
    request.setAttribute("cost", product.getPrice());
  }
%>
 Name=${name} <br>
description=${description} <br>
cost=${cost} <br>
<form action="/productadd?id=<%= request.getParameter("id") %>" method="POST">
   <input type="submit" value="buy"/>
</form>
<a href="/view/viewShopingBacket.jsp">View shoping backet?</a><br>

<a href="/view/productView.jsp">back to all products</a> <br>
</body>
</html>

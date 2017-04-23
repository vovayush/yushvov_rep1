<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
<p>Product map</p>
<p>
  <c:forEach var="product" items="${productsList}">
    Name:                ${product.name} <br>
    Product description: ${product.description} <br>
    Product group:       ${product.group} <br>
    Vendor:              ${product.vendor} <br>
    Product detail:      ${product.detail} <br>
    Price:               ${product.price} <br>
    <a href="/singleproductview?productId=${product.ID}">View more information</a> <br>
    <br>
    <c:forEach var="comment" items="${product.prComments}">
      Comment = ${comment} <br>
    </c:forEach>
    <br>
    <c:forEach var="characteristic" items="${product.characteristics}">
      Characteristic = ${characteristic} <br>
    </c:forEach>
    <br>
  </c:forEach>
</p>
</body>
</html>

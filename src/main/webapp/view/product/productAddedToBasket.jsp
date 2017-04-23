<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Product added</title>
</head>
<body>
<p>Product was added Successfully</p>

Name=${requestScope.changedProduct.name} <br>
description=${requestScope.changedProduct.description} <br>
price=${requestScope.changedProduct.price} <br>
<a href="/productview">Product view page</a> <br>
<a href="/view/viewShoppingBasket.jsp">View shopping basket</a><br>


</body>
</html>
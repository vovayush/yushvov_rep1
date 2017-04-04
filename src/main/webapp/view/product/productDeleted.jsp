
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product deleted</title>
</head>
<body>
<p>Product was deleted Successfully</p>

Name=${requestScope.deletedProduct.name} <br>
description=${requestScope.deletedProduct.description} <br>
price=${requestScope.deletedProduct.price} <br>

<a href="index.jsp">start page</a> <br>

</body>
</html>

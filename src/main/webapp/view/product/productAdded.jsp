
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product added</title>
</head>
<body>
<p>Product was added Successfully</p>

Name=${requestScope.createdProduct.name} <br>
description=${requestScope.createdProduct.description} <br>
price=${requestScope.createdProduct.price} <br>
<a href="index.jsp">start page</a> <br>

</body>
</html>

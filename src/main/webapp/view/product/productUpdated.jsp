
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product updated</title>
</head>
<body>
<p>Product was updated Successfully</p>

Name=${requestScope.updatedProduct.name} <br>
description=${requestScope.updatedProduct.description} <br>
price=${requestScope.updatedProduct.price} <br>
<a href="index.jsp">start page</a> <br>

</body>
</html>

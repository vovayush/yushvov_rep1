<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main Product View</title>
</head>
<body>
<h1>All Products</h1>


<c:forEach var="product" items="${productsList}">
    Name:                ${product.name} <br>
    Product description: ${product.description} <br>
    Product group:       ${product.group} <br>
    Vendor:              ${product.vendor} <br>
    Product detail:      ${product.detail} <br>
    Price:               ${product.price} <br>
    <br>
</c:forEach>

</body>
</html>

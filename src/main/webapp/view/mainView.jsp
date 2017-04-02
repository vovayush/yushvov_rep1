<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main Product View</title>
</head>
<body>
<h1>All Products</h1>


<c:forEach var="product" items="${productsList}">
    <c:out value="${product.name}"/> <br>
    <c:out value="${product.description}"/> <br>
    <c:out value="${product.group}"/> <br>
    <c:out value="${product.vendor}"/> <br>
    <c:out value="${product.detail}"/> <br>
    <c:out value="${product.price}"/> <br>
    <br> <br>
</c:forEach>

</body>
</html>

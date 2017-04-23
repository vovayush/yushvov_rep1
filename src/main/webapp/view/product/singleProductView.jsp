
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product View</title>
</head>
<body>
Name:                ${requestScope.product.name} <br>
Product description: ${requestScope.product.description} <br>
Product group:       ${requestScope.product.group} <br>
Vendor:              ${requestScope.product.vendor} <br>
Product detail:      ${requestScope.product.detail} <br>
Price:               ${requestScope.product.price} <br>

<form action="/productadd?productId=${requestScope.product.ID}" method="POST">
   <input type="submit" value="buy"/>
</form>
<a href="/view/viewShoppingBasket.jsp">View shopping basket</a><br>

<a href="/productview">back to all products</a> <br>
</body>
</html>

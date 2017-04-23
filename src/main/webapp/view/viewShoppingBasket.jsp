<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>viewShoppingBasket</title>
</head>
<body>
<c:set var="totalCost" value="${0}"/>
  <c:forEach items="${shoppingBasket}" var="entry">
    Item = ${entry.key}<br>
    Name=${entry.value.name}<br>
    Description=${entry.value.description}<br>
    Price=${entry.value.price}<br><br>
    <c:set var="totalCost" value="${totalCost + entry.value.price}" />
  </c:forEach>

<br>
<br>
<a href="/productview">back to products</a> <br>
<a href="/completepurchase">Compleate this purchase</a> <br>
<a href="/clearbacket">Clear product backet</a> <br>
totalCost = ${totalCost} <br>
</body>
</html>

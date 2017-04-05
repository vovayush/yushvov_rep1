
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<p><strong>You should fill field that you want to change Product</strong></p>
<form action="productupdateserv" method="POST">
  Product ID*: &nbsp;&nbsp;
  <input type="text" name="PRODUCT_ID"/><br>
  <br>
  <%@include file="productField.jsp" %>
  <input type="submit" value="Submit"/>
</form>
</body>
</html>

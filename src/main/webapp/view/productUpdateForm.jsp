
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<p><strong>You should fill field that you want to change Product</strong></p>
<form action="productupdateserv" method="POST">
  Product ID*:  <input type="text" name="PRODUCT_ID"/><br>
  <br>
  Product Name:  <input type="text" name="PRODUCT_NAME"/><br>
  <br>
  Price:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <input type="text" name="PRICE"/><br>
  <br>
  Quantity:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <input type="text" name="QUANTITY"/><br>
  <br>
  Product group: <input type="text" name="PRODUCT_GROUP"/> <br>
  <br>
  Vendor: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <input type="text" name="VENDOR"/> <br>
  <br>
  Description:&nbsp;&nbsp;&nbsp;&nbsp;
  <input type="text" name="DESCRIPTION"/> <br>
  <br>
  Detail:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <input type="text" name="DETAIL"/> <br>
  <br>
  <input type="submit" value="Submit"/>
</form>
</body>
</html>

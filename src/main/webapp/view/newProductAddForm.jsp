<%--

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>

<body>
<p><strong>You should fill in all field for Product add</strong></p>
<form action="newproductaddserv" method="POST">
    Product Name:  <input type="text" name="productName"/><br>
    <br>
    Price:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="text" name="price"/><br>
    <br>
    Quantity:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="text" name="Quantity"/><br>
    <br>
    Product group: <input type="text" name="productGroup"/> <br>
    <br>
    Vendor: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="text" name="vendor"/> <br>
    <br>
    Description:&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="text" name="decription"/> <br>
    <br>
    Detail:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="text" name="detail"/> <br>
    <br>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>

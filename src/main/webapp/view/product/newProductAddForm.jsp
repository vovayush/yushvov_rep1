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
    <%@include file="productField.jsp" %>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>

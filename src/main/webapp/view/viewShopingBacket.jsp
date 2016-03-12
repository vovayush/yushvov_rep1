<%@ page import="com.yush.entity.Product" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>viewShopingBacket</title>
</head>
<body>
<%
  Double totalCost=0.0;
  HashMap<Integer, Product> map = (HashMap)request.getSession().getAttribute("shoppingBacket");
  if (map!=null) {
  for(Map.Entry<Integer, Product> entry : map.entrySet()) {

    Product value = entry.getValue();
    totalCost+=value.getPrice()*value.getQuantity();

    request.setAttribute("name", value.getName());
    request.setAttribute("description", value.getDescription());
    request.setAttribute("quantity", value.getQuantity());
    request.setAttribute("totalCost",totalCost);
    request.setAttribute("cost",value.getPrice());

%>
Name=${name} <br>
description=${description} <br>
cost=${cost} <br>
quantity=${quantity} <br>
<br>
<%}
}
%>
<br>
<br>
<a href="/view/productView.jsp">back to products</a> <br>
<a href="/completepurchase">Compleate this purchase</a> <br>
<a href="/clearbacket">Clear product backet</a> <br>
totalCost = ${totalCost} <br>
</body>
</html>

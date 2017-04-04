<%@ page import="com.yush.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.yush.dao.UsersDAO" %>
<%@ page import="com.yush.dao.UsersDAOImpl" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test</title>
</head>
<body>
<p>test</p>
<p>User map</p>
<p>
 <%
     UsersDAO usersDAO = new UsersDAOImpl();
   List<User> userList = usersDAO.getAll();
   for(User user : userList) {
     long key = user.getID();
     String login = user.getLogin();
     request.setAttribute("key",key);
     request.setAttribute("login", login);
 %>
  key=${key}   Login=${login}  <br>
  <%}
      %>
</p>
<form action="/main" method="POST">

  <input type="submit" value="To Authentication"/>
</form>
</body>
</html>
<%@ page import="com.yush.dao.UsersDAOImpl" %>
<%@ page import="com.yush.dao.UsersDAO" %>
<%@ page import="com.yush.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.yush.entity.components.Email" %>
<%@ page import="com.yush.entity.components.Phone" %>
<%@ page import="com.yush.entity.components.Address" %>
<%@ page import="com.yush.entity.components.PrComment" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>allUsersView</title>
</head>
<body>
  <%
    UsersDAO usersDao = new UsersDAOImpl();
    List<User> usersList = usersDao.getAll();
    for(User user : usersList) {
      request.setAttribute("ID",user.getID());
      request.setAttribute("FirstName", user.getFirstName());
      request.setAttribute("LastName", user.getLastName());
      request.setAttribute("Login", user.getLogin());
      request.setAttribute("Password", user.getPassword());
      request.setAttribute("Description", user.getDescription());

  %>
  ID = ${ID} <br>
  FirstName = ${FirstName} <br>
  LastName = ${LastName} <br>
  Login = ${Login} <br>
  Password = ${Password} <br>
  Description = ${Description} <br>
  <br>
  <%
     for(Email email : user.getEmails()) {
        request.setAttribute("email", email.toString());
  %>

  Email = ${email} <br>

  <%
      }
  %>
  <br>
  <%
    for(Phone phone : user.getPhones()) {
      request.setAttribute("phone", phone.toString());
  %>
  Phone = ${phone} <br>
  <%
      }
  %>
  <br>
  <%
    for(Address address : user.getAddresses()) {
      request.setAttribute("address", address.toString());
  %>
  Address = ${address} <br>
  <%
    }
  %>
  <br>
  <%
    for(PrComment prComment : user.getPrComments()) {
      request.setAttribute("prComment", prComment.toString());
  %>
  Comment = ${prComment} <br>
  <%
    }
  %>
      <br>
      <br>
  <%
    }
  %>
  /view/singleUserView.jsp?id=${ID} <br>
  <a href="/view/singleUserView.jsp?id=${ID}">View more information</a> <br>
  </p>

%>
</body>
</html>
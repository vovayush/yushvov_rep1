
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>NewUserForm</title>
</head>
<body>
<p><strong>You should fill in all field for registration</strong></p>
<form action="regcheck" method="POST">
  First Name: <input type="text" name="firstName"/>
  <br>
  Last Name: <input type="text" name="lastName"/>
  <br>
  Login: <input type="text" name="login"/>
  <br />
  Password: <input type="text" name="password"/> <br>
  <br />
  Description: <input type="text" name="description"/> <br>
  <input type="submit" value="Submit"/>
</form>

</body>
</html>

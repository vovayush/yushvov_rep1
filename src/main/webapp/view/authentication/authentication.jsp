
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authentication page</title>
</head>
<body>
<%
  Boolean badAuthentication = (Boolean)request.getSession().getAttribute("badAuthentication");
  if(badAuthentication != null){
    if (badAuthentication){
      badAuthentication = false;
      request.getSession().setAttribute("badAuthentication", badAuthentication);
      %> <p><strong>Bad login or password.<br>
  Please try again.
</strong></p>
<%
    }
  }

%>
<form action="authcheck" method="POST">
  <input type="checkbox" name="isNewClient" /> If you are new client check this <br>
  Login: <input type="text" name="login"/>
  <br />
  Password: <input type="text" name="password"/> <br>
  <input type="submit" value="Submit"/>
</form>

</body>
</html>

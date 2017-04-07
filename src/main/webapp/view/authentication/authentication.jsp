
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
  <input type="checkbox" name="isNewClient" /> If you are new client check this <br><br>
  <label for="login"> Login:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
  <input type="text" name="login" id="login"/><br><br>
  <label for="password">Password:&nbsp;</label>
  <input type="text" name="password" id="password"/> <br><br>
  <input type="submit" value="Submit"/>
</form>

</body>
</html>

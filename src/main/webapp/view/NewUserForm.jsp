
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>NewUserForm</title>
</head>
<body>
<p><strong>You should fill in all field for registration</strong></p>
<form action="regcheck" method="POST">
  First Name: <input type="text" name="firstName"/><br>
  <br>
  Last Name: <input type="text" name="lastName"/><br>
  <br>
  Login: <input type="text" name="login"/><br>
  <br />
  Password: <input type="text" name="password"/> <br>
  <br />
  Description: <input type="text" name="description"/> <br>
  <br />
  Email: <input type="text" name="email"/> <br>
  <br />
  Phone: <input type="text" name="phone"/> <br>
  <br />
  <br />
  <input type="checkbox" name="address" /> If you want to add new address you will have check address field
  and fill address parameter <br>
  <br />
  Country: <input type="text" name="country"/>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  Region: <input type="text" name="region"/> <br>
  <br />
  Raion: <input type="text" name="raion"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  Locality: <input type="text" name="locality"/> <br>
  <br />
  Street: <input type="text" name="streetName"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  Number: <input type="text" name="number"/> <br>
  <br />
  Apartment: <input type="text" name="apartment"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  Advanced: <input type="text" name="advanced"/> <br>

  <input type="submit" value="Submit"/>
</form>

</body>
</html>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>NewUserForm</title>
</head>
<body>
<p><strong>You should fill in all field for registration</strong></p>
<form action="regcheck" method="POST">
  <label for="firstName">First Name:&nbsp;</label>
  <input type="text" name="firstName" id="firstName"/><br>
  <br>
  <label for="lastName">Last Name:&nbsp;</label>
  <input type="text" name="lastName" id="lastName"/><br>
  <br>
  <label for="login">Login:&nbsp;&nbsp;&nbsp;</label>
  <input type="text" name="login" id="login"/><br>
  <br/>
  <label for="password">Password:&nbsp;</label>
  <input type="text" name="password" id="password"/> <br>
  <br/>
  <label for="description">Description:&nbsp;</label>
  <input type="text" name="description" id="description"/> <br>
  <br/>
  <label for="email">Email:&nbsp;&nbsp;&nbsp;&nbsp;</label>
  <input type="text" name="email" id="email"/> <br>
  <br/>
  <label for="phone">Phone:&nbsp;&nbsp;&nbsp;&nbsp;</label>
  <input type="text" name="phone" id="phone"/> <br>
  <br/>
  <br/>
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

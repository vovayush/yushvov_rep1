
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<h1>Error</h1>
Description: ${requestScope.errorMessage} <br>
<a href="${requestScope.backUrl}">${requestScope.urlMessage}</a> <br>

</body>
</html>

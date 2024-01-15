<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>

<form method="POST" action="${pageContext.request.contextPath}/login">
    <label>Username</label>
    <input type="text" name="username">
    <br>
    <label>Password</label>
    <input type="password" name="password">
    <br>
    <button>Login</button>
    <br>
    <% if (request.getParameter("error") != null) {%>
    <p>Invalid username or password. Please try again.</p>
    <% } %>
</form>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: admin1
  Date: 15/06/20
  Time: 4:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
</head>
<body>
<div class="login-box">
    <form action="register" method="post">
        <div style="font-family: Arial;font-size:25px;font-weight:700;text-align: center;padding:10px">
            Registration Page
        </div>
        ${error}
        <div>
            <input type="text" name="name" placeholder="Enter username">
        </div>
        <div>
            <input type="text" name="address" placeholder="Enter address">
        </div>
        <div>
            <input type="password" name="password" placeholder="Enter password">
        </div>
        <div>
            <input type="email" name="email" placeholder="Enter email">
        </div>
        <div>
            <input type="submit" name="submit" value="Register">
        </div>
        <div style="font-family: Arial;font-size:12px;font-weight: 700;text-align: center;padding: 30px">
            <a href="login">Login</a>
        </div>
    </form>
</body>
</html>
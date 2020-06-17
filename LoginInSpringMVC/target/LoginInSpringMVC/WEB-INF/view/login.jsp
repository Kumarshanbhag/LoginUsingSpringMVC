<%@ page import="java.util.Map" %>
<%@ page import="org.springframework.web.servlet.ModelAndView" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: admin1
  Date: 14/06/20
  Time: 7:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
</head>
<body>
<form action="login" method="post">
    <div class="login-box">
        <div style="font-family: Arial;font-size:25px;font-weight: 700;text-align: center;padding: 10px">
            Login Form
        </div>
        ${error}
        <div>
            <input type="text" name="name" placeholder="Enter Username">
        </div>
        <div>
            <input type="password" name="password" placeholder="Enter Password">
        </div>
        <div>
            <input type="submit" name="submit" value="Login">
        </div>
        <div style="font-family: Arial;font-size:12px;font-weight: 700;text-align: center;padding: 30px">
            <a href="register">Registration</a>
        </div>
    </div>
</form>
</body>
</html>
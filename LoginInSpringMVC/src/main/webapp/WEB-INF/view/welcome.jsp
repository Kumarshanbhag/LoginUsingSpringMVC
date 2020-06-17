<%--
  Created by IntelliJ IDEA.
  User: admin1
  Date: 15/06/20
  Time: 2:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
    <style>
        .card {
            margin: 100px auto;
            padding: 20px;
            width: 400px;
            box-shadow: 0px 0px 10px silver;
            background-color: white;
        }
    </style>
</head>
<body>
<div class="card">
    <div style="padding:10px 5px">
        <h1>
            <center>Welcome ${username}</center>
        </h1>
        <div style="padding:5px">
            <h3>Your Details Are :</h3>
        </div>
        <div style="padding:5px">
            <h4>Username : ${user.username}</h4>
        </div>
        <div style="padding:5px">
            <h4>Address: ${user.address} </h4>
        </div>
        <div style="padding:5px">
            <h4>EmailID : ${user.email} </h4>
        </div>
    </div>
    <%--<div class="card">--%>
    <%--<h1><center>Welcome ${username}</center></h1>--%>
    <%--<h2>your Details Are : </h2>--%>
    <%--Password : ${user.password}--%>
    <%--Address: ${user.password}--%>
    <%--EmailID : ${user.email}--%>
    <%--</div>--%>
</body>
</html>

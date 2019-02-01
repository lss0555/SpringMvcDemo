<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=9"/>
<head>
    <meta charset="utf-8">
    <title>用户主页</title>
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container ">

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a style="color: white" class="navbar-brand" href="#">个人主页</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a style="color: red" href="/user/loginOut">安全退出</a></li>
        </ul>
    </div>
</nav>

<div style="margin-top: 120px" class="jumbotron">
    <h1>欢迎您</h1>
    <p class="p">用户名:${user.username}</p>
</div>
</body>
</html>
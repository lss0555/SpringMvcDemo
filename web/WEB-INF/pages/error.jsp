<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <meta name="keywords" content="">
    <meta name="description" content="">
    <style type="text/css">
        body {
            font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
            font-size: 13px;
            color: #676a6c;
            overflow-x: hidden;
        }
        .gray-bg {
            background-color: #f0f3f4;
        }
        .middle-box {
            max-width: 400px;
            z-index: 100;
            margin: 0 auto;
            padding-top: 40px;
        }
        .fadeInDown {
            -webkit-animation-name: fadeInDown;
            animation-name: fadeInDown;
        }
        .animated {
            -webkit-animation-duration: 1s;
            animation-duration: 1s;
            -webkit-animation-fill-mode: both;
            animation-fill-mode: both;
            z-index: 100;
        }
        .text-center {
            text-align: center;
        }
        .middle-box h1 {
            font-size: 170px;
        }
        .font-bold {
            font-weight: 600;
        }
        .h1, .h2, .h3, h1, h2, h3 {
            margin-top: 20px;
            margin-bottom: 10px;
        }
    </style>
</head>

<body class="gray-bg">


    <div class="middle-box text-center animated fadeInDown">
        <h3 class="font-bold">发生错误啦...</h3>

        <div class="error-desc">
           错误信息:${msg}
        </div>
    </div>
    

</body>

</html>

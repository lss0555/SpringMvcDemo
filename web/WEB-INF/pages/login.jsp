<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=9"/>
<head>
    <meta charset="utf-8">
    <title>登录界面</title>
    <script type="text/javascript" src="https://lib.baomitu.com/jquery/3.3.1/jquery.js"></script>
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.14.0/jquery.validate.min.js"></script>
    <script type="text/javascript" src="https://lib.baomitu.com/layer/3.1.1/layer.js"></script>
    <style>
        .signinpanel {
            margin-top: 100px;
        }

        .row-centered {
            text-align: center;
        }

        .col-centered {
            display: inline-block;
            float: none;
            text-align: left;
        }
    </style>
</head>
<body class="container ">
<div class="signinpanel">
    <div class="row  row-centered">
        <div class="col-centered">
            <div id="loginui" style="background-color: lightskyblue; padding: 28px;border-radius: 8px; ">
                <div style="height: 60px;">
                    <h3 style="text-align: center;color: gray; font-size: 30px;font-weight:bold; ">登录中心</h3>
                </div>
                <div class="form-group">
                    <input name="username" class="form-control uname" id="username" placeholder="请输入您的用户名">
                </div>

                <div style="padding: 1px" class="form-group">
                    <input name="password" type="password" class="form-control pword m-b" id="password"
                           placeholder="请输入您的密码">
                </div>
                <div class="submit">
                    <button style="border-radius:8px;" onclick="login()" class="btn btn-lg  btn-login btn-block">登录
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    function login() {
        var username = $('#username').val();
        var password = $('#password').val();
        if (username == "") {
            layer.msg("请填写您的用户名");
            $("#username").focus();
        } else if (password == "") {
            layer.msg("请填写您的密码");
            $("#password").focus();
        } else {
            layer.load(2);
            $.ajax({
                url: "/user/login",
                type: 'POST',
                data: {
                    username: username,
                    password: password
                },
                dataType: 'json',
                success: function (json) {
                    layer.closeAll();
                    if (json.errorCode == 0) {
                        layer.msg("登录成功");
                        location.href = "/user/index";
                    } else {
                        layer.msg(json.errorMsg);
                    }
                },
                error:function(json){
                    layer.closeAll();
                    layer.msg("抱歉,发生错误："+ json.status);
                }
            });
        }
    }
</script>
</html>
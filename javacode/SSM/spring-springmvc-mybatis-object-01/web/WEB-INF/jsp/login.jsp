<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>用户登录界面</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />

    <link rel="stylesheet"  href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet"  href="${pageContext.request.contextPath}/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet"  href="${pageContext.request.contextPath}/fonts/iconic/css/material-design-iconic-font.min.css">
    <link rel="stylesheet"  href="${pageContext.request.contextPath}/css/util.css">
    <link rel="stylesheet"  href="${pageContext.request.contextPath}/css/main.css">
    <style>
        *{margin:0;padding:0;}
        body {
            width: 100vw;
            height: 100vh;
            background: linear-gradient(to bottom, #57c1eb 0%,#55bbdd 50%, #246fa8 100%);
            z-index: 0;

        }
        .limiter{
            z-index: 100;
        }
    </style>
</head>

<body>

<div class="limiter">
    <div class="container-login100" >
        <div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
            <form action="${pageContext.request.contextPath}/login/userloginCheck" method="post" class="login100-form validate-form">
                <span class="login100-form-title p-b-49">用 户 登 录</span>

                <div class="wrap-input100 validate-input m-b-23" data-validate="请输入用户名">
                    <span class="label-input100" >用户名</span>
                    <input class="input100" id="name" type="text" name="code" placeholder="请输入用户名" autocomplete="off" onblur="a1()" onclick="a2()">
                    <span id="nameInfo" style="display: inline;position: absolute;right: 2px;top: 40px"></span>
                    <span class="focus-input100"  data-symbol="&#xf206;"></span>
                </div>

                <div class="wrap-input100 validate-input" data-validate="请输入密码" onclick="a2()">
                    <span class="label-input100">密码</span>
                    <input class="input100" id="pass" type="password" name="pass" placeholder="请输入密码">
                    <span class="focus-input100" id="passInfo" data-symbol="&#xf190;"></span>
                </div>
                <div>
                    <span id="msg_1" style="position: relative;color: red;left: 10em;top:20px">${msg}</span>
                </div>
                <div>
                    <br>
                    <br>
                    <br>
                </div>

                <div class="container-login100-form-btn">
                    <div class="wrap-login100-form-btn">
                        <div class="login100-form-bgbtn"></div>
                        <button class="login100-form-btn" >登 录</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
<%--<script type="text/javascript" src="${pageContext.request.contextPath}/js/snowflakes.min.1.0.0.js"></script>--%>
<%--<script type="text/javascript" src="${pageContext.request.contextPath}/js/snow.js"></script>--%>
<%--<script src="${pageContext.request.contextPath}/js/main.js"></script>--%>
<script type="text/javascript">
    function a1(){
        $.post({
            url:"${pageContext.request.contextPath}/login/login",
            data:{"code":$('#name').val()},//要上传的数据
            success:function (data) {
                if (data.toString()=="O"||data.toString()=="P"){//信息核对成功
                    $('#nameInfo').css("color","green");
                    $('#nameInfo').html("O");
                }else{
                    $('#nameInfo').css("color","red");
                    $('#nameInfo').html("X");
                }
            }
        })
    };
    function a2(){
        $('#msg_1').hide();
    }
</script>
</body>

</html>
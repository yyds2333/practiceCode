<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminlogin.css">
</head>
<body>
<div class="login">
    <div class="login_title">
        <p>开放实验室预约管理系统</p>
    </div>
    <div class="login_main">
        <div class="main_left"></div>
        <div class="main_right">
            <div class="right_title">管理员登录</div>
            <form action="${pageContext.request.contextPath}/login/adminloginCheck" method="post">
                <div class="username">
                    <img src="${pageContext.request.contextPath}/images/username.png" alt="">
                    <input type="text" id="code" name="code" placeholder="请输入用户名" onblur="a1()" onclick="a2()">
                    <span id="codeInfo" style="display:inline-block;position: absolute;top:6px;right: 30px"></span>
                </div>
                <div class="password">
                    <img src="${pageContext.request.contextPath}/images/password.png" alt="">
                    <input type="password" id="pass1" name="pass" placeholder="请输入密码" onclick="a2()">
                    <span id="passInfo"></span>
                </div>
                <div>
                    <span style="text-align: center;color: #ff0000;position: relative;bottom: 15px;left: 130px" id="msg_1">${msg}</span>
                </div>
                <div class="yes_login" ><input id="upToServer" type="submit" value="登录" style="background: linear-gradient(to left,#9fcdff 0%,#dddddd 50%,#00dbde 100%);padding: 0"></div>
                <center><p style="margin-top:20px;font-size:12px;color:#FA6F03;">登录遇到问题，请联系技术人员</p></center>
            </form>
        </div>
    </div>
    <div class="login_footer">
        <p class="name">版权所有：YYDS</p>
        <p>建议浏览器：IE8及以上、360、谷歌、Firefox v22</p>
        <p>技术支持：南阳师范学院软件学院 &nbsp;&nbsp;联系电话：00396-000000  </p>
    </div>
</div>

<script src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"></script>
<script>
    function a1(){
        console.log($("#code").val());
        $.post({
            url:"${pageContext.request.contextPath}/login/login",
            data:{'code':$('#code').val()},
            success:function (data) {
                console.log(data.toString());
                if (data.toString() == "P"){
                    $('#codeInfo').css("color","green");
                }else if (data.toString() == "O"){
                    $('#codeInfo').css("color","orange");
                    // 条件不满足禁用标签
                }else{
                    $('#codeInfo').css("color","red");
                }
                $('#codeInfo').html(data.toString());
            }
        })
    };
    function a2(){
        $('#msg_1').hide();
    }
</script>
</body>
</html>
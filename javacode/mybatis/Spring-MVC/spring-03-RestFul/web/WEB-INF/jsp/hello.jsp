
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/web/js/jquery-1.8.2.min.js"></script>
    <script>

        var url="/tt";
        var data={"username":$("#username").val()};
        var success=function (data){
            if (data.toString()==="ok"){
                $("#usernameInfo").css("color","green");
            }else{
                $("#passwordInfo").css("color","red");
            }
            $("#usernameInfo").html(data);
        };
        function a1(){
            alert("tou");
            jQuery.post(url,data,success(data))
            alert("wei");
        }
        function a2(){
            $.post({
                url:"${pageContext.request.contextPath}/tt",
                data:{"password":$("#password").val()},
                success:function (data){
                    if (data.toString()==="ok"){
                        $("#passwordInfo").css("color","green");
                    }else{
                        $("#passwordInfo").css("color","red");
                    }
                    $("#passwordInfo").html(data);
                }
            })
        }
    </script>
</head>
<body>
用户名：<input type="text" id="username" onblur="a1()">
<span id="usernameInfo"></span>
密码：<input type="password" id="password" onblur="a2()">
<span id="passwordInfo"></span>
</body>
</html>

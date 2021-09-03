<%--
  Created by IntelliJ IDEA.
  User: 杨亚迪
  Date: 4/28/2021
  Time: 3:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer.css">
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
</style>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12">
            <h1 class="text-center">个人中心</h1>
        </div>
    </div>
</div>

<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <div class="row-fluid">
                <div class="span12">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>
                                个人信息
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>
                                <div>
                                    <label>登录账号</label>
                                    <input type="text" class="form-control" name="code" value="${user.code}" readonly required/>
                                </div>
                            </td>
                        </tr>
                        <tr class="success">
                            <td>
                                <div>
                                    <label>姓名</label>
                                    <input type="text" class="form-control" name="user_name" value="${user.user_name}" readonly required/>
                                </div>
                            </td>
                        </tr>
                        <tr class="error">
                            <td>
                                <div >
                                    <label>密码</label>
                                    <input type="text" class="form-control" name="password" value="${user.password}" readonly required/>
                                    <button class="btn btn-primary layui-btn-lg" style="display: inline-block" data-toggle="modal" data-target="#myModal">
                                        修改密码
                                    </button>
                                </div>
                            </td>
                        </tr>
                        <tr class="warning">
                            <td>
                                <div >
                                    <label>性别</label>
                                    <input type="number" class="form-control" name="sex"   value="${user.sex}" readonly required/>
                                </div>
                            </td>
                        </tr>
                        <tr class="info">
                            <td>
                                <div >
                                    <label>年龄</label>
                                    <input type="number" class="form-control" name="age" value="${user.age}" readonly required/>
                                </div>
                            </td>
                        </tr>
                        <tr class="error">
                            <td>
                                <div >
                                    <label>电话号码</label>
                                    <input type="number" class="form-control" name="tel_number" value="${user.tel_number}" readonly required/>
                                </div>
                            </td>
                        </tr>
                        <tr class="error">
                            <td>
                                <div >
                                    <label>角色权限</label>
                                    <input type="number" class="form-control" name="roleId" value="${user.roleId}" readonly required/>
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>


    <div class="modal fade " id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        修改密码
                    </h4>
                </div>
                <div class="modal-body right-auto">
                    <form action="${pageContext.request.contextPath}/client/getUpPasswordPage">
                        <div class="text-center">
                            <input type="text" id="oldP" name="oldPass" placeholder="请输入旧密码" value="" onblur="checkOldP()">
                            <span id="oldPInfo" class="layui-inline"></span><hr>
                            <input type="password" name="newPass" id="newP" placeholder="请输入新密码" onblur="checkNewP()">
                            <span id="newPInfo" class="layui-inline"></span><hr>
                            <input type="password" id="yesN" placeholder="请确认新密码" onblur="checkYesN()">
                            <span id="yesNInfo" class="layui-inline"></span><hr>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <button type="button" class="btn btn-primary">
                        提交更改
                    </button>
                </div>
            </div><!-- /.modal-content -->
        </div>
    </div>
    <script>
        $(function (){
            let sex = $('#sex').val();
            let rls = $('#role').val();
            if (rls == 1){
                $('#r1').prop("selected",true);
            }else if (rls == 2){
                $('#r2').prop("selected",true);
            }else if (rls == 3){
                $('#r3').prop("selected",true);
            }
            if (sex == 1){
                $('#1').prop("selected",true);
            }else{
                $('#2').prop("selected",true);
            }
        })
        function checkOldP(){
            $.post({
                url:"${pageContext.request.contextPath}/client/getPass",
                data:{"oldPass":$('#oldP').val()},
                success:function (data){
                    alert(data);
                    if (data == "X"){
                        $('#oldPInfo').css("color","red");
                    }else{
                        $('#oldPInfo').css("color","green");
                    }
                    $('#oldPInfo').html(data);
                }
            })
        }
        function checkNewP(){
            let o = $('#newP').val();
            let b = $('#yesN').val();
            if (o != b&&o!=NaN){
                $('#yesNInfo').css("color","red");
                $('#newPInfo').css("color","red");
                $('#yesNInfo').html("两次密码不一致");
                $('#newPInfo').html("两次密码不一致");
            }else{
                $('#yesNInfo').css("color","green");
                $('#newPInfo').css("color","green");
                $('#yesNInfo').html("√");
                $('#newPInfo').html("√");
            }
        };
        function checkYesN(){
            let o = $('#newP').val();
            let b = $('#yesN').val();
            if (o != b&&o!=NaN){
                $('#yesNInfo').css("color","red");
                $('#newPInfo').css("color","red");
                $('#yesNInfo').html("两次密码不一致");
                $('#newPInfo').html("两次密码不一致");
            }else{
                $('#yesNInfo').css("color","green");
                $('#newPInfo').css("color","green");
                $('#yesNInfo').html("√");
                $('#newPInfo').html("√");
            }
        }
    </script>
</div>
</body>
</html>

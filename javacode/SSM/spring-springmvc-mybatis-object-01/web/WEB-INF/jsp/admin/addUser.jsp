<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file = "../based/header.jsp"%>
<div id="page_1" class="row clearfix">
    <%--    <div id="div1">--%>
    <%--        &lt;%&ndash;搜索部分&ndash;%&gt;--%>
    <%--        <input type="text" id="putOne" data-validate="请输入实验室id或code">--%>
    <%--        <input type="button" id="upTo" value="搜索" onclick="getLab()">--%>
    <%--        <a href="${pageContext.request.contextPath}/laboratory/addLab">增加</a>--%>
    <%--    </div>--%>

    <div class="container pull-right" id="inlinediv1">
        <div class="row clearfix">
            <div class="col-md-12 colum">
                <form action="${pageContext.request.contextPath}/user/addUser" method="post" style="text-align: center">
                    <fieldset>
                        <legend>新增实验室信息</legend>
                        <div class="form-group">
                            <label>人物id</label>
                            <input type="number" class="form-control layui-inline" id="id" name="id" onblur="check()" required/>
                            <span class="layui-inline" id="idInfo">${msg}</span>
                        </div>
                        <div class="form-group">
                            <label>账号</label>
                            <input type="text" class="form-control" name="code" id="code" placeholder="用户登录帐户" onblur="checkUser()" required/>
                            <span class="layui-inline" id="codeInfo">${msf}</span>
                        </div>
                        <div class="form-group">
                            <label>用户名</label>
                            <input type="text" class="form-control" name="user_name" placeholder="用户姓名" equired/>
                        </div>
                        <div class="form-group">
                            <label>密码</label>
                            <input type="text" class="form-control" name="password" equired/>
                        </div>
                        <div class="form-group">
                            <label>性别</label>
                            <select name="sex" id="sex" class="form-control">
                                <option id="sex01" value="1">男</option>
                                <option id="sex02" value="2">女</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>年龄</label>
                            <input type="number" class="form-control" name="age" required/>
                        </div>
                        <div class="form-group">
                            <label>电话号码</label>
                            <input type="number" class="form-control" name="tel_number" required/>
                        </div>
                        <div class="form-group">
                            <label>职务</label>
                            <select name="roleId" id="role" class="form-control">
                                <option id="roleId01" value="1">管理员</option>
                                <option id="roleId02" value="2">教师</option>
                                <option id="roleId03" value="3">负责人</option>
                            </select>
                        </div>
                        <input type="submit" id="submit" class="form-control btn-primary" value="提交" onclick="myFunction()">
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
    <script>
        function check(){
            console.log($('#id').val());
            $.post({
                url:"${pageContext.request.contextPath}/user/getUserById",
                data:{"id":$('#id').val()},
                success:function (data){
                    console.log(data);
                    if (data.toString()=="yes"){
                        $('#idInfo').css("color","green");
                        // $('#submit').attr("idsabled",true);
                    }else{
                        $('#idInfo').css("color","red");
                        // $('#submit').removeAttr("disabled");
                    }
                    $('#idInfo').html(data);
                }
            })
        }
        function checkUser(){
            $.post({
                url:"${pageContext.request.contextPath}/user/getUserByCode",
                data:{"code":$('#code').val()},
                success:function (data){
                    console.log(data);
                    if (data.toString()=="yes"){
                        $('#codeInfo').css("color","green");
                        // $('#submit').attr("idsabled",true);
                    }else{
                        $('#codeInfo').css("color","red");
                        // $('#submit').removeAttr("disabled");
                    }
                    $('#codeInfo').html(data);
                }
            })
        }
    </script>
<%@ include file = "../based/footer.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file = "../based/header.jsp"%>
<div id="page_1" class="row clearfix">
    <div class="container pull-right" id="inlinediv1">
        <div class="row clearfix">
            <div class="col-md-12 colum">
                <form action="${pageContext.request.contextPath}/user/updateUser" class="form-group" method="post" style="text-align: center">
                    <fieldset>
                        <legend>修改用户信息</legend>
                        <div >
                            <label>用户id</label>
                            <input type="number" class="form-control" name="id" value="${user.id}" readonly="readonly" required/>
                        </div>
                        <div>
                            <label>登录账号</label>
                            <input type="text" class="form-control" name="code" value="${user.code}" required/>
                        </div>
                        <div>
                            <label>姓名</label>
                            <input type="text" class="form-control" name="user_name" value="${user.user_name}" required/>
                        </div>
                        <div >
                            <label>密码</label>
                            <input type="text" class="form-control" name="password" value="${user.password}"  required/>
                        </div>
                        <div >
                            <label>性别</label>
                            <input type="number" class="form-control" name="sex"   value="${user.sex}" required/>
                        </div>
                        <div >
                            <label>年龄</label>
                            <input type="number" class="form-control" name="age" value="${user.age}" required/>
                        </div>
                        <div >
                            <label>电话号码</label>
                            <input type="number" class="form-control" name="tel_number" value="${user.tel_number}" required/>
                        </div>
                        <div >
                            <label>角色权限</label>
                            <input type="number" class="form-control" name="roleId" value="${user.roleId}" required/>
                        </div>
                        <div >
                            <input type="submit" value="提交" class="form-control btn-primary" onclick="myFunction()">
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
    <script>
        $(function (){
            $('.form-control').css("text-align","center");
        })
        function myFunction(){
           alert("提交成功");
        }
    </script>
<%@ include file = "../based/footer.jsp"%>
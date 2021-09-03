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
            <div class="col-md-8 colum">
                <div class="page-header">
                    <h1>
                        <small>用户信息管理</small><br>
                    </h1>
                </div>
            </div>

            <div class="row clearfix">
                <div class="col-md-4 colum">
                    <a style="position: relative;left:265px" class="btn btn-info" href="${pageContext.request.contextPath}/user/addUserPage">增加用户</a>
                </div>
            </div>
        </div>
        <div class="col-md-12">
            <div class="row clearfix">
                <div class="col-md-8"></div>
                <div class="col-md-4 colum">
                    <form action="${pageContext.request.contextPath}/user/searchByName" method="post">
                        <input type="text" name="name" placeholder="请输入用户姓名" class="layui-inline" style="position: relative;left: 80px" required>
                        <input type="submit" value="搜索" class="layui-inline btn btn-info" style="position: relative;left: 80px">
                    </form>
                </div>
            </div>
        </div>
        <div class="row clearfix">
            <div class="col-md-12 colum">
                <table class="table table-hover table-striped">
                    <thead>
                    <tr>
                        <th>id</th>
                        <th>账户名</th>
                        <th>姓名</th>
                        <th>密码</th>
                        <th>性别</th>
                        <th>年龄</th>
                        <th>电话号码</th>
                        <th>所属部门</th>
                        <th style="text-align: center">操     作</th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach var="user" items="${userList}">
                    <tbody>
                    <td>
                            ${user.id}
                    </td>
                    <td>
                            ${user.code}
                    </td>
                    <td>
                            ${user.user_name}
                    </td>
                    <td>
                            ${user.password}
                    </td>
                    <td>
                            ${user.sex}
                    </td>
                    <td>
                            ${user.age}
                    </td>
                    <td>
                            ${user.tel_number}
                    </td>
                    <td>
                            ${user.roleId}
                    </td>
                    <td style="width: 200px" >
                        <a href="${pageContext.request.contextPath}/user/updateUserPage?id=${user.id}" class="layui-inline btn btn-success" style="display: inline-block;width: 80px">修改</a>
                        <a href="${pageContext.request.contextPath}/user/deleteUser?id=${user.id}" class="layui-inline btn btn-danger" style="display: inline-block;width: 80px">删除</a>
                    </td>
                    </tbody>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
    <script>
        $(function (){
            var ul = '${userList}';
            if (ul==""){
                alert("未查询到相关用户");
            }
        })
    </script>
<%@ include file = "../based/footer.jsp"%>
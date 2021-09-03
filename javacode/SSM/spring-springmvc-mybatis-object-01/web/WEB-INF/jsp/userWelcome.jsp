<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer.css">
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/4.1.0/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/useWelcome.css">
    <script src="${pageContext.request.contextPath}/js/header.js"></script>
</head>
<body>
<div style="border: 5px solid black;position: absolute;right: 100px;left: 100px;height: 100px;background: linear-gradient(to left,#FFFFFF 0%,#9e9e9e 50%,#FFFFFF 100%)">
    <div style="border: 2px solid red;text-align: center;">
        <h1 style="line-height: 80px;font-family: 楷体;font-weight: bold;display: inline-block">教师实验室预约系统</h1>
        <a class="btn-primary" id="ab" href="${pageContext.request.contextPath}/client/clientUp">个人信息</a>
        <a class="btn-primary" id="aa" href="${pageContext.request.contextPath}/outLogin/outloginUser">注销</a>
    </div>
</div>
<!--开头-->
<div id="page_1">
    <div class="container"id="inlinediv">
        <div class="row clearfix">
            <div class="col-md-12 colum">
                <div class="page-header">
                    <h1>
                        <small>实验室预约操作</small>
                    </h1>
                </div>
            </div>
        </div>
        <div class="col-md-12">
            <div class="row clearfix">
                <div class="col-md-8"></div>
                <div class="col-md-4 colum">
                    <form action="${pageContext.request.contextPath}/client/getLabByName" method="post" >
                        <input type="text" id="nameValue" name="name" placeholder="请输入实验室名"  class="layui-inline" style="position: relative;left: 80px" onblur="a3()" checked required>
                        <input type="submit" value="搜索" class="layui-inline btn btn-info" style="position: relative;left: 80px" >
                    </form>
                </div>
            </div>
        </div>
        <div class="row clearfix">
            <div class="col-md-12 colum">
                <table class="table table-hover table-striped">
                    <thead>
                    <tr>
                        <th>实验室名</th>
                        <th>今日上午</th>
                        <th>今日下午</th>
                        <th>今日晚间</th>
                        <th>明日上午</th>
                        <th>明日下午</th>
                        <th>明日晚间</th>
                        <th>实验室所属部门</th>
                        <th>实验室负责人</th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach var="lab" items="${labList}">
                    <tbody>
                    <td>
                            ${lab.lab_name}
                    </td>
                    <td class="width">
                        <c:set var="today_m" scope="page" value="${lab.today_m}"/>
                        <c:if test="${!today_m.equals('未预约')}">
                            <a class="btn-group" href="${pageContext.request.contextPath}/client/todaym?id=${lab.id}&interval=tdm"><span style="color:#ff0000">${lab.today_m}</span></a>
                        </c:if>
                        <c:if test="${today_m.equals('未预约')}">
                            <a class="btn-group" href="${pageContext.request.contextPath}/client/todaym?id=${lab.id}&interval=tdm"><span style="color:green">${lab.today_m}</span></a>
                        </c:if>
                    </td>
                    <td class="width">
                        <c:set var="today_a" scope="page" value="${lab.today_a}"/>
                        <c:if test="${!today_a.equals('未预约')}">
                            <a  class="btn-group" href="${pageContext.request.contextPath}/client/todaym?id=${lab.id}&interval=tda"><span style="color:#ff0000">${lab.today_a}</span></a>
                        </c:if>
                        <c:if test="${today_a.equals('未预约')}">
                            <a  class="btn-group" href="${pageContext.request.contextPath}/client/todaym?id=${lab.id}&interval=tda"><span style="color:green">${lab.today_a}</span></a>
                        </c:if>
                    </td>
                    <td class="width">
                        <c:set var="today_n" scope="page" value="${lab.today_n}"/>
                        <c:if test="${!today_n.equals('未预约')}">
                            <a  class="btn-group" href="${pageContext.request.contextPath}/client/todaym?id=${lab.id}&interval=tdn"><span style="color:#ff0000">${lab.today_n}</span></a>
                        </c:if>
                        <c:if test="${today_n.equals('未预约')}">
                            <a  class="btn-group" href="${pageContext.request.contextPath}/client/todaym?id=${lab.id}&interval=tdn"><span style="color:green">${lab.today_n}</span></a>
                        </c:if>
                    </td>
                    <td class="width">
                        <c:set var="tom_m" scope="page" value="${lab.tom_m}"/>
                        <c:if test="${!tom_m.equals('未预约')}">
                            <a  class="btn-group" href="${pageContext.request.contextPath}/client/todaym?id=${lab.id}&interval=tmm"><span style="color:#ff0000">${lab.tom_m}</span></a>
                        </c:if>
                        <c:if test="${tom_m.equals('未预约')}">
                            <a  class="btn-group" href="${pageContext.request.contextPath}/client/todaym?id=${lab.id}&interval=tmm"><span style="color:green">${lab.tom_m}</span></a>
                        </c:if>
                    </td>
                    <td class="width">
                        <c:set var="tom_a" scope="page" value="${lab.tom_a}"/>
                        <c:if test="${!tom_a.equals('未预约')}">
                            <a  class="btn-group" href="${pageContext.request.contextPath}/client/todaym?id=${lab.id}&interval=tma"><span style="color:#ff0000">${lab.tom_a}</span></a>
                        </c:if>
                        <c:if test="${tom_a.equals('未预约')}">
                            <a  class="btn-group" href="${pageContext.request.contextPath}/client/todaym?id=${lab.id}&interval=tma"><span style="color:green">${lab.tom_a}</span></a>
                        </c:if>
                    </td>
                    <td class="width">
                        <c:set var="tom_n" scope="page" value="${lab.tom_n}"/>
                        <c:if test="${!tom_n.equals('未预约')}">
                            <a  class="btn-group" href="${pageContext.request.contextPath}/client/todaym?id=${lab.id}&interval=tmn"><span style="color:#ff0000">${lab.tom_n}</span></a>
                        </c:if>
                        <c:if test="${tom_n.equals('未预约')}">
                            <a  class="btn-group" href="${pageContext.request.contextPath}/client/todaym?id=${lab.id}&interval=tmn"><span style="color:green">${lab.tom_n}</span></a>
                        </c:if>
                    </td>
                    <td>
                        ${lab.department}
                    </td>
                    <td>
                            ${lab.principal}
                    </td>
                    </tbody>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
    <span id="success" hidden>${success}</span>
    <script>
        $(function (){

            alert($('#success').val());
        })
    </script>
</body>
</html>

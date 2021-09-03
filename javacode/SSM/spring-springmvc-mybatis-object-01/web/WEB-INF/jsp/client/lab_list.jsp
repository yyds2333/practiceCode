<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<%--<link rel="stylesheet" href="${pageContext.request.contextPath}/css/lablist.css">--%>
<link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/4.1.0/css/bootstrap.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
<body>
<div class="container"id="inlinediv">
    <div class="row clearfix">
        <div class="col-md-12 colum">
            <div class="page-header">
                <h1>
                    <small>实验室预约查询</small>
                </h1>
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
                <td>
                        ${lab.today_m}
                </td>
                <td>
                        ${lab.today_a}
                </td>
                <td>
                        ${lab.today_n}
                </td>
                <td>
                    <c:set var="tom_m" scope="page" value="${lab.tom_m}"/>
                    <c:if test="${!tom_m.equals('未预约')}">
                        <span style="color:#ff0000">${lab.tom_m}</span>
                    </c:if>
                    <c:if test="${tom_m.equals('未预约')}">
                        <span>${lab.tom_m}</span>
                    </c:if>
                </td>
                <td>
                        ${lab.tom_a}
                </td>
                <td>
                        ${lab.tom_n}
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





</body>
</html>

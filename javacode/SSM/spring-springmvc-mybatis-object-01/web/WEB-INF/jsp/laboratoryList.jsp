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
<script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
<body>
<%--<div id="inlinediv">实验室预约查询</div>--%>
<%--<div id="div1">--%>
<%--    &lt;%&ndash;搜索部分&ndash;%&gt;--%>
<%--    <input type="text" id="putOne" data-validate="请输入实验室id或code">--%>
<%--    <input type="button" id="upTo" value="搜索" onclick="getLab()">--%>
<%--</div>--%>

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
    <div class="col-md-12">
        <div class="row clearfix">
            <div class="col-md-8"></div>
            <div class="col-md-4 colum">
                <form action="${pageContext.request.contextPath}/unLoginPage/getLabByName" method="post" >
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
                        <span style="color:#ff0000">${lab.today_m}</span>
                    </c:if>
                    <c:if test="${today_m.equals('未预约')}">
                        <span style="color:green">${lab.today_m}</span>
                    </c:if>
                </td>
                <td class="width">
                    <c:set var="today_a" scope="page" value="${lab.today_a}"/>
                    <c:if test="${!today_a.equals('未预约')}">
                        <span style="color:#ff0000">${lab.today_a}</span>
                    </c:if>
                    <c:if test="${today_a.equals('未预约')}">
                        <span style="color:green">${lab.today_a}</span>
                    </c:if>
                </td>
                <td class="width">
                    <c:set var="today_n" scope="page" value="${lab.today_n}"/>
                    <c:if test="${!today_n.equals('未预约')}">
                        <span style="color:#ff0000">${lab.today_n}</span>
                    </c:if>
                    <c:if test="${today_n.equals('未预约')}">
                        <span style="color:green">${lab.today_n}</span>
                    </c:if>
                </td>
                <td class="width">
                    <c:set var="tom_m" scope="page" value="${lab.tom_m}"/>
                    <c:if test="${!tom_m.equals('未预约')}">
                        <span style="color:#ff0000">${lab.tom_m}</span>
                    </c:if>
                    <c:if test="${tom_m.equals('未预约')}">
                        <span style="color:green">${lab.tom_m}</span>
                    </c:if>
                </td>
                <td class="width">
                    <c:set var="tom_a" scope="page" value="${lab.tom_a}"/>
                    <c:if test="${!tom_a.equals('未预约')}">
                        <span style="color:#ff0000">${lab.tom_a}</span>
                    </c:if>
                    <c:if test="${tom_a.equals('未预约')}">
                        <span style="color:green">${lab.tom_a}</span>
                    </c:if>
                </td>
                <td class="width">
                    <c:set var="tom_n" scope="page" value="${lab.tom_n}"/>
                    <c:if test="${!tom_n.equals('未预约')}">
                        <span style="color:#ff0000">${lab.tom_n}</span>
                    </c:if>
                    <c:if test="${tom_n.equals('未预约')}">
                        <span style="color:green">${lab.tom_n}</span>
                    </c:if>
                </td>
                <td>
                    <a href="#" style="color: black">${lab.department}</a>
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

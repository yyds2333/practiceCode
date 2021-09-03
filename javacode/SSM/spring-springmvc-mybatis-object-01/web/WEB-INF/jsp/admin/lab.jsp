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
                        <small>实验室管理</small><br>
                    </h1>
                </div>
            </div>

            <div class="row clearfix">
                <div class="col-md-4 colum">
                    <a style="position: relative;left:250px" class="btn btn-info" href="${pageContext.request.contextPath}/laboratory/add">增加实验室</a>
                </div>
            </div>
        </div>
        <div class="col-md-12">
            <div class="row clearfix">
                <div class="col-md-8"></div>
                <div class="col-md-4 colum">
                    <form action="${pageContext.request.contextPath}/laboratory/getLabByName" method="post">
                        <input type="text" name="name" placeholder="请输入实验室名" class="layui-inline" style="position: relative;left: 80px" required>
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
                        <th>实验室名</th>
                        <th>今日上午</th>
                        <th>今日下午</th>
                        <th>今日晚间</th>
                        <th>明日上午</th>
                        <th>明日下午</th>
                        <th>明日晚间</th>
                        <th>所属部门</th>
                        <th>负责人</th>
                        <th>容量</th>
                        <th style="text-align: center">操     作</th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach var="lab" items="${labList}">
                    <tbody>
                    <td style="width: 30px">
                            ${lab.id}
                    </td>
                    <td style="width: 120px;">
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
                    <td style="width: 80px">
                            ${lab.department}
                    </td>
                    <td style="width: 60px">
                            ${lab.principal}
                    </td>
                    <td style="width: 40px">
                            ${lab.capacity}
                    </td>
                    <td style="width: 200px" >
                        <a href="${pageContext.request.contextPath}/laboratory/updateLab?id=${lab.id}" class="layui-inline btn btn-success" style="display: inline-block;width: 80px">修改</a>
                        <a href="${pageContext.request.contextPath}/laboratory/deleteLab?id=${lab.id}" class="layui-inline btn btn-danger" style="display: inline-block;width: 80px">删除</a>
                    </td>
                    </tbody>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
<%@ include file = "../based/footer.jsp"%>
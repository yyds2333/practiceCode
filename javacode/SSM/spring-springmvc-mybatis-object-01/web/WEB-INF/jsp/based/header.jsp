<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer.css">
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/4.1.0/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(function time(){
            var vWeek,vWeek_s,vDay;
            vWeek = ["星期天","星期一","星期二","星期三","星期四","星期五","星期六"];
            var date =  new Date();
            year = date.getFullYear();
            month = date.getMonth() + 1;
            day = date.getDate();
            hours = date.getHours();
            minutes = date.getMinutes();
            seconds = date.getSeconds();
            vWeek_s = date.getDay();
            $('#time').html(year + "年" + month + "月" + day + "日" + "\t" + hours + "时" +"        "+ vWeek[vWeek_s]);

        })
        setInterval("time()",1000);
    </script>
</head>
<body>
<div class="_top col-md-12">
    <div class="col-md-4 colum layui-inline">
        <span id="demoss" class="spanName layui-inline" style="text-align: center;font-size: 40px" >管理员页面<span id="demo1"></span> </span>
    </div>
    <div class="col-md-8 colum layui-inline">
        <span id="time" style="position: relative;left: 900px;top: -50px;font-size: 30px" class="col-md-8 colum layui-inline"></span>
    </div>
</div>
<div class="_left">
    <a style="color: #0C0C0C" href="${pageContext.request.contextPath}/laboratory/labAll">实验室管理</a>
    <a style="color: #0C0C0C" href="${pageContext.request.contextPath}/user/getAll">用户管理</a>
    <a style="color: #0C0C0C" href="${pageContext.request.contextPath}/notice/getAllNotice">公告管理</a>
    <a style="color: #0C0C0C" href="${pageContext.request.contextPath}/outLogin/outLoginAdmin">注销账户</a>
</div>

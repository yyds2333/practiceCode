<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer.css">
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/4.1.0/css/bootstrap.min.css" rel="stylesheet">
    <style>
        #aa{
            display: inline-block;
            position: absolute;
            right: 20px;
            bottom: 10px;
            color: white;
            font-weight: bold;
            font-family: 宋体;
            line-height: 30px;
            background: #4f8ace;
            font-size: 20px;
            text-decoration: none;
        }
        a.hover{
            color: blue;
            background: #9fcdff;
            text-decoration: none;
        }
    </style>
    <script src="${pageContext.request.contextPath}/js/header.js"></script>

</head>
<body>
<div style="border: 5px solid black;position: absolute;right: 100px;left: 100px;height: 100px;background: linear-gradient(to left,#FFFFFF 0%,#9e9e9e 50%,#FFFFFF 100%)">
    <div style="border: 2px solid red;text-align: center;">
        <h1 style="line-height: 80px;font-family: 楷体;font-weight: bold;display: inline-block">教师实验室预约系统</h1>
        <a class="btn-primary" id="aa" href="${pageContext.request.contextPath}/outLogin/outloginUser">注销</a>
    </div>
</div>


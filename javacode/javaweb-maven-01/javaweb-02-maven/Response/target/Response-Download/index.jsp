<%--
  Created by IntelliJ IDEA.
  User: 杨亚迪
  Date: 3/14/2021
  Time: 2:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <form action="${pageContext.request.contextPath}/login" method="post">
        <h2>用户：</h2><input type="text" name="username"><br>
        <h2>密码：</h2><input type="password" name="password"><br>
        <h2>爱好：</h2>  <input type="checkbox" name="hobbys" value="girl">girl
        <input type="checkbox" name="hobbys" value="code">code
        <input type="checkbox" name="hobbys" value="music">music
        <input type="checkbox" name="hobbys" value="movie">movie
        <input type="submit" value="提交表单">
    </form>
</div>
</body>
</html>

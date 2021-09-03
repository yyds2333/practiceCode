
<html>
<body>
<h2>Hello World!</h2>
<%
    String s=(String) request.getSession().getAttribute("name");
%>
<%=s%>

</body>
</html>

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
            <div class="col-md-12 colum">
                <form action="${pageContext.request.contextPath}/notice/addNoticePage" method="post" style="text-align: center">
                    <fieldset>
                        <legend>新增公告</legend>
                        <div class="form-group">
                            <label>公告id</label>
                            <input type="number" class="form-control layui-inline" id="id" name="id"  required/>
                            <span class="layui-inline" id="idInfo">${msg}</span>
                        </div>
                        <div class="form-group">
                            <label>公告信息</label>
                            <textarea name="notice" class="form-control" placeholder="公告信息" required></textarea>
<%--                            <input type="texta" class="form-control" name="notice" placeholder="公告信息" required/>--%>
                        </div>
                        <input type="submit" id="submit" class="form-control btn-primary" value="提交" />
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
    <script>
        function myFunction(){
            var x;
            var r=confirm("是否确认");
            if (r==true){
                x="你按下了\"确定\"按钮!";
            }
            else{
                x="你按下了\"取消\"按钮!";
            }
            document.getElementById("demo").innerHTML=x;
        };
        <%--function check(){--%>
        <%--    console.log($('#id').val());--%>
        <%--    $.post({--%>
        <%--        url:"${pageContext.request.contextPath}/laboratory/getLabtoryById",--%>
        <%--        data:{"id":$('#id').val()},--%>
        <%--        success:function (data){--%>
        <%--            console.log(data);--%>
        <%--            if (data.toString()=="no"){--%>
        <%--                $('#idInfo').css("color","red");--%>
        <%--                // $('#submit').attr("idsabled",true);--%>
        <%--            }else{--%>
        <%--                $('#idInfo').css("color","green");--%>
        <%--                // $('#submit').removeAttr("disabled");--%>
        <%--            }--%>
        <%--            $('#idInfo').html(data);--%>
        <%--        }--%>
        <%--    })--%>
        <%--}--%>
    </script>
<%@ include file = "../based/footer.jsp"%>
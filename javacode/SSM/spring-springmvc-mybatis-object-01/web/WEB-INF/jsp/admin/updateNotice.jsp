<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file = "../based/header.jsp"%>
<div id="page_1" class="row clearfix">
    <div class="container pull-right" id="inlinediv1">
        <div class="row clearfix">
            <div class="col-md-12 colum">
                <form action="${pageContext.request.contextPath}/notice/updateNoticePage" class="form-group" method="post" style="text-align: center">
                    <fieldset>
                        <legend>修改公告</legend>
                        <div >
                            <label>公告id</label>
                            <input type="number" name="id" class="form-control" value="${notice.id}" readonly="readonly"  required/>
                        </div>
                        <div>
                            <label>公告信息</label>
                            <textarea name="notice" class="form-control" placeholder="公告信息" required>${notice.notice}</textarea>
                            <%--                            <input type="texta" class="form-control" name="notice" placeholder="公告信息" required/>--%>
                        </div>
                        <div >
                            <input type="submit" value="提交" class="form-control btn-primary" onclick="myFunction()">
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
    <script>
        $(function (){
            $('.form-control').css("text-align","center");
        })
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
        }
    </script>
<%@ include file = "../based/footer.jsp"%>
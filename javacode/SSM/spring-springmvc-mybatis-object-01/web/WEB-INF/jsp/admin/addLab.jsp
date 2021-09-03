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
                <form action="${pageContext.request.contextPath}/laboratory/addLab" method="post" style="text-align: center">
                    <fieldset>
                        <legend>新增实验室信息</legend>
                        <div class="form-group">
                            <label>实验室id</label>
                            <input type="number" class="form-control layui-inline" id="id" name="id" onblur="check()" required/>
                            <span class="layui-inline" id="idInfo">${msg}</span>
                        </div>
                        <div class="form-group">
                            <label>实验室code</label>
                            <input type="text" class="form-control" name="code" placeholder="一般格式几楼-几室" required/>
                        </div>
                        <div class="form-group">
                            <label>实验室名</label>
                            <input type="text" class="form-control" name="name" placeholder="xxx实验室" equired/>
                        </div>
                        <div class="form-group">
                            <label>所属部门</label>
                            <select name="department" class="form-control">
                                <option value="1">计算机学院</option>
                                <option value="2">数学学院</option>
                                <option value="3">文学院</option>
                                <option value="4">电气学院</option>
                                <option value="5">机械学院</option>
                                <option value="6">后勤中心</option>
                            </select>
<%--                            <input type="number" class="form-control" name="department" placeholder="1~6" required/>--%>
                        </div>
                        <div class="form-group">
                            <label>负责人</label>
                            <input type="text" class="form-control" value="赵老师" name="principal" required/>
                        </div>
                        <div class="form-group">
                            <label>人员容量</label>
                            <input type="number" class="form-control" name="capacity" value="50" required/>
                        </div>
                        <input type="submit" id="submit" class="form-control btn-primary" value="提交" onclick="myFunction()">
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
    <script>
            function myFuncrion(){
                alert("提交成功");
            }
        function check(){
            console.log($('#id').val());
            $.post({
                url:"${pageContext.request.contextPath}/laboratory/getLabtoryById",
                data:{"id":$('#id').val()},
                success:function (data){
                    console.log(data);
                    if (data.toString()=="no"){
                        $('#idInfo').css("color","red");
                        // $('#submit').attr("idsabled",true);
                    }else{
                        $('#idInfo').css("color","green");
                        // $('#submit').removeAttr("disabled");
                    }
                    $('#idInfo').html(data);
                }
            })
        }
    </script>
<%@ include file = "../based/footer.jsp"%>
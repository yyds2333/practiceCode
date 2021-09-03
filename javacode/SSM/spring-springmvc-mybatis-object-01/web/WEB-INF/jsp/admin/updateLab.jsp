<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file = "../based/header.jsp"%>
<div id="page_1" class="row clearfix">

    <div class="container pull-right" id="inlinediv1">
        <div class="row clearfix">
            <div class="col-md-12 colum">
                <form action="${pageContext.request.contextPath}/laboratory/updateLabor" method="post" style="text-align: center" onsubmit="return myFunction()">
                    <fieldset>
                        <legend>修改实验室信息</legend>
                        <label>实验室id</label><br>
                        <input type="number" class="form-control" value="${labortory.id}" readonly="readonly" required/><br>
                        <input type="hidden" name="id" value="${labortory.id}">
                        <label>实验室code</label><br>
                        <input type="text" name="code" class="form-control" value="${labortory.code}" required/><br>
                        <label>实验室名</label><br>
                        <input type="text" name="name" class="form-control" value="${labortory.name}" required/><br>
                        <label>所属部门</label>
                        <select name="department" class="form-control">
                            <option id="1" value="1">计算机学院</option>
                            <option id="2" value="2">数学学院</option>
                            <option id="3" value="3">文学院</option>
                            <option id="4" value="4">电气学院</option>
                            <option id="5" value="5">机械学院</option>
                            <option id="6" value="6">后勤中心</option>
                        </select>
                        <label>负责人</label><br>
                        <input type="text" name="principal" class="form-control"  value="${labortory.principal}" required/><br>
                        <label>人员容量</label><br>
                        <input type="number" name="capacity" class="form-control" value="${labortory.capacity}" required/><br>
                        <input type="submit" value="提交" id="demo1" class="form-control btn-primary" >
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
    <script>
        $(function (){
            let no = ${labortory.department};
            if (no == 1){
                $("#1").prop("selected", true);
            }else if (no == 2){
                $("#2").prop("selected", true);
            }else if (no == 3){
                $("#3").prop("selected", true);
            }else if (no == 4){
                $("#4").prop("selected", true);
            }else if (no == 5){
                $("#5").prop("selected", true);
            }else if (no == 6){
                $("#6").prop("selected", true);
            }
        })
        // function myFunction(){
        //     var x;
        //     var r=confirm("是否确认");
        //     if (r==true){
        //         x="你按下了\"确定\"按钮!";
        //         return true;
        //     }
        //     else{
        //         x="你按下了\"取消\"按钮!";
        //         return false;
        //     }
        // }
    </script>
<%@ include file = "../based/footer.jsp"%>
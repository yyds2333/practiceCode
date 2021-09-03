var oldpassword = null;
var newpassword = null;
var rnewpassword = null;
var saveBtn = null;

//密码修改前端js页面，主要由Ajax实现原密码查询异步交互
$(function(){
	oldpassword = $("#oldpassword");
	newpassword = $("#newpassword");
	rnewpassword = $("#rnewpassword");
	saveBtn = $("#save");
	
	oldpassword.next().html("*");
	newpassword.next().html("*");
	rnewpassword.next().html("*");
	
	oldpassword.on("blur",function(){//Ajax异步请求原密码
		$.ajax({
			type:"GET",
			url:path+"/jsp/user.do",
			data:{method:"pwdmodify",oldpassword:oldpassword.val()},
			dataType:"json",
			success:function(data){
				if(data.result == "true"){//旧密码正确
					validateTip(oldpassword.next(),{"color":"green"},imgYes,true);
				}else if(data.result == "false"){//旧密码输入不正确
					validateTip(oldpassword.next(),{"color":"red"},imgNo + " Old Password Error!",false);
				}else if(data.result == "sessionerror"){//当前用户session过期，请重新登录
					validateTip(oldpassword.next(),{"color":"red"},imgNo + " Your Session Has Expired",false);
				}else if(data.result == "error"){//旧密码输入为空
					validateTip(oldpassword.next(),{"color":"red"},imgNo + " Please Input Old Password",false);
				}
			},
			error:function(data){
				//请求出错
				validateTip(oldpassword.next(),{"color":"red"},imgNo + " Request Error",false);
			}
		});
		
		
	}).on("focus",function(){
		validateTip(oldpassword.next(),{"color":"#666666"},"* Please Input Old Password",false);
	});
	
	newpassword.on("focus",function(){
		//密码长度必须是大于6小于20
		validateTip(newpassword.next(),{"color":"#666666"},"* Password length must be greater than 6 and less than 20",false);
	}).on("blur",function(){
		if(newpassword.val() != null && newpassword.val().length > 6
				&& newpassword.val().length < 20 ){
			validateTip(newpassword.next(),{"color":"green"},imgYes,true);
		}else{
			//密码输入不符合规范，请重新输入
			validateTip(newpassword.next(),{"color":"red"},imgNo + " Password input does not meet the specification, please re-enter",false);
		}
	});
	
	
	rnewpassword.on("focus",function(){
		//请输入与上面一致的密码
		validateTip(rnewpassword.next(),{"color":"#666666"},"* Please enter the same password as above",false);
	}).on("blur",function(){
		if(rnewpassword.val() != null && rnewpassword.val().length > 6
				&& rnewpassword.val().length < 20 && newpassword.val() == rnewpassword.val()){
			validateTip(rnewpassword.next(),{"color":"green"},imgYes,true);
		}else{
			//两次密码输入不一致，请重新输入
			validateTip(rnewpassword.next(),{"color":"red"},imgNo + " The two passwords are inconsistent, please re-enter",false);
		}
	});
	
	
	saveBtn.on("click",function(){
		oldpassword.blur();
		newpassword.blur();
		rnewpassword.blur();
		if( oldpassword.attr("validateStatus") == "true" //默认为true
			&&newpassword.attr("validateStatus") == "true"
			&& rnewpassword.attr("validateStatus") == "true"){
			//确定要修改密码吗，由于乱码改为英文
			if(confirm("Are you sure you want to change the password?")){
				$("#userForm").submit();
			}
		}
		
	});
});
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
<link rel="shortcut icon" href="image/favicon.ico" />
<link href="css/register.css" type="text/css" rel="stylesheet">
</head>
<body>

	<%@include file="head.jsp" %>
	<%@include file="menu_search.jsp" %>
	<%@include file="search.jsp" %>
	<div class="div1">
		<div class="div2">
			<form action="${pageContext.request.contextPath }/RegisterServlet" method="post" onsubmit="return checkForm();">
				<table cellpadding="2" align="center">
					<tr>
						<td align="right">用户名:</td>
						<td><input type="text" name="username" class="textinput"
							id="username" onkeyup="checkUsername();" /></td>
						<td colspan="2"><span id="usernameMsg"></span> 
<font color="""#999999"> 字母数字下划线1到10位，不能是数字开头</font>
						</td>
					</tr>
					<tr>
						<td align="right">密码:</td>
						<td><input type="password" name="password" class="textinput"
							id="password" onkeyup="checkPassword();" /></td>
						<td><span id="passwordMsg"></span> <font color="#999999">6~16位字符</font>
						</td>
					</tr>
					<tr>
						<td align="right">确认密码:</td>
						<td><input type="password" name="repassword"
							class="textinput" id="repassword" onkeyup="checkConfirm()" /></td>
						<td><span id="confirmMsg"></td>
					</tr>
					<tr>
						<td align="right">性别:</td>
						<td><input type="radio" name="gender" value="male" />男&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <input
							type="radio" name="gender" value="female" />女</td>
					</tr>
					<tr>
						<td align="right">邮箱:</td>					
						<td><input type="text" name="email" id="email" class="textinput"  onkeyup="checkEmail()"/></td>
						<td colspan="2"><span id="emailMsg"></span>
						
					</tr>
					<tr>
						<td align="right">个人介绍:</td>
						<td colspan="2"><textarea rows="5" cols="60" name="instroduce"></textarea></td>
					</tr>					
					<tr>
					<td style="text-align: right;width: ">输入验证码</td>
					<td style="width: 60px;"><input type="text" class="textinput" name="userCode"><span>${codeError}</span></td>
					<td colspan="2" ><img  src="${pageContext.request.contextPath }/imageCode" width="180" 
					height="20" class="textinput" style="height: 20px;" id="img"/>
					<a href="javascript:void(0);" onclick="changeImage()">看不清楚，换一张</a></td>
					</tr>
					<tr >
						<td ><input style="height: 40px; width: 80px;" type="reset"
							name="reset" value="重置" id="reset" /></td>
						<td><input style="height: 40px; width: 120px;" type="submit"
							
							name="submit" value="确认并提交"  /></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<%@include file="foot.jsp" %>
</body>
<script type="text/javascript">
function changeImage() {
	var image=document.getElementById("img");
	image.src="${pageContext.request.contextPath }/imageCode?a="+new Date().getTime();
}
</script>
<script type="text/javascript">
//1、声明变量
var emailo;
var usernameo;
var passwordo;
var confirmo;
var emailMsg;
var usernameMsg;
var passwordMsg;
var confirmMsg;
//2、页面加载后，获取页面中的对象
window.onload=function(){
	emailo=document.getElementById("email");	
	usernameo=document.getElementById("username");
	passwordo=document.getElementById("password");
	confirmo=document.getElementById("repassword");
	emailMsg=document.getElementById("emailMsg");	
	usernameMsg=document.getElementById("usernameMsg");
	passwordMsg=document.getElementById("passwordMsg");
	confirmMsg=document.getElementById("confirmMsg");	
};
//3、校验整个表单
function checkForm() {
	var bEmail=checkEmail();
	var bPassword=checkPassword();
	var bUsername=checkUsername();
	var bConfirm=checkConfirm();
	return bEmail&&bPassword&&bUsername&&bConfirm;
}
//4、验证邮箱
function checkEmail() {
	var regex=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+$/;//数字字母下划线+@+.数字字母下划线
	var value=emailo.value;
	var msg="";//如果emailo为null或“”，!value的值为false，如果不为空则为true
	if(!value)
		msg="邮箱必须填写";
	else if(!regex.test(value))
		msg="邮箱格式不对";
	emailMsg.innerHTML=msg;
	emailo.parentNode.parentNode.style.color=msg==""?"black":"red";
	return msg=="";
}
//5验证用户名
function checkUsername() {
	var regex=/^[a-zA-Z]\w{3,16}$/;//数字字母下划线4~16位，不能是数字开头
	var value=usernameo.value;
	var msg="";
	if(!value){//等价于value1=="";
		msg="用户名必须填写：";
	}
	else if(!regex.test(value)){//如果用户不能匹配正则表达式
		msg="用户名不合法";	
	}
	usernameMsg.innerHTML=msg;//将消息放入span
	usernameo.parentNode.parentNode.style.color=msg==""?"black":"red";
	return msg=="";
}
//6验证密码
function checkPassword() {
	var regex=/^.{6,16}$/;
	var value=passwordo.value;
	var msg="";
	if(value==""){
		msg="密码不能为空";
	}else if(!regex.test(value)){
		msg="密码格式不对";
	}
	passwordMsg.innerHTML=msg;
	passwordo.parentNode.parentNode.style.color=msg==""?"black":"red";
	return msg=="";
}
//7确认密码
function checkConfirm() {
	var passwordValue=passwordo.value;
	var confirmValue=confirmo.value;
	var msg="";
	if(passwordValue != confirmValue){
		msg="两次输入的密码不一致";
	}else if(! confirmValue){
		msg="不能为空";
	}
	confirmMsg.innerHTML=msg;
	confirmo.parentNode.parentNode.style.color=msg==""?"black":"red";
	return msg=="";
	
}
</script>
</html>
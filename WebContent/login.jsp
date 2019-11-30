<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
<style type="text/css">
#login{width:100%;height:400px;
background-image: url(image/login.jpg) ;
position: static;
background-size: cover;}
#left{
position:relative;
left:20%;top:10%;
height:300px;width:300px;
background: #ffe5e5;
opacity: 0.6;
text-align: center;
line-height: 30px;
}

</style>
</head>
<body>
<%@include file="head.jsp" %>
<%@include file="menu_search.jsp" %>
<%@include file="search.jsp" %>
	<div id="login">
		<div id="left">
			个人用户登陆<br><br>
			<form action="${pageContext.request.contextPath }/LoginServlet" method="post">
				<table align="center">
					<tr>
						<td>用户名</td>
						<td><input type="text" name="username"></td>
					</tr>
					<tr>
						<td>密码</td>
						<td><input type="password" name="password"></td>
					</tr>
					
					<tr>
						<td colspan="2" style="text-align: center"><input
							type="checkbox" name="checkbox" value="checkbox01">记住密码&nbsp;
							<input type="checkbox" name="checkbox" value="checkbox02">自动登录</td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="登录"></td>
					</tr>
					<tr><td style="text-align: center;"><font color="red">${requestScope["login_message"]}</font></td></tr>
				</table>
			</form>
		</div>
	</div>
	<%@include file="foot.jsp" %>
</body>

</html>
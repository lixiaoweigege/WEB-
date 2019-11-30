<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>顶部页面</title>
<style type="text/css">
#head{width: 100%;background:#e5fffa;margin-top:0px;}
#head a{color: black; text-decoration: none;}
#head a:hover{color:red;}
#a:hover{color:#009900;font-size: 30px;}
.headtable {
	width: 100%;
}
.headtable td {

	padding: 5px 50px 5px 135px;
}

</style>
</head>
<body>
<div id="head">
		<table class="headtable">
			<tr>
				<td><a href="${pageContext.request.contextPath }/homepage.jsp" style="text-decoration: none;">
						<font id="a" face="草体" size="5" color=" #99ff99"
						style="line-height: 40px;"> 悠悠独山</font><img src="image/独秀峰.jpg"
						width="120" height="40" border="0" style="padding-top: 10px;" />
				</a></td> 
				
				<td colspan="1" style="text-align: "><img src="image/link.gif"
					height="25" width="25" border="0" style="margin-bottom: -4px"/>
					<font 
					style="line-height: 50px;">
					<a  href="${pageContext.request.contextPath}/cart.jsp" >购物车</a>|
					<a href="#">帮助中心</a>|
					<a  href="${pageContext.request.contextPath }/MyAccountServlet">我的账户</a>|
					<c:if test="${user==null }">
					<a  href="${pageContext.request.contextPath }/register.jsp">用户注册</a></c:if>
					<c:if test="${user!=null }">
					<a  href="${pageContext.request.contextPath }/LogoutServlet">退出登录|</a></br>欢迎您：${user.username}</c:if>
					</font>
					</td>			
			</tr>
			
		</table>
	</div>
	
</body>
</html>
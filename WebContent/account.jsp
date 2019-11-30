<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
#account{text-align: right;margin-right: 100px;background-size: 100%;height: 400px;}
#account a{text-decoration:none;text-align: right;color: black;}
</style>
</head>
<body>
<%@include file="head.jsp" %>
<%@include file="menu_search.jsp" %>
<%@include file="search.jsp" %>
<div id="account">
<a href="${pageContext.request.contextPath }/homepage.jsp">首页></a>&nbsp
 <a href="#"> 我的账户></a>&nbsp
 <a href="#"> 订单查询</a>
 <table >
 <tr ><td align="left"><font size="5" face="楷体"> 我的账户</font></td></tr>
 <tr ><td align="left"><font size="3" face="楷体"> 用户信息修改</font></td></tr>
 <tr><td><font size="3" face="楷体"> 订单查询</font></td></tr>
 <tr><td><font size="3" face="楷体"> 用户退出</font></td>
 </tr> </table>
 </div>
 <%@include file="foot.jsp" %>
</body>
</html>
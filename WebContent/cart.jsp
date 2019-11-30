<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="head.jsp" %>
	<%@include file="menu_search.jsp" %>
	<%@include file="search.jsp" %>
	<table width="100%" border="0" cellpadding="0">
	<tr><td style="text-align: right;"><a href="${pageContext.request.contextPath}/homepage.jsp">首页</a>&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;购物车</td></tr>
	<tr>
	<c:forEach items="${cart}" var="entry" varStatus="vs">
	<table><tr><td>${entry.key.name}</td> </tr> </table>
	
	</c:forEach>
	</tr>
	</table>
	<%@include file="foot.jsp" %>
</body>
</html>
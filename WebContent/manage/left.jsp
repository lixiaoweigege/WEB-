<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
#left{background:  #d6d6c2;line-height: 30px}
a{text-decoration: none;color: black;}
</style>
</head>
<body id="left">
<ul style="list-style: none;">
<li><a href="adminManage.jsp" target="right">订单管理</a></li>
<li><a href="${pageContext.request.contextPath }/ListProduct" target="right">商品管理</a></li>
<li><a href="orderManage.jsp" target="right">系统设置</a>
</ul>
</body>
</html>
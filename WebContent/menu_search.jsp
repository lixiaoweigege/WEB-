<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>导航栏</title>
<style type="text/css">
#divmenu{
	width: 100%;
	border-top-width: 4px;
	border-top-style: solid;
	border-top-color: #b4d76d;
	background-color: #000000;
	text-align: center;
	padding: 10px 0px 10px 0px;
	font-size: 14px;
	
} 
#divmenu a {
	font-size: 14px;
	color: #FFFFFF; /*#1E33F7*/
	font-weight: bold;
	padding: 10px 10px 10px 10px;
}
#divmenu a:link{
text-decoration: none;font-weight: bold;
}
#divmenu a:hover {
	color:  #d1d1e0;
}
</style>
</head>
<body>
<div id="divmenu">
<a href="#">美食</a>
<a href="#">特产</a>
<a href="#">旅游</a>
<a href="#">门票</a>
<a href="#">ktv</a>
<a href="#">网咖</a>
<a href="#">电影</a>
<a href="#">外卖</a>
<a href="${pageContext.request.contextPath}/allproducts.jsp">全部商品目录</a>
</div>
</body>
</html>
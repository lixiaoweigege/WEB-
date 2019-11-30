<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/FindProductByCondtion"
		method="post">
		<table background="#FAEBD7" align="center">
		<tbody>
			<tr><td> 条件查询</td><del></del>
			<tr>
				<td>商品编号</td>
				<td><input type="text" name="id" id="id" value=""/></td>
				<td>类别</td>
				<td><select name="category">
						<option value="" selected="selected">选择商品类别</option>
						<option value="美食">美食</option>
						<option value="特产">特产</option>
						<option value="门票">门票</option>
						<option value="电影">电影</option>
						<option value="外卖">外卖</option>
				</select></td>
			</tr>
			<tr>
				<td>商品名称</td>
				<td><input type="text" name="name" value=""/></td>
				<td>价格区间</td>
				<td><input type="text" name="minprice" size="10" value="" /> -
					<input type="text" name="maxprice" size="10" value="" /></td>
			</tr>
			<tr>
				<td align="right"><button type="submit" value="查询"
						name="search">查询</button> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
					type="reset" name="reset" value="重置" class="button_view" /></td>
			</tr>
		
	</table>

		<table cellspacing="0" cellpadding="1" rules="all" bordercolor="gray"border="1" id="DataGrid1"
			style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid;
			 WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; 
			 BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
			<tr
				style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
				<td align="center" width="24%">商品编号</td>
				<td align="center" width="18%">商品名称</td>
				<td align="center" width="9%">商品价格</td>
				<td align="center" width="9%">商品数量</td>
				<td width="8%" align="center">商品类别</td>
				<td width="8%" align="center">编辑</td>
				<td width="8%" align="center">删除</td>
				
			</tr>
			<!--  循环输出所有商品 -->
			<c:forEach items="${ps}" var="p">
				<tr onmouseover="this.style.backgroundColor = 'white'"
					onmouseout="this.style.backgroundColor = '#F5FAFE';">
					<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="24%0">${p.id }</td>
					<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="18%">${p.name }</td>
					<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="9%">${p.price }</td>
					<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="9%">${p.pnum }</td>
					<td style="CURSOR: hand; HEIGHT: 22px" align="center">${p.category}</td>
					<td style="cursor: hand; height: 22px" align="center"><a
						href="">编辑</a></td>
				</tr>
			</c:forEach>
		</tbody>
		
		</table>
	</form>
</body>
</html>
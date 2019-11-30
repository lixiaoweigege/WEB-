<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>搜索栏</title>
<style type="text/css">
#divsearch{
width: 100%;
background-color: #ffff80;
padding: 10px;0px;10px;0px;

}

.inputtable{
height: 20px;
width: 120px;
}
</style>
</head>
<body>
	<div id="divsearch">
		<form action="#" method="post" id="searchform">
			<table width="100%" border="0" cellspacing="0">
				<tr>
					<td align="right" style="padding-right: 120px;">查找<input
						type="text" name="search" id="search" class="inputtable"
						value="请输入"
						 onmouseover="this.focus();"
						onclick="my_click(this,'textfide');"
						onblur="my_blur(this,'textfide');"/><a href="#"> <img
						src="image/serchbutton.gif" border="0" width="40" height="20"
						style="margin-bottom: -4px;" onclick="search();"></a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link rel="icon" href="image/favicon.ico">
<style type="text/css">
*{
padding: 0;
margin: 0;
list-style: none;

}
#firstdiv{
width: 100%;
height:500px;
background:#ffffb3;
}
#firstleft{
text-align:center;
width: 7.5%;
height: 100%;
position: relative;
float: left;
}
#flash{

width: 70%;
height: 500px;
position: relative;
float: left;

}
#flash img{

position: absolute;
left: 0;
top: 0;
}
#flash ol{
position:absolute;
padding-left:650px;
padding-top: 480px;
}
#flash ol li{
list-style: none;
width: 15px;
height: 15px;
background: white;
float:left;
border-radius: 50%;
margin-right: 8px;
text-align: center;
}
</style>

</head>
<body>
<%@include file="head.jsp" %>
	<%@include file="menu_search.jsp" %>
	<%@include file="search.jsp" %>
<div id="firstdiv">
<div id="firstleft"><font face="楷体" color="green" size="7">天<br>外<br>飞<br>来<br>一<br>小<br>峰</font></div>
 <div id="firstleft"><font face="楷体" color="green" size="7"><br>平<br>沙<br>长<br>起<br>绿<br>芙<br>蓉</font></div>
 <div id="flash">
 <ul id="pic">
 <li><img alt="" src="image/轮播图1.jpg" height="500" width="100%"/></li>
<li><img alt="" src="image/轮播图2.jpg"  height="500" width="100%"/></li>
<li><img alt="" src="image/轮播图3.jpg"  height="500" width="100%"/></li>
<li><img alt="" src="image/轮播图4.jpg"  height="500" width="100%"/></li>
<li><img alt="" src="image/轮播图5.jpg"  height="500" width="100%"/></li>
</ul>
<ol id="list">
<li>1</li>
<li>2</li>
<li>3</li>
<li>4</li>
<li>5</li>
</ol>
</div>
<div id="firstleft"><font face="楷体" color="green" size="7" >休<br>言<br>气<br>局<br>成<br>孤<br>独</font></div>
<div id="firstleft"><font face="楷体" color="green" size="7"><br>四<br>面<br>青<br>山<br>拜<br>万<br>重</font></div>
</div>	
<%@include file="foot.jsp" %>
</body>
<script type="text/javascript">

	window.onload = function() {
		var flash = document.getElementById("flash");
		/*var sum = flash.getElementsByTagName('img');
		var ul = flash.getElementsByTagName('li');*/
		var sum=document.getElementById('pic').getElementsByTagName("li");
		 var ul=document.getElementById('list').getElementsByTagName('li');
		var c = 0;
		var index = 0;
		var timer = null;
		// 定义图片切换函数
		function Change(c1) { 
			for (var i = 0; i < sum.length; i++) {
				sum[i].style.display = 'none';
				ul[i].style.background = 'white';
			}
			sum[c1].style.display = 'block';
			ul[c1].style.background = 'red';
		}
		//开始切换
		function change() {
			c++;
			c = c == 5 ? 0 : c;
			Change(c);

		}
		timer = setInterval(change, 1500);
		flash.onmouseover = function() {
			clearInterval(timer);//鼠标划过，轮播停止
		}
		//鼠标离开整个容器时继续播放至下一张
		flash.onmouseout = function() {
			timer = setInterval(change, 2000);
		}
		 // 遍历所有数字导航实现划过切换至对应的图片
		 for (var i = 0; i < sum.length; i++) {
		 ul[i].onmouseover = function () {			
		 index = this.innerText - 1;//获得文本中的数字 
		 Change(index);
		 }
		 }
	}
</script>
</html>
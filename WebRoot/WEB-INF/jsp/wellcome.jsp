<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>桂林电子科技大学生活服务网站-首页</title>
    <link rel="stylesheet" type="text/css" href="css/default.css" />
	<link rel="stylesheet" type="text/css" href="css/common.css" />
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<style>
		}
		ul{
			padding-top: 20px;
		}
		#ul{
			padding-left: 20px;
		}
		#ul li{
			display: inline;
			color: white;
			font-size: 18px;
		}
		a{
			text-decoration: none;
		}
	</style>

  </head>
  
  <body onload="init()">
     <jsp:include page="/header.jsp"></jsp:include>
		<!--1.创建一个4行一列的表格-->
			<!--轮播图部分-->
		<div id="">
			<img src="img/1.jpg"  width="100%" height="400px" id="img1"/>
		</div>
		<!--最新帖子，最新公告-->
		<div id="here">
			
		</div>
		<!--版权所有和友情连接-->
		<jsp:include page="/footer.jsp"></jsp:include>
	</body>
</html>

<script type="text/javascript">
	var w,h,className;
	function init(){
		    	window.setInterval("changeImg()",5000);
		    }
		    
		    var i=0
		    function changeImg(){
		    	i++;
		    	document.getElementById("img1").src="img/"+i+".jpg";
		    	if(i==5){
		    		i=0;
		    	}
		    }
	function getSrceenWH(){
		w = $(window).width();
		h = $(window).height();
		$('#dialogBg').width(w).height(h);
	}
	
	window.onresize = function(){  
		getSrceenWH();
	}  
	$(window).resize();  
	
	$(function(){
		getSrceenWH();
		
		//显示弹框
		$('.box #login').click(function(){
			className = $(this).attr('class');
			$('#dialogBg').fadeIn(300);
			$('#dialog').removeAttr('class').addClass('animated '+className+'').fadeIn();
			$('#userName').focus();
		});
		
		//关闭弹窗
		$('.closeDialogBtn').click(function(){
			$('#dialogBg').fadeOut(300,function(){
				$('#dialog').addClass('bounceOutUp').fadeOut();
			});
		});
	});
</script>

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
    
    <title></title>
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

  </head>
  
  <style>
	    #menu{
			border: 1px solid hidden;
			width: 100%;
			height: 65px;
			background-color: #000000;
		}
		#ul{
			padding-top: 20px;
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
  
  <body>
    <div class="headers" style=" background: url('img/head.jpg');height:95px;">
			<table width="100%">
				<tr>
					<!-- <td width="900px">
						<img src="img/head.jpg" />
					</td> -->
					<td align="right">
						<div class="box">
							<div class="demo" style="text-align:right;margin-top:50px;">
								欢迎您:<c:if test="${loginClub==null }">游客！请先 <a href="javascript:" id="login" style="font-weight:bold">登录社团</a>
							<a href="${pageContext.request.contextPath}/clubregist" style="font-weight:bold">注册社团</a></c:if>
							<c:if test="${loginClub!=null }">${loginClub }<a href="${pageContext.request.contextPath}/clublogoutservlet" style="font-weight:bold">注销</a></c:if>
							<a href="Admin" >[管理员]</a>
							</div>
							<div id="dialogBg"></div>
							<div id="dialog" class="animated">
								<img class="dialogIco" width="60" height="50" src="img/ico.png" />
								<div class="dialogTop">
									<a href="javascript:;" class="closeDialogBtn">关闭</a>
								</div>
								<form action="${pageContext.request.contextPath}/clubloginServlet" method="post">
									<ul class="editInfos" style="color: black;">
										<li>社&nbsp;&nbsp;&nbsp;团&nbsp;&nbsp;&nbsp;账&nbsp;&nbsp;&nbsp;号：<input type="text" id="userName" name="clubid" class="ipt" /></li>
										<li>社&nbsp;&nbsp;&nbsp;团&nbsp;&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;码：<input type="password" id="userPass" name="password" class="ipt" /></li>
										<li><input type="submit" value="登录" class="submitBtn" /></li>
									</ul>
								</form>
							</div>
						</div>
					</td>
				</tr>
			</table>
	    </div>
	    <div id="menu">
			<ul id="ul">
				<a href="${pageContext.request.contextPath}/wellcome"><li>首页</li></a>&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath}/listclubarticle"><li>社团公告</li></a>&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath}/secondlistservlet"><li>二手市场</li></a>&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath}/booktypeforbookservlet"><li>图书漂流</li></a>&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath}/lostandfountlistservlet"><li>失物招领</li></a>&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath}/bbslistservlet"><li>生活论坛</li></a>&nbsp;&nbsp;&nbsp;&nbsp;
			</ul>
		</div>
		<div id="qb">
			<div id="nav">
				<img src="img/clublogo.png"/>
			</div>
		</div>
  </body>
</html>
<script type="text/javascript">
	var w,h,className;
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
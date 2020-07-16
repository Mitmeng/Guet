<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>公告详情</title>
    
	<link rel="stylesheet" type="text/css" href="css/default.css" />
	<link rel="stylesheet" type="text/css" href="css/common.css" />
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script src="js/kindeditor/kindeditor-min.js"	type="text/javascript"></script>
	<script src="js/kindeditor/lang/zh_CN.js"	type="text/javascript"></script>

  </head>
  <style>
	#con_inner{
		width: 750px;
		margin-top: 50px;
		padding: 0 10px;
		border: 1px solid red;
	}
	#con_inner p {
	    margin-top: 20px;
	    width: 750px;
	    text-indent: 2em;
	    line-height: 20px;
	}
	#con_inner span{
	    font-size: 20px;
	    font-family: 宋体;
	    margin-top: 16px;
	    mso-spacerun: 'yes'; 
	    mso-font-kerning: 0.0000pt
	}
	.nv{
	border: #DBE1E9 1px solid;
	height: 40px;
	line-height: 40px;
	margin-bottom: 10px;
	/* background: #F7FAFD; */
	overflow: hidden;
	font-size: 18px;
	}
</style>
  <body>
  	<jsp:include page="/clubheader.jsp"></jsp:include>
    <div class="mainbox">
		<div class="nv">
			<div style="float:left;">
				<img src="img/forum_readme.gif" />
				<a href="${pageContext.request.contextPath}/listclubarticle">社团首页</a>&nbsp;》&nbsp;${cArticle.clubtitle }
			</div>
		</div>
		<!-- 主题帖子 -->
		<table class="bbslist border" style="width:100%; table-layout: fixed; word-break: break-all;" 
			cellSpacing="0" cellPadding="0">
			<tr>
				<td class="foleft leftcolor" style="width: 20%;border-right: 1px solid #E9EFF4;" vAlign="top" rowSpan="3"><br>
					<table>
						<tr><td><span>社团名称：&nbsp;${cArticle.clubname }</span></td></tr>
						<tr><td><span>发布时间：&nbsp;${cArticle.releasedate }</span></td></tr>
						<tr><td><span>阅读数量：&nbsp;${cArticle.totalread }</span></td></tr>
					</table>
				</td>
				<td style="line-height: 120%;" class="inforight" vAlign="top">
					<div id="con_inner">
						<h4 style="text-align: center;font-size: 24px;color: red;padding-top: 16px; padding-bottom: 16px;border-bottom: 2px solid #ff8921;">${cArticle.clubtitle }</h4>
						<p class="MsoNormal"style=" text-align: justify;text-justify:inter-ideograph;">
						<span style="margin-top:40px;">${cArticle.clubcontent }</span>
						</p><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
					</div>
				</td>
			</tr>
		</table>
	</div>
  </body>
</html>

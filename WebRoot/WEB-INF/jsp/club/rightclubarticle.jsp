<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'rightclubarticle.jsp' starting page</title>
    
	<link rel="stylesheet" type="text/css" href="css/default.css" />
	<link rel="stylesheet" type="text/css" href="css/common.css" />
	<script type="text/javascript" src="js/jquery.min.js"></script>

  </head>
  <style>
	h3{
		font-size: 15;
		text-align: center;
	}
	</style>
  <body>
    <div cellSpacing="0" cellPadding="0" style="width: 1292px;height:400px;padding-top: 10px;border:double; border-color:#BEE9F0;">
		<tr>
			<td>
				<div style="height:100%; text-indent: 24px; overflow: hidden; font-size: 12pt; word-break: break-all; word-wrap: break-word;" id="textstyle_1">
					<h3>社团简介</h3>
					<div style="text-indent:2em;">${club.introduce }</div>
				</div>
			</td>
		</tr>
	</div><br>
  </body>
</html>

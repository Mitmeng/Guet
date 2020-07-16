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
    
    <title>My JSP 'myclub.jsp' starting page</title>
    <meta name="keywords" content="" />
	<link rel="SHORTCUT ICON" href="favicon.ico" />
	<link rel="stylesheet" type="text/css" href="css/default.css" />
	<script type="text/javascript" src="jquery/jquery-1.8.2.min.js"></script>
	<script src="lib/kindeditor/kindeditor-min.js"	type="text/javascript"></script>
	<script src="lib/kindeditor/lang/zh_CN.js"	type="text/javascript"></script>

  </head>
  
  <body>
    <div id="father">
    	<!--社团头部-->
    	<jsp:include page="/header.jsp"></jsp:include>
    	<div style="background: url('img/book.jpg');height:95px;">
		<form>
			<div id = "top" class="notice"style="padding-top: 47px;padding-right: 25px;">
				<input style="background-color:#C0C0C0;" type="text" name="keyword" size="35" placeholder="请输入关键字" value="${title }"/>&nbsp;&nbsp;&nbsp;
				<button type="submit" class="btn btn-primary ">搜索</button>&nbsp;&nbsp;
			</div>
		</form>
	</div>
		<table class="bbslist border" style="width:100%;height: 700px; table-layout: fixed; word-break: break-all;" 
			cellSpacing="0" cellPadding="0">
			<tr>
				<td class="infoleft leftcolor" vAlign="top" rowSpan="3"><br>
					<table cellspacing="0" cellpadding="0" style="width: 100%;border-bottom-color: currentColor; border-bottom-width: medium; border-bottom-style: none; margin-top:10px;">
						<tr><th align="center"><span>&nbsp;</span></th></tr>
						<c:forEach items="${Alltypelist }" var="typelist" varStatus="status">
							<tr><td align="center"><a href="booklistservlet?id=${typelist.id }" target="in">${typelist.typename }</a></td></tr>
						</c:forEach>
					</table>
				</td>
				<td style="line-height: 120%;" class="inforight" vAlign="top">
					<iframe src="booklistservlet?id=0" width=100% height=700px name="in" frameborder="0" ></iframe>
				</td>
			</tr>
		</table>
	</div>
  </body>
</html>


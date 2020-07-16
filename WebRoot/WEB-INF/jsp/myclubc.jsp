<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    	<jsp:include page="/clubheader.jsp"></jsp:include>
		<table class="topic border" style="width:100%; border-bottom-color: currentColor; border-bottom-width: medium; border-bottom-style: none; margin-top:10px;" cellSpacing="0" cellPadding="0">
				<tr>
					<th colspan="5">
						<h1 style="float:left;font-size:15;">社团名称:&nbsp;&nbsp; </h1>${loginClub }
					</th>
				</tr>
		</table>
			
			<!-- 主题帖子 -->
		<table class="bbslist border" style="width:100%;height: 700px; table-layout: fixed; word-break: break-all;" 
			cellSpacing="0" cellPadding="0">
			<tr>
				<td class="infoleft leftcolor" vAlign="top" rowSpan="3"><br>
					<table cellspacing="0" cellpadding="0" style="width: 100%;border-bottom-color: currentColor; border-bottom-width: medium; border-bottom-style: none; margin-top:10px;">
						<tr><th align="center"><span>&nbsp;</span></th></tr>
						<tr><td align="center"><a id="jspone" href="addclubarticle?clubname=${loginClub }" target="in">编辑新公告</a></td></tr>
						<tr><td align="center"><a id="jsptwo" href="draftclubservlet?clubname=${loginClub }&id=1" target="in">公告草稿箱</a></td></tr>
						<tr><td align="center"><a id="jspthree" href="draftclubservlet?clubname=${loginClub }&id=2" target="in">待审核公告</a></td></tr>
						<tr><td align="center"><a id="jspfour" href="draftclubservlet?clubname=${loginClub }&id=3" target="in">已审核公告</a></td></tr>
						<tr><td align="center"><a id="jspfive" href="draftclubservlet?clubname=${loginClub }&id=4" target="in">所有的公告</a></td></tr>
						<tr><td align="center"><a id="jspsix" href="addclubintroduce?clubname=${loginClub }" target="in">编辑社团简介</a></td></tr>
					</table>
				</td>
				<td style="line-height: 120%;" class="inforight" vAlign="top">
					<table class="topic border" style="width:100%; border-bottom-color: currentColor; border-bottom-width: medium; border-bottom-style: none; margin-top:10px;" cellSpacing="0" cellPadding="0">
						<th colspan="5">
							<img src="img/forum_readme.gif" />
							<a href="listclubarticle">社团首页</a>&nbsp;>>&nbsp;社团
						</th>
					</table>
					<iframe src="Introduceservle?clubintroid=${Clubintroid }" width=100% height=650px name="in" frameborder="0" scrolling="no"></iframe>
				</td>
			</tr>
		</table>
	</div>
  </body>
</html>


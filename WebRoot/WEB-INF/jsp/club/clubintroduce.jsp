<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'clubintroduce.jsp' starting page</title>

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
		font-size: 20px;
	}
  </style>
  <body>
    <jsp:include page="/clubheader.jsp"></jsp:include>
    <div class="mainbox">
		<div class="nv">
			<div style="float:left;">
				<img src="img/forum_readme.gif" />
				<a href="${pageContext.request.contextPath}/listclubarticle">社团首页</a>&nbsp;》&nbsp;${club.clubname }
			</div>
		</div>
		<!-- 主题帖子 -->
		<div class="bslist border" style="width:100%;height:90%; table-layout: fixed; word-break: break-all;" 
			cellSpacing="0" cellPadding="0">
			<tr>
				<td style="line-height: 120%;" class="iforight" vAlign="top">
					<div id="con_inner">
						<h4 style="text-align: center;font-size: 24px;color: red;padding-top: 16px; padding-bottom: 16px;border-bottom: 2px solid #ff8921;">社团简介</h4>
						<p class="MsoNormal"style=" text-align: justify;text-justify:inter-ideograph;">
						<span style="margin-top:40px;">${club.introduce }</span>
						</p><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
					</div>
				</td>
			</tr>
		 </div>
	</div>
  </body>
</html>

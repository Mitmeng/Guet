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
		margin: 0 auto;
		width: 800px;
		margin-left: 250px;
		margin-top: 50px;
		padding: 0 10px;
		border: 1px solid black;
	}
	#con_inner p {
	    margin-top: 20px;
	    width: 800px;
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
	a{
		text-decoration: none;
	}
  </style>
  <body>
    <div class="mainbox">
		<div class="nv">
			<div style="float:left;">
				<img src="img/forum_readme.gif" />
				  <% String type1=request.getParameter("bbstitle");
	 				String type2=request.getParameter("bbscontent");
	 				String type3=request.getParameter("id"); %>
				<a href="javascript:" onclick="jump(<%=type3%>)">返回列表</a>&nbsp;》&nbsp;<%=type1%>
			</div>
		</div>
		<!-- 主题帖子 -->
		<div class="bslist border" style="width:100%;height:90%; table-layout: fixed; word-break: break-all;margin: 0 auto;" 
			cellSpacing="0" cellPadding="0">
			<tr>
				<td style="line-height: 120%;" class="iforight" vAlign="top">
					<div id="con_inner">
						<h4 style="text-align: center;font-size: 20px;padding-top: 16px; padding-bottom: 16px;border-bottom: 2px solid #ff8921;"><%=type1%></h4>
						<p class="MsoNormal"style=" text-align: justify;text-justify:inter-ideograph;">
						<span style="margin-top:40px;"><%=type2%></span>
						</p><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
					</div>
				</td>
			</tr>
		 </div>
	</div>
  </body>
</html>
<script type="text/javascript">
	function jump(articleId){
		var i = new Number(articleId)
		//alert(i);
		if(i==1) {
			location="${pageContext.request.contextPath}/admin/bbslistservlet";//(此处自己改)
		}
	    else if(i==2){
	        location="${pageContext.request.contextPath }/admin/clublistservlet";//(此处自己改)
	    }else if(i==3){
			location="${pageContext.request.contextPath }/admin/clubwaitlistservlet";
		} 
}
</script>

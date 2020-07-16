<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <base href="<%=basePath%>">
    
    <title>帖子详情</title>
    
	<meta name="keywords" content="" />
	<link rel="SHORTCUT ICON" href="favicon.ico" />
	<link rel="stylesheet" type="text/css" href="css/default.css" />
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script src="js/kindeditor/kindeditor-min.js"	type="text/javascript"></script>
	<script src="js/kindeditor/lang/zh_CN.js"	type="text/javascript"></script>

  </head>
  
  <body>
  	<jsp:include page="/header.jsp"></jsp:include>
  	<div id="top" class="header"></div>
    <div class="mainbox">
		<div>
			<img src="img/logo.png" />
		</div>
		<div class="nav" style="font-size: 18px;">
			<div style="float:left;">
				<img src="img/forum_readme.gif" />
				<a href="bbslistservlet">论坛首页</a>&nbsp;>>&nbsp;帖子详情
			</div>
			<%-- <form>
				<div class="notice">
					<input type="text" size="35" name="keyword" placeholder="请输入关键字" value="${title }"/>&nbsp;&nbsp;&nbsp;
					<button type="submit" class="btn btn-primary ">搜索</button>&nbsp;&nbsp;
				</div>
			</form> --%>
		</div><br/>
		<table style="width:100%; margin-bottom: -5px;" cellSpacing="0" cellPadding="0">
			<tr>
				<td style="text-align: left;">
					<a href="mybbs"><img src="img/post.gif" /></a>&nbsp;
					<a href="javascript:void(0)" onclick="document.getElementById('reply').scrollIntoView();"><img src="img/post_reply1.gif" /></a>&nbsp;
				</td>
			</tr>
		</table>
		<table class="topic border" style="width:100%; border-bottom-color: currentColor; border-bottom-width: medium; border-bottom-style: none; margin-top:10px;" cellSpacing="0" cellPadding="0">
			<tr>
				<th colSpan="5">
					<span>&nbsp;&nbsp;共有<b style="color: rgb(255, 102, 0);">${bArticle.totalreply }</b>人评论过本帖
					</span>主题：${bArticle.title }
				</th>
			</tr>
		</table>
		
		
		<!--
        	作者：offline
        	时间：2017-05-15
        	描述：主贴内容
        -->
		<table class="bbslist border" style="width:100%; table-layout: fixed; word-break: break-all;" cellSpacing="0" cellPadding="0">
			<tr>
				<td style="background: rgb(250, 253, 255); border-bottom-color: rgb(228, 231, 236); border-bottom-width: 1px; border-bottom-style: solid;" class="infoleft leftcolor" vAlign="middle">
					<span class="username">
						<c:if test="${user.gender==0 }"><img src="img/female.gif"></c:if>
						<c:if test="${user.gender==1 }"><img src="img/male.gif"></c:if>
						<div>
							<span style="width: 105px; filter: glow(color='#A6BA98',strength='2');">
								<font color="#61b713" face="Verdana"><b><a href="javascript:void(0);">${bArticle.createperson }</a></b></font>
							</span>
						</div>
					</span>
				</td>
				<td class="usermenu">
					<em>地基</em>
				</td>
			</tr>
			<tr>
				<td class="infoleft leftcolor" vAlign="top" rowSpan="3"><br>
					<c:if test="${user.gender==0 }"><span>性别：女</span></c:if>
					<c:if test="${user.gender==1 }"><span>性别：男</span></c:if>
					<span>帖子：<b class="green">${totalnumber }</b></span>
				</td>
				<td style="line-height: 120%;" class="inforight" vAlign="top">
					<b style="line-height: 15px; font-size: 12px;">${bArticle.title }</b>&nbsp;&nbsp;
					<span style="line-height: 20px;" class="font10">
						Post By：${bArticle.lastupdatetime }
					</span>
					
					<br><br>
					<table cellSpacing="0" cellPadding="0">
						<tr>
							<td>
								<div style="text-indent: 24px; overflow: hidden; font-size: 9pt; word-break: break-all; word-wrap: break-word;" id="textstyle_1">
									${bArticle.content }
				
								</div>
							</td>
						</tr>
					</table><br>
				</td>
			</tr>
			<tr>
				<td class="signed"></td>
			</tr>
			<tr>
				<td class="usermenu2">
					<span class="imp"></span>
					<a id="agree_119222_1" title="强烈支持此楼观点，顶！"  href="javascript:" onclick="agre(1,${bArticle.id})">支持</a>(<span style="color: blue; font-weight: bold;" id="agree_119222_1_n">${bArticle.agree }</span>)&nbsp;
					<a id="agree_119222_2" title="坚决不同意此楼观点，反对！"  href="javascript:" onclick="agre(2,${bArticle.id})">反对</a>(<span style="color: red; font-weight: bold;" id="agree_119222_2_n">${bArticle.disagree }</span>)&nbsp; 
					<span style="padding: 5px;"><span style="display: inline;" class="m_li_top"> 
					<a href="javascript:" onclick="del(${bArticle.id},${bArticle.id})">删除</a>
					&nbsp;|&nbsp; 
					<a href="javascript:void(0)" onclick="document.getElementById('top').scrollIntoView();"><img style="padding-bottom: 10px;" alt="回到顶部" src="img/p_up.gif"></a>
					</span></span>
				</td>
			</tr>
		</table>
		
		
    <!--作者：offline
	时间：2017-05-15
	描述：回复帖子的内容，回复-->
		<c:forEach items="${pageBean.list }" var="bbsartreply" varStatus="status">
			<table class="bbslist border" style="width:100%; table-layout: fixed; word-break: break-all;" cellSpacing="0" cellPadding="0">
				<tr>
					<td style="background: rgb(250, 253, 255); border-bottom-color: rgb(228, 231, 236); border-bottom-width: 1px; border-bottom-style: solid;" class="infoleft leftcolor" vAlign="middle">
						<span class="username">
							<img src="img/male.gif">
							<div>
								<span style="width: 105px; filter: glow(color='#A6BA98',strength='2');">
									<font color="#61b713" face="Verdana"><b><a href="javascript:void(0);">${bbsartreply.createperson }</a></b></font>
								</span>
							</div>
						</span>
					</td>
					<td class="usermenu">
						<em>${status.count }楼</em>
					</td>
				</tr>
				<tr>
					<td class="infoleft leftcolor" vAlign="top" rowSpan="3"><br>
						<span>账号：<b class="green">${bbsartreply.stuid }</b></span>
					</td>
					<td style="line-height: 70%;" class="inforight" vAlign="top">
						<b style="line-height: 15px; font-size: 12px;">回复</b>&nbsp;&nbsp;
						<span style="line-height: 20px;" class="font10">
							Post By：${bbsartreply.lastupdatetime }
						</span>
						
						<br><br>
						<table cellSpacing="0" cellPadding="0">
							<tr>
								<td>
									<div style="text-indent: 24px; overflow: hidden; font-size: 9pt; word-break: break-all; word-wrap: break-word;" id="textstyle_1">
										${bbsartreply.content }
					
									</div>
								</td>
							</tr>
						</table><br>
					</td>
				</tr>
				<tr>
					<td class="signed"></td>
				</tr>
				<tr>
					<td class="usermenu2">
						<span style="padding: 5px;"><span style="display: inline;" class="m_li_top">
						<a href="javascript:" onclick="del(${bArticle.id},${bbsartreply.id})">删除</a>
						&nbsp;|&nbsp; 
						<a href="javascript:void(0)" onclick="document.getElementById('top').scrollIntoView();"><img style="padding-bottom: 10px;" alt="回到顶部" src="img/p_up.gif"></a>
						</span></span>
					</td>
				</tr>
			</table>
		</c:forEach>
		<!-- 分页 -->
		<%-- <c:if test="${pageBean.list!=null}"> --%>
		<div style="width: 380px; margin: 0 auto; margin-top: 20px;">
			<ul class="pagination" style="text-align: center; margin-top: 10px;">

			<!-- 上一页 -->
			<c:if test="${pageBean.currentPage==1 }">
					<a href="javascript:void(0);" aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
					</a>
			</c:if>
			<c:if test="${pageBean.currentPage!=1 }">
					<a href="${pageContext.request.contextPath}/bbsdetailarticleservlet?currentPage=${pageBean.currentPage-1 }&articleid=${bArticle.id}" aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
					</a>
			</c:if>
	
		
			<!-- 显示每一页 -->
			<c:forEach begin="1" end="${pageBean.totalPage }" var="page">
				<!-- 判断是否是当前页 -->
				<c:if test="${page==pageBean.currentPage }">
					<a href="javascript:void(0);">&nbsp;&nbsp;${page }&nbsp;&nbsp;</a>
				</c:if>
				<c:if test="${page!=pageBean.currentPage }">
					<a href="${pageContext.request.contextPath}/bbsdetailarticleservlet?currentPage=${page }&articleid=${bArticle.id}">&nbsp;&nbsp;${page }&nbsp;&nbsp;</a>
				</c:if>
			</c:forEach>
	
	
			<!-- 下一页 -->
			<c:if test="${pageBean.currentPage==pageBean.totalPage||pageBean.totalPage==0 }">
					<a href="javascript:void(0);" aria-label="Next"> 
						<span aria-hidden="true">&raquo;</span>
					</a>
				
			</c:if>
			<c:if test="${pageBean.currentPage!=pageBean.totalPage&&pageBean.totalPage!=0 }">
					<a href="${pageContext.request.contextPath}/bbsdetailarticleservlet?currentPage=${pageBean.currentPage+1 }&articleid=${bArticle.id}" aria-label="Next"> 
						<span aria-hidden="true">&raquo;</span>
					</a>
			</c:if>
	
			</ul>
	    </div><br><br>
	    <%-- </c:if>  --%>   
		<!-- 回复 -->
		<table class="topic border" style="width:100%; border-bottom-color: currentColor; border-bottom-width: 0px; border-bottom-style: none;" cellSpacing="0" cellPadding="0">
			<tr>
				<th>
					<span style="float: right;">
						<a href="head_detail.html"><b></b></a>
					</span>
					<h1></h1>
				</th>
			</tr>
		</table>
		<form action="${pageContext.request.contextPath }/addbbsreplyarticle" name="form1" method="post" class="definewidth m20" onsubmit="return check()" >
			<input type="hidden" name="AritcleId" value="${bArticle.id}"/>
			<table class="tablebox border" cellSpacing="0" cellPadding="0" style="width:100%;">
				<tr>
					<td style="background: rgb(250, 253, 255); padding: 10px; text-align: center;" class="infoleft leftcolor" vAlign="top" align="center">
						请输入回复内容：
					</td>
					<td style="margin: 0px; padding: 0px;">
						<span id="reply">
							<textarea name="content" id="content" style="width: 100%; height: 200px; visibility: hidden;"></textarea>
						</span>
					</td>
				</tr>
				<tr>
					<td class="infoleft leftcolor" vAlign="top" align="center">
					</td>
					<td>
						<input style="margin: 3px 3px 3px 0px;" class="input0" value="OK!发表回复" type="submit" /> 
						<span id="body_chk"></span> 
					</td>
				</tr>
				</tbody>
			</table>
		</form>
	</div>
	<!---------------end 底部友情链接部分------------------->
	<jsp:include page="/footer.jsp"></jsp:include>
  </body>
</html>
<script type="text/javascript">
	var editor;
	KindEditor.ready(function(K) {
		editor = K.create('textarea[name="content"]', {
			resizeType : 1,
			allowPreviewEmoticons : false,
			allowImageUpload : false,
			items : [ 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor',
					'bold', 'italic', 'underline', 'removeformat', '|',
					'justifyleft', 'justifycenter', 'justifyright',
					'insertorderedlist', 'insertunorderedlist', '|',
					'link' ]
		});
	});

	function openMenu(self){
		var left = $(self).offset().left;
		var top = $(self).offset().top + 22;
		$(self).next().css("left", left).css("top", top).show();
	}

	function del(id,articleId){
		if(confirm("确定要删除吗？")){
			location="${pageContext.request.contextPath}/delbbsarticleservlet?articleId="+articleId+"&id="+id;
		}
	}

	function agre(i,articleId){
		switch(i){
			 case 1:
		       location="${pageContext.request.contextPath}/agreebbsarticleservlet?articleId="+articleId;
		       break;
		     case 2:
		       location="${pageContext.request.contextPath}/disagreebbsarticleservlet?articleId="+articleId;
		}
	}

	function closeMyApp(obj){
		var mouseX = getX(getEvent());
		var left = obj.style.left;
		left = parseInt(left.substr(0, left.length - 2));
		if (mouseX < left || mouseX > left+70){
			$(obj).hide();
		}
	}

	function getEvent() { 
	    if(document.all) 
	    { 
	        return window.event; 
	    } 
	    func = getEvent.caller; 
	    while(func != null) 
	    { 
	        var arg0 = func.arguments[0]; 
	        if(arg0) 
	        { 
	            if((arg0.constructor == Event || arg0.constructor == MouseEvent) ||(typeof(arg0) == "object" && arg0.preventDefault && arg0.stopPropagation)) 
	            { 
	                return arg0; 
	            } 
	        } 
	        func = func.caller; 
	    } 
	    return null; 
	}
	
	function check(){
		var content = $("#content").val();
		if(content==''||content==null){
			alert("内容不能为空！");
			return false;
		}
		else{
			return true;
		}
	}
		
	function doSubmit()
		{
			 form1.action="${pageContext.request.contextPath }/addbbsreplyarticle";//(此处自己改)
		}
	
	function getX(e) {
	  e = e || window.event;
	  return e.x || e.clientX - 30;
	}
</script>3
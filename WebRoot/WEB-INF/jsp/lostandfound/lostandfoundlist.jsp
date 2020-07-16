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
    
    <title>My JSP 'secondfather.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<meta name="keywords" content="" />
	<link rel="SHORTCUT ICON" href="favicon.ico" />
	<link rel="stylesheet" type="text/css" href="css/default.css" />
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script src="js/kindeditor/kindeditor-min.js"	type="text/javascript"></script>
	<script src="js/kindeditor/lang/zh_CN.js"	type="text/javascript"></script>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js" type="text/javascript"></script>
	

  </head>
  
  <body>
   	 <jsp:include page="/header.jsp"></jsp:include>
   	 <div style="background: url('img/lost.jpg');height:95px;">
		<!-- <div style="float: left;">
			<img src="img/second.jpg"/>
		</div> -->
		<form>
			<div id = "top" class="notice"style="padding-top: 47px;padding-right: 25px;">
				<input style="background-color:#C0C0C0;" type="text" name="keyword" size="35" placeholder="请输入关键字" value="${title }"/>&nbsp;&nbsp;&nbsp;
				<button type="submit" class="btn btn-primary ">搜索</button>&nbsp;&nbsp;
			</div>
		</form>
	</div>
	<table style="width:100%; margin-bottom: -5px;" cellSpacing="0" cellPadding="0">
			<tr>
				<td style="text-align: left;">
					<a href="${pageContext.request.contextPath}/foraddnewlost"><img src="img/addnew.gif" /></a>&nbsp;
				</td>
			</tr>
	</table> 
	<c:forEach items="${pageBean.list }" var="lostlist" varStatus="status">
	<table class="topic border" style="width:100%; border-bottom-color: currentColor; border-bottom-width: medium; border-bottom-style: none; margin-top:10px;" cellSpacing="0" cellPadding="0">
			<tr>
				<th colSpan="5">
					<span>&nbsp;&nbsp;共有<b style="color: rgb(255, 102, 0);">${lostlist.totalreply }</b>人留言
					</span><c:if test="${lostlist.lostorfount==1 }">失物招领</c:if>
						   <c:if test="${lostlist.lostorfount==0 }">寻物启事</c:if>
				</th>
			</tr>
	</table>
	<table class="bbslist border" style="width:100%; table-layout: fixed; word-break: break-all;" cellSpacing="0" cellPadding="0">
			<tr>
				<td class="infoleft leftcolor" vAlign="top" rowSpan="3"><br>
					<span style="width: 105px; filter: glow(color='#A6BA98',strength='2');">
						<font color="#61b713" face="Verdana"><b><a href="javascript:void(0);">发布者:${lostlist.createperson }</a></b></font>
					</span>
					<span>状态：<b class="green"> 
						<c:if test="${lostlist.state==0 }"><a href="javascript:" onclick="finish(${lostlist.id})">未结帖</a></c:if> 
						<c:if test="${lostlist.state==1 }">已结帖</c:if></span>
					<span >发布时间:<br></span>
					<span style="font-size:15px">${lostlist.createtime }</span>
				</td>
				<td style="line-height: 120%;" class="inforight" vAlign="top">
					<b style="line-height: 15px; font-size: 12px;"></b>&nbsp;&nbsp;
					<span style="line-height: 20px;" class="font11">
						Pose by：ID${lostlist.stuid }
					</span>
					<br/>
					<table cellSpacing="0" cellPadding="0" style="table-layout: fixed;" >
						<tr>
						    <td style="width: 300px;"><div style="width: 100%;overflow: auto;"><div style="width: 300px;height: 250px;">
						    <a href="seconddetailservlet?secondid=${lostlist.id }"><img alt="#" src="${lostlist.img }" onload="javascript:DrawImage(this,300,250)" style="cursor:pointer;"/></a>
						   </div></div></td>
							<td>
								<div style="text-indent: 24px; overflow: hidden; font-size: 12pt; word-break: break-all; word-wrap: break-word;" id="textstyle_1">
									${lostlist.content }
				
								</div>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td class="signed"></td>
			</tr>
			<tr>
				<td class="usermenu2" colspan="1">
					<span class="imp"></span>
					<a id="agree_119222_2" title="查看留言！"  href="seconddetailservlet?secondid=${secondlist.id }&id=1">查看留言</a>&nbsp; 
					<span style="padding: 5px;"><span style="display: inline;" class="m_li_top"> 
					<a href="javascript:" onclick="del(${lostlist.id})">删除</a>
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
				<a href="${pageContext.request.contextPath}/lostandfountlistservlet?currentPage=${pageBean.currentPage-1 }&articleid=${bArticle.id}" aria-label="Previous">
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
				<a href="${pageContext.request.contextPath}/lostandfountlistservlet?currentPage=${page }&articleid=${bArticle.id}">&nbsp;&nbsp;${page }&nbsp;&nbsp;</a>
			</c:if>
		</c:forEach>


		<!-- 下一页 -->
		<c:if test="${pageBean.currentPage==pageBean.totalPage||pageBean.totalPage==0 }">
				<a href="javascript:void(0);" aria-label="Next"> 
					<span aria-hidden="true">&raquo;</span>
				</a>
			
		</c:if>
		<c:if test="${pageBean.currentPage!=pageBean.totalPage&&pageBean.totalPage!=0 }">
				<a href="${pageContext.request.contextPath}/lostandfountlistservlet?currentPage=${pageBean.currentPage+1 }&articleid=${bArticle.id}" aria-label="Next"> 
					<span aria-hidden="true">&raquo;</span>
				</a>
		</c:if>

		</ul>
    </div><br><br>
	<%-- <!---------------end 底部友情链接部分------------------->
	<jsp:include page="/footer.jsp"></jsp:include> --%>
  </body>
  
</html>
<script type="text/javascript" language="JavaScript">
	var flag=false;
	function DrawImage(ImgD,iwidth,iheight){
	 	var image= new Image();
		image.src=ImgD.src;
		if(image.width>0&&image.height>0){
			flag=true;
			if(image.width/image.height>=iwidth/iheight){
				if(image.width>iwidth){
					ImgD.width=iwidth;
					ImgD.height=(image.height*iwidth)/image.width;
				}else{
					ImgD.width=image.width;
					ImgD.height=image.height;
				}
			ImgD.alt=image.width+"#"+image.height;
			}else{
				if(image.height>iheight){
					ImgD.height=iheight;
					ImgD.width=(image.width*iheight)/image.height;
				}else{
					ImgD.width=image.width;
					ImgD.height=image.height;
				}
			ImgD.alt=image.width+"#"+image.height;
		}
		}
	}
	
	
	function del(articleId){
		if(confirm("确定要删除吗？")){
			location="${pageContext.request.contextPath}/dellostandfountservlet?articleId="+articleId;
		}
	}
	
	function finish(articleId){
		if(confirm("确定要结帖吗？")){
			location="${pageContext.request.contextPath}/updateloststateservlet?articleId="+articleId;
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
	
	function addreply(articleid){
		document.getElementById("replyForm").style.display="block";
		document.getElementById('reply').scrollIntoView();
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
	
	
	function getX(e) {
	  e = e || window.event;
	  return e.x || e.clientX - 30;
	}
	
	
	
</script>

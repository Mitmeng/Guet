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
   	 <div style="background: url('img/second.jpg');height:95px;">
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
					<a href="${pageContext.request.contextPath}/foraddnewsecondhandservlet"><img src="img/addnew.gif" /></a>&nbsp;
					<a href="mysecond"><img src="img/post_reply.gif" /></a>&nbsp;
				</td>
			</tr>
	</table> 
	<c:forEach items="${pageBean.list }" var="secondlist" varStatus="status">
	<table class="topic border" style="width:100%; border-bottom-color: currentColor; border-bottom-width: medium; border-bottom-style: none; margin-top:10px;" cellSpacing="0" cellPadding="0">
			<tr>
				<th colSpan="5">
					<span>&nbsp;&nbsp;共有<b style="color: rgb(255, 102, 0);">${secondlist.totalreply }</b>人留言
					</span>主题：${secondlist.title }
				</th>
			</tr>
	</table>
	<table class="bbslist border" style="width:100%; table-layout: fixed; word-break: break-all;" cellSpacing="0" cellPadding="0">
			<tr>
				<td style="background: rgb(250, 253, 255); border-bottom-color: rgb(228, 231, 236); border-bottom-width: 1px; border-bottom-style: solid;" class="infoleft leftcolor" vAlign="middle">
					<span class="username">
						<div>
							<span style="width: 105px; filter: glow(color='#A6BA98',strength='2');">
								<font color="#61b713" face="Verdana"><b><a href="javascript:void(0);">发布者:${secondlist.createperson }</a></b></font>
							</span>
						</div>
					</span>
				</td>
				<td class="usermenu" colspan="1">
					<em>
						<c:if test="${secondlist.buyorsale==1 }"><span style="color: rgb(255, 102, 0);">出售</span></c:if>
						<c:if test="${secondlist.buyorsale==0 }"><span style="color: rgb(255, 102, 0);">购买</span></c:if>
					</em>
				</td>
			</tr>
			<tr>
				<td class="infoleft leftcolor" vAlign="top" rowSpan="3"><br>
					<c:forEach items="${alltypelist }" var="typelist">
						<c:if test="${typelist.id==secondlist.producttype }"><span>类型：${typelist.typename }</span></c:if>
					</c:forEach> 
					<%-- <span>类型:${alltypelist[secondlist.producttype] }</span> --%>
					<span>状态：<b class="green"> 
						<c:if test="${secondlist.state==0&&secondlist.buyorsale==1 }"><a href="javascript:" onclick="finish(${secondlist.id})">未售出</a></c:if> 
						<c:if test="${secondlist.state==1&&secondlist.buyorsale==1 }">已售出</c:if>
						<c:if test="${secondlist.state==0&&secondlist.buyorsale==0 }"><a href="javascript:" onclick="finish(${secondlist.id})">未购买</a></c:if> 
						<c:if test="${secondlist.state==1&&secondlist.buyorsale==0 }">已购买</c:if>
					</b></span>
					<span >发布时间:<br></span>
					<span style="font-size:15px">${secondlist.createtime }</span>
				</td>
				<td style="line-height: 120%;" class="inforight" vAlign="top">
					<b style="line-height: 15px; font-size: 12px;"></b>&nbsp;&nbsp;
					<span style="line-height: 20px;" class="font11">
						<c:if test="${secondlist.price!=0 }">Price：￥${secondlist.price }</c:if>
					</span>
					<br/>
					<table cellSpacing="0" cellPadding="0" style="table-layout: fixed;" >
						<tr>
						    <td style="width: 300px;"><div style="width: 100%;overflow: auto;"><div style="width: 300px;height: 250px;">
						    <a href="seconddetailservlet?secondid=${secondlist.id }&id=1"><img alt="#" src="${secondlist.img }" onload="javascript:DrawImage(this,300,250)" style="cursor:pointer;"/></a>
						   </div></div></td>
							<td>
								<div style="text-indent: 24px; overflow: hidden; font-size: 12pt; word-break: break-all; word-wrap: break-word;" id="textstyle_1">
									${secondlist.content }
				
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
					<a href="javascript:" onclick="del(${secondlist.id},${secondlist.id},1)">删除</a>
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
				<a href="${pageContext.request.contextPath}/secondlistservlet?currentPage=${pageBean.currentPage-1 }&articleid=${bArticle.id}" aria-label="Previous">
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
				<a href="${pageContext.request.contextPath}/secondlistservlet?currentPage=${page }&articleid=${bArticle.id}">&nbsp;&nbsp;${page }&nbsp;&nbsp;</a>
			</c:if>
		</c:forEach>


		<!-- 下一页 -->
		<c:if test="${pageBean.currentPage==pageBean.totalPage||pageBean.totalPage==0 }">
				<a href="javascript:void(0);" aria-label="Next"> 
					<span aria-hidden="true">&raquo;</span>
				</a>
			
		</c:if>
		<c:if test="${pageBean.currentPage!=pageBean.totalPage&&pageBean.totalPage!=0 }">
				<a href="${pageContext.request.contextPath}/secondlistservlet?currentPage=${pageBean.currentPage+1 }&articleid=${bArticle.id}" aria-label="Next"> 
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
	
	
	function del(id,articleId,idd){
		if(confirm("确定要删除吗？")){
			location="${pageContext.request.contextPath}/delsecondreplyservlet?articleId="+id+"&parentid="+articleId+"&id="+idd;
		}
	}
	
	function finish(articleId){
		if(confirm("确定要结帖吗？")){
			location="${pageContext.request.contextPath}/updateprostateservlet?articleId="+articleId+"&id="+1;
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

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
  	<div id="top">&nbsp;</div>
  	<c:forEach items="${pageBean.list }" var="secondlist" varStatus="status">
	    <table class="bbslist border" style="width:100%; table-layout: fixed; word-break: break-all;" cellSpacing="0" cellPadding="0">
				<tr>
					<td class="infoleft leftcolor" vAlign="top" rowSpan="3"><br>
						<c:forEach items="${alltypelist }" var="typelist">
							<c:if test="${typelist.id==secondlist.producttype }"><span>分类：${typelist.typename }</span></c:if>
						</c:forEach> 
						<c:if test="${secondlist.buyorsale==1 }"><span>类型:出售</span></c:if>
						<c:if test="${secondlist.buyorsale==0 }"><span>类型:购买</span></c:if>
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
						<table cellSpacing="0" cellPadding="0" style="table-layout: fixed;" >
							<tr>
							    <td style="width: 300px;"><div style="width: 100%;overflow: auto;"><div style="width: 300px;height: 250px;">
							    <img alt="#" src="${secondlist.img }" onload="javascript:DrawImage(this,300,250)"  onclick="this.style.zoom='2'" onclick="javascript:window.open(this.src);" style="cursor:pointer;"/>
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
						<a id="replys" title="强烈支持此楼观点，顶！" href="seconddetailservlet?secondid=${secondlist.id }&id=2" >查看留言</a>&nbsp;
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
				<a href="${pageContext.request.contextPath}/usersecondhandservlet?currentPage=${pageBean.currentPage-1 }&articleid=${bArticle.id}" aria-label="Previous">
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
				<a href="${pageContext.request.contextPath}/usersecondhandservlet?currentPage=${page }&articleid=${bArticle.id}">&nbsp;&nbsp;${page }&nbsp;&nbsp;</a>
			</c:if>
		</c:forEach>


		<!-- 下一页 -->
		<c:if test="${pageBean.currentPage==pageBean.totalPage||pageBean.totalPage==0 }">
				<a href="javascript:void(0);" aria-label="Next"> 
					<span aria-hidden="true">&raquo;</span>
				</a>
			
		</c:if>
		<c:if test="${pageBean.currentPage!=pageBean.totalPage&&pageBean.totalPage!=0 }">
				<a href="${pageContext.request.contextPath}/usersecondhandservlet?currentPage=${pageBean.currentPage+1 }&articleid=${bArticle.id}" aria-label="Next"> 
					<span aria-hidden="true">&raquo;</span>
				</a>
		</c:if>

		</ul>
    </div><br><br>
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
			location="${pageContext.request.contextPath}/updateprostateservlet?articleId="+articleId+"&id="+2;
		}
	}
	
	
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


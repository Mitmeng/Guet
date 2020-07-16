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
    
    <title>My JSP 'seconddetail.jsp' starting page</title>
    
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
     <table class="topic border" style="width:100%; border-bottom-color: currentColor; border-bottom-width: medium; border-bottom-style: none; margin-top:10px;" cellSpacing="0" cellPadding="0">
			<tr>
				<th colSpan="5">
					<span>&nbsp;&nbsp;共有<b style="color: rgb(255, 102, 0);">${secondhand.totalreply }</b>人留言
					</span>主题：${secondhand.title }
				</th>
			</tr>
	</table>
	<table class="bbslist border" style="width:100%; table-layout: fixed; word-break: break-all;" cellSpacing="0" cellPadding="0">
			<tr>
				<td style="background: rgb(250, 253, 255); border-bottom-color: rgb(228, 231, 236); border-bottom-width: 1px; border-bottom-style: solid;" class="infoleft leftcolor" vAlign="middle">
					<span class="username">
						<div>
							<span style="width: 105px; filter: glow(color='#A6BA98',strength='2');">
								<font color="#61b713" face="Verdana"><b><a href="javascript:void(0);">发布者:${secondhand.createperson }</a></b></font>
							</span>
						</div>
					</span>
				</td>
				<td class="usermenu" colspan="1">
					<em>
						<c:if test="${secondhand.buyorsale==1 }"><span style="color: rgb(255, 102, 0);">出售</span></c:if>
						<c:if test="${secondhand.buyorsale==0 }"><span style="color: rgb(255, 102, 0);">购买</span></c:if>
					</em>
				</td>
			</tr>
			<tr>
				<td class="infoleft leftcolor" vAlign="top" rowSpan="3"><br>
					<span>类型：${typename }</span>
					<%-- <span>类型:${alltypelist[secondlist.producttype] }</span> --%>
					<span>状态：<b class="green"> 
						<c:if test="${secondhand.state==0&&secondhand.buyorsale==1 }">未售出</c:if> 
						<c:if test="${secondhand.state==1&&secondhand.buyorsale==1 }">已售出</c:if>
						<c:if test="${secondhand.state==0&&secondhand.buyorsale==0 }">未购买</c:if> 
						<c:if test="${secondhand.state==1&&secondhand.buyorsale==0 }">已购买</c:if>
					</b></span>
					<span >发布时间:<br></span>
					<span style="font-size:15px">${secondhand.createtime }</span>
				</td>
				<td style="line-height: 120%;" class="inforight" vAlign="top">
					<b style="line-height: 15px; font-size: 12px;"></b>&nbsp;&nbsp;
					<span style="line-height: 20px;" class="font10">
						Post By：${secondhand.stuid }
					</span>
					<br/>
					<table cellSpacing="0" cellPadding="0" style="table-layout: fixed;" >
						<tr>
						    <td style="width: 300px;"><div style="width: 100%;overflow: auto;"><div style="width: 300px;height: 250px;">
						    <img alt="#" src="${secondhand.img }" onload="javascript:DrawImage(this,300,250)"  onclick="this.style.zoom='2'" onclick="javascript:window.open(this.src);" style="cursor:pointer;"/>
						   </div></div></td>
							<td>
								<div style="text-indent: 24px; overflow: hidden; font-size: 12pt; word-break: break-all; word-wrap: break-word;" id="textstyle_1">
									${secondhand.content }
				
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
					<a id="replys" title="强烈支持此楼观点，顶！" href="javascript:void(0)" onclick="document.getElementById('reply').scrollIntoView();" >我要留言</a>&nbsp;
					<span style="padding: 5px;"><span style="display: inline;" class="m_li_top"> 
					<a href="javascript:" onclick="del(${secondhand.id},${secondhand.id},1)">删除</a>
					&nbsp;|&nbsp; 
					<a href="javascript:void(0)" onclick="document.getElementById('top').scrollIntoView();"><img style="padding-bottom: 10px;" alt="回到顶部" src="img/p_up.gif"></a>
					</span></span>
				</td>
			</tr>
	</table>
    <!--作者：offline
	时间：2017-05-15
	描述：回复帖子的内容，回复-->
	<c:forEach items="${replylist }" var="reply" varStatus="status">
		<table class="bbslist border" style="width:100%; table-layout: fixed; word-break: break-all;" cellSpacing="0" cellPadding="0">
			<tr>
				<td style="background: rgb(250, 253, 255); border-bottom-color: rgb(228, 231, 236); border-bottom-width: 1px; border-bottom-style: solid;" class="infoleft leftcolo" vAlign="middle">
					<span class="username">
						<div>
							<span style="width: 105px; filter: glow(color='#A6BA98',strength='2');">
								<font color="#61b713" face="Verdana"><b><a href="javascript:void(0);">留言者:${reply.createperson }</a></b></font>
							</span>
						</div>
					</span>
				</td>
			</tr>
			<tr>
				<td class="infoleft leftcolor" vAlign="top" rowSpan="3"><br>
					<span >发布时间:<br></span>
					<span style="font-size:15px">${reply.createtime }</span>
				</td>
				<td style="line-height: 120%;" class="inforig" vAlign="top">
					<b style="line-height: 15px; font-size: 12px;"></b>&nbsp;&nbsp;
					<span style="line-height: 20px;" class="font10">
						Post By：${reply.stuid }
					</span>
					<br/>
					<table cellSpacing="0" cellPadding="0" style="table-layout: fixed;" >
						<tr>
							<td>
								<div style="text-indent: 24px; overflow: hidden; font-size: 12pt; word-break: break-all; word-wrap: break-word;" id="textstyle_1">
									${reply.content }
				
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
					<span style="padding: 5px;"><span style="display: inline;" class="m_li_top"> 
					<a href="javascript:" onclick="del(${reply.id},${secondhand.id },2)">删除</a>
					&nbsp;|&nbsp; 
					<a href="javascript:void(0)" onclick="document.getElementById('top').scrollIntoView();"><img style="padding-bottom: 10px;" alt="回到顶部" src="img/p_up.gif"></a>
					</span></span>
				</td>
			</tr>
	</table>
	</c:forEach>
	<!-- 回复 -->
	<div id="replyForm" style=" position:absolute;display:none;border:1px solid #bfbfbf;">
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
	<form action="${pageContext.request.contextPath }/addproductreplyservlet" name="form1" method="post" class="definewidth m20" onsubmit="return check()" >
		<input type="hidden" name="AritcleId" value="${secondhand.id}"/>
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
					<input style="margin: 3px 3px 3px 0px;" class="input0" value="OK!发表回复" type="submit"  />
					<span id="body_chk"></span> 
				</td>
			</tr>
			</tbody>
		</table>
	</form>
	</div>
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

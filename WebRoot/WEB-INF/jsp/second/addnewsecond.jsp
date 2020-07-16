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
    
    <title>My JSP 'addnewsecond.jsp' starting page</title>
    
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-responsive.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/css/bootstrap.min.css" type="text/css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<!-- 引入表单校验jquery插件 -->
	<script src="${pageContext.request.contextPath}/js/jquery.validate.min.js" type="text/javascript"></script>
	<!-- 引入自定义css文件 style.css -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/css/style.css" type="text/css" />
	
	<meta name="keywords" content="" />
	<link rel="SHORTCUT ICON" href="favicon.ico" />
	<link rel="stylesheet" type="text/css" href="css/default.css" />
	<script src="js/kindeditor/kindeditor-min.js"	type="text/javascript"></script>
	<script src="js/kindeditor/lang/zh_CN.js"	type="text/javascript"></script>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js" type="text/javascript"></script>



  <style>
	  input::-webkit-input-placeholder {
         /* placeholder颜色  */
         color: #aab2bd;
         /* placeholder字体大小  */
         font-size: 12px;
         /* placeholder位置  */
         text-align: center;
     }
     .error{
      color:red;
     }
     label{
     	font-size: 20px;
     }
     .col-sm-7{
     	width:65%
     }
	</style>
  </head>
  
  <body>
  	 <jsp:include page="/header.jsp"></jsp:include>
     <img id="top" alt="图片" src="img/second.jpg" width="100%"><br>
     <div>&nbsp;&nbsp;</div>
     <div class="col" style="width: 70%;background:#FFFFD0; padding: 20px 20px 20px 20px;border: 3px solid #ccc;">
		<form id="myform" class="form-horizontal" action="${pageContext.request.contextPath }/addsecondhandservlet" 
		method="post" enctype="multipart/form-data" style="margin-top: 5px;">
		<table class="tablebox border" cellSpacing="0" cellPadding="0" style="width:50%;border:1px solid red;">
		   <div class="form-group">
				<label for="username" class="col-sm-2 control-label">标题</label>
				<div class="col-sm-7">
					<input type="text" class="form-control" id="title" name="title"placeholder="请输入标题">
				</div>
			</div>
			<div class="form-group opt">
				<label for="inlineRadio1" class="col-sm-2 control-label">类型</label>
				<div class="col-sm-7">
					<label class="radio-inline"> 
						<input  type="radio" name="buyorsale" id="sale" value="1"  >出售
					</label> 
					<label class="radio-inline"> 
						<input type="radio" name="buyorsale" id="buy" value="0">购买
					</label>
				</div>
			</div>
			<div class="form-group">
				<label for="username" class="col-sm-2 control-label">价格</label>
				<div class="col-sm-7">
					<input type="text" class="form-control" id="price" name="price"placeholder="请输入单价">
				</div>
			</div>
		    <div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">图片</label>
				<div class="col-sm-7">
					<input type="file" name="upload" />
				</div>
			</div>
			<div class="form-group">
				<label for="phone" class="col-sm-2 control-label">分类</label>
				<div class="col-sm-7">
					<select name="producttype">
					<c:forEach items="${typelist }" var="type">
					 <option value="${type.id }">${type.typename }</option>
					</c:forEach>
					</select>
				</div>
			</div> 
			<div class="form-group">
				<label for="date" class="col-sm-2 control-label">内容</label>
				<div class="col-sm-7">
					<textarea name="content" id="content" style="width: 100%; height: 200px;
					 visibility: hidden;"></textarea>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="submit" class="btn btn-primary" value="确认添加" />
					&nbsp;&nbsp;<input type="button" class="btn btn-success" name="backid" id="backid" value="返回"/>
				</div>
			</div> 
		</table>
		</form>
     </div> 
  <!---------------end 底部友情链接部分------------------->
  <jsp:include page="/footer.jsp"></jsp:include>
  </body>
</html>

<script type="text/javascript" language="JavaScript">

	//返回按钮事件
	$('#backid').click(function(){
			location = "${pageContext.request.contextPath}/secondlistservlet";
	});
	
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

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
    
    <title>My JSP 'regist.jsp' starting page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-responsive.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/css/bootstrap.min.css" type="text/css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<!-- 引入表单校验jquery插件 -->
	<script src="${pageContext.request.contextPath}/js/jquery.validate.min.js" type="text/javascript"></script>
	<!-- 引入自定义css文件 style.css -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/css/style.css" type="text/css" />
	
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
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
	</style>

  </head>
  
  <body>
    <!--表单部分-->
	<div class="container"style="width: 100%;height: 100%;">
		<div class="row" style="padding-top: 50px;margin:0 auto;">
		<div class="col-md-2" style="margin:0 auto;"></div>
			<div class="col"style="width: 55%; background:#9CC3D9; padding: 20px 10px 20px 20px;border: 3px solid #ccc;margin:0 auto;">
			<font>添加新类型</font>
				<form id="myform" class="form-horizontal" action="${pageContext.request.contextPath }/admin/addtypeservlet" method="post" style="margin-top: 5px;">
					<!-- <div class="form-group">
						<label for="stuid" class="col-sm-2 control-label">ID</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="typeid" name="typeid" />
						</div>
					</div> -->
					<div class="form-group">
						<label for="username" class="col-sm-2 control-label">类型名称</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="typename" name="typename" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="submit" class="btn btn-primary" value="确认添加" />
							&nbsp;&nbsp;<input type="button" class="btn btn-success" name="backid" id="backid" value="返回"/>
						</div>
					</div>
					<input type="hidden" class="form-control" id="addreess" name="id" value="2"/>
				</form>
			</div><br />	
		</div>
	</div>
  </body>
</html>

<script type="text/javascript">
	
	//返回按钮事件
	$('#backid').click(function(){
			location = "${pageContext.request.contextPath}/admin/secondtypeservlet";
	});
	
	$(function(){
	   $("#myform").validate({
	      rules:{
	       "typeid":{
	         "required":true
	       },
	       "typename":{
	          "required":true
	        }
	      },
	      messages:{
	        "typeid":{
	          "required":"ID不能为空"
	        },
	        "typename":{
	          "required":"类型名不能为空"
	        }
	      }
	   
	   });
	});
	
	</script>

	

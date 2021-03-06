<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head></head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8">
    <title>My JSP 'regist.jsp' starting page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-responsive.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/css/bootstrap.min.css" type="text/css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<!-- 引入表单校验jquery插件 -->
	<script src="${pageContext.request.contextPath}/js/jquery.validate.min.js" type="text/javascript"></script>
	<!-- 引入自定义css文件 style.css -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/css/style.css" type="text/css" />
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
	</style>
  </head>
  
  <body>
    <jsp:include page="/clubheader.jsp"></jsp:include>
    <!--表单部分-->
	<div class="container"style="width: 100%;height: 90%; background: url('img/regist.png');">
		<div class="row" style="padding-top: 140px;">
		<div class="col-md-2" style="margin:0 auto;"></div>
			<div class="col" style="width: 35%; background:#339BB9; padding: 20px 20px 20px 20px;border: 3px solid #ccc;">
				<font>注册&nbsp;&nbsp;CLUB REGISTER</font><br><br>
				<form id="myform" class="form-horizontal" action="${pageContext.request.contextPath }/clubregisterservlet" method="post" style="margin-top: 5px;">
					<div class="form-group">
						<label for="stuid" class="col-sm-2 control-label">账号</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="stuid" name="clubid"
								placeholder="请输入账号">
						</div>
					</div>
					<div class="form-group">
						<label for="username" class="col-sm-2 control-label">社团名称</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="username" name="clubname"
								placeholder="请输入社团名称">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="password" name="password"
								placeholder="请输入密码">
						</div>
					</div>
					<!-- <div class="form-group">
						<label for="confirmpwd" class="col-sm-2 control-label">确认密码</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="confirmpwd" name="repassword"
								placeholder="请输入确认密码">
						</div>
					</div> -->
					<br /><br /><br />
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="submit" class="btn btn-primary" value="注册" />
							&nbsp;&nbsp;<input type="button" class="btn btn-success" name="backid" id="backid" value="返回"/>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
  </body>
</html>
<script type="text/javascript">
	//返回按钮事件
	$('#backid').click(function(){
			location = "${pageContext.request.contextPath}/listclubarticle";
	});
	
	$(function(){
	   $("#myform").validate({
	      rules:{
	       "stuid":{
	         "required":true
	       },
	       "username":{
	          "required":true
	        },
	        "password":{
	          "required":true,
	          "rangelength":[6,12]
	        }        
	      },
	      messages:{
	        "stuid":{
	          "required":"账号不能为空"
	        },
	        "username":{
	          "required":"社团名称不能为空"
	        },
	        "password":{
	          "required":"密码不能为空",
	          "rangelength":"密码长度6-12位"
	        }
	      }
	   
	   });
	});
	
	</script>
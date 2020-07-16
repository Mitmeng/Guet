<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    <jsp:include page="/header.jsp"></jsp:include>
    <!--表单部分-->
	<div class="container"style="width: 100%;height: 100%; background: url('img/regist.png');">
		<div class="row" style="padding-top: 50px;margin:0 auto;">
		<div class="col-md-2" style="margin:0 auto;"></div>
			<div class="col"style="width: 55%; background:#9CC3D9; padding: 20px 10px 20px 20px;border: 3px solid #ccc;margin:0 auto;">
				<font size=5>注册&nbsp;&nbsp;USER REGISTER</font><br><br>
				<form id="myform" class="form-horizontal" action="${pageContext.request.contextPath }/registerservlet" method="post" style="margin-top: 5px;">
					<div class="form-group">
						<label for="stuid" class="col-sm-2 control-label">账号</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="stuid" name="stuid"
								placeholder="请输入账号">
						</div>
					</div>
					<div class="form-group">
						<label for="username" class="col-sm-2 control-label">用户名</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="username" name="username"
								placeholder="请输入用户名">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="password" name="password"
								placeholder="请输入密码">
						</div>
					</div>
					<div class="form-group opt">
						<label for="inlineRadio1" class="col-sm-2 control-label">性别</label>
						<div class="col-sm-6">
							<label class="radio-inline"> 
								<input  type="radio" name="gender" id="sex1" value="1"  >男
							</label> 
							<label class="radio-inline"> 
								<input type="radio" name="gender" id="sex2" value="0">女
							</label>
							<label class="error" for="gender" style="display:none ">您没有第三种选择</label>
						</div>
					</div>
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">Email</label>
						<div class="col-sm-6">
							<input type="email" class="form-control" id="inputEmail3" name="email"
								placeholder="Email">
						</div>
					</div>
					<div class="form-group">
						<label for="phone" class="col-sm-2 control-label">联系电话</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="phone" name="phone"
								placeholder="请输入联系电话">
						</div>
					</div>
					<div class="form-group">
						<label for="date" class="col-sm-2 control-label">出生日期</label>
						<div class="col-sm-6">
							<input type="date" class="form-control" name="birthday" placeholder="xxxx/xx/xx">
						</div>
					</div>
					<div class="form-group">
						<label for="address" class="col-sm-2 control-label">地址</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="addreess" name="address"
								placeholder="请输入地址">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="submit" class="btn btn-primary" value="确认添加" />
							&nbsp;&nbsp;<input type="button" class="btn btn-success" name="backid" id="backid" value="返回"/>
						</div>
					</div>
				</form>
			</div><br>
		</div>
	</div>
  </body>
</html>

<script type="text/javascript">

	//返回按钮事件
	$('#backid').click(function(){
			location = "${pageContext.request.contextPath}/wellcome";
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
	        },
	        "gender":{
	           "required":true
	        },
	         "email":{
	          "required":true,
	          "email":true
	        },
	         "phone":{
	         "required":true
	       },
	       "birthday":{
	         "required":true,
	         "dateISO":true
	       },
	       "address":{
	         "required":true
	       }
	      },
	      messages:{
	        "stuid":{
	          "required":"账号不能为空"
	        },
	        "username":{
	          "required":"用户名不能为空"
	        },
	        "password":{
	          "required":"密码不能为空",
	          "rangelength":"密码长度6-12位"
	        },
	        "email":{
	          "required":"邮箱不能为空",
	          "email":"邮箱格式不正确"
	        },
	        "phone":{
	         "required":"联系电话不能为空"
	       },
	        "birthday":{
	         "required":"出生日期不能为空",
	         "dateISO":"输入格式不正确"
	       },
	       "address":{
	         "required":"地址不能为空"
	       }
	      }
	   
	   });
	});
	
	</script>

	

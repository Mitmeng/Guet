<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我要发帖</title>
    	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
	    <link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.min.css" />
	    <link rel="stylesheet" type="text/css" href="css/style.css" />
	    <script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/kindeditor/kindeditor-min.js"></script>
		<script type="text/javascript" src="js/kindeditor/lang/zh_CN.js"></script>

  </head>
  
  <body>
     <div cellSpacing="0" cellPadding="0" style="width: 1292px;height:600px;padding-top: 10px;border:double; border-color:#BEE9F0;">
     	<form action="" name="form1" method="post" class="definewidth m20" onsubmit="return check()" >
			<table class="table table-bordered table-hover definewidth m10">
		        <tr>
		        	<td width="10%" class="tableleft">主题</td>
		            <td>
		            	<input type="text" id="title" name="title"/>
		            </td>
		        </tr>		
		        <tr>
		            <td width="10%" class="tableleft">内容</td>
		            <td>
		            	<textarea name="content" id="content" rows="20" style="width:100%;"></textarea>
		            </td>
		        </tr>
		        <tr>
		            <td class="tableleft"></td>
		            <td>
		            	<input type="submit" class="btn btn-primary" value="保存" onClick="javascript:doSubmit(1)"/>
		            	<input type="submit" class="btn btn-primary" value="发布" onClick="javascript:doSubmit(2)"/>
		                &nbsp;&nbsp;<input type="button" class="btn btn-success" name="backid" id="backid" value="返回"/>
		            	&nbsp;&nbsp;<font color="red"></font>
		            </td>
		        </tr>
			</table>
		</form>
     </div>
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
						'link' ],
			afterCreate : function() {
				this.sync();
			},
			afterBlur : function() {
				this.sync();
			}
			});
		});
				
		//返回按钮事件
		$('#backid').click(function(){
				location = "${pageContext.request.contextPath}/addbbsarticle";
		});
		
		function check(){
			var titlt = $("#title").val();
			var content = $("#content").val();
			if(titlt==''){
				alert("主题不能为空！");
				return false;
			}
			if(content==''){
				alert("内容不能为空！");
				return false;
			}
			return true;
		}
		function doSubmit(i)
		{
			 switch (i)
			    {
			      case 1:
			       form1.action="${pageContext.request.contextPath }/addnewbbsdraftservlet";//(此处自己改)
			       break;
			      case 2:
			       form1.action="${pageContext.request.contextPath }/addnewbbsArticleservlet";//(此处自己改)
			    } 
		}
</script>

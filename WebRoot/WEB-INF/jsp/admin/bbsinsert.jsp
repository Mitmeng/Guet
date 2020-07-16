<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
    	<title>帖子管理-添加</title>
    	<meta charset="UTF-8">
     	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-responsive.min.css" />
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
	    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
			<script type="text/javascript" src="${pageContext.request.contextPath}/js/kindeditor/kindeditor-min.js"></script>
			<script type="text/javascript" src="${pageContext.request.contextPath}/js/kindeditor/lang/zh_CN.js"></script>
	</head>
	<body>
	    <form action="${pageContext.request.contextPath }/admin/abbssaveArticleservlet" method="post" class="definewidth m20" onsubmit="return check()" >
			<table class="table table-bordered table-hover definewidth m10">
		        <tr>
		        	<td width="10%" class="tableleft">标题</td>
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
		            	<input type="submit" class="btn btn-primary" value="保存" />
		                &nbsp;&nbsp;<input type="button" class="btn btn-success" name="backid" id="backid" value="返回"/>
		            	&nbsp;&nbsp;<font color="red"></font>
		            </td>
		        </tr>
			</table>
		</form>
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
				location = "${pageContext.request.contextPath}/admin/bbslistservlet";
		});
		
		function check(){
			var titlt = $("#title").val();
			var content = $("#content").val();
			if(titlt==''){
				alert("标题不能为空！");
				return false;
			}
			if(content==''){
				alert("内容不能为空！");
				return false;
			}
			return true;
		}
</script>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
	    <title>供求列表</title>
	    <meta charset="UTF-8">
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-responsive.min.css" />
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
	    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>  
	</head>
	<body>
		<form class="form-inline definewidth m20" 
			action="" 
			method="get">
			标题：<input name="title" class="abc input-default" value="${title }"></input>&nbsp;&nbsp;
			<button type="submit" class="btn btn-primary ">查询</button>&nbsp;&nbsp; 
		    <%-- <a><button type="button" class="btn btn-primary" onclick="window.location.href='${pageContext.request.contextPath}/bbsinsert'">添加</button></a>&nbsp;&nbsp;  --%>
		    <font color="red"></font>
		</form>
		<table class="table table-bordered table-hover definewidth m10">
		    <thead>
			    <tr>
			        <th>留言的父ID</th>
			        <th>账号</th>
			        <th>留言者</th>
			        <th>内容</th>
			        <th>留言时间</th>
			        <th colspan="2" style="text-align:center;">操作</th>
			    </tr>
		    </thead>
		    <c:forEach items="${pageBean.list }" var="article">
				<tr>
					<td>${article.proid}</td>
					<td>${article.stuid }</td>
					<td>${article.createperson }</td>
					<td>${article.content }</td>
					<td>${article.createtime }</td>
					<td>
						<a href="${pageContext.request.contextPath }/admin/abbsmodifyArticleservlet?articleId=${article.id}">修改</a>                
					</td>
					<td>
						<a href="javascript:" onclick="del(${article.id})">删除</a>                
					</td>
				</tr>
			</c:forEach>       
		</table>
		<!-- 分页 -->
		<div style="width: 380px; margin: 0 auto; margin-top: 50px;">
			<ul class="pagination" style="text-align: center; margin-top: 10px;">

			<!-- 上一页 -->
			<c:if test="${pageBean.currentPage==1 }">
					<a href="javascript:void(0);" aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
					</a>
			</c:if>
			<c:if test="${pageBean.currentPage!=1 }">
					<a href="${pageContext.request.contextPath}/admin/secondnoteservlet?currentPage=${pageBean.currentPage-1 }" aria-label="Previous">
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
					<a href="${pageContext.request.contextPath}/admin/secondnoteservlet?currentPage=${page }">&nbsp;&nbsp;${page }&nbsp;&nbsp;</a>
				</c:if>
			</c:forEach>
	
	
			<!-- 下一页 -->
			<c:if test="${pageBean.currentPage==pageBean.totalPage }">
					<a href="javascript:void(0);" aria-label="Next"> 
						<span aria-hidden="true">&raquo;</span>
					</a>
				
			</c:if>
			<c:if test="${pageBean.currentPage!=pageBean.totalPage }">
					<a href="${pageContext.request.contextPath}/admin/secondnoteservlet?currentPage=${pageBean.currentPage+1 }" aria-label="Next"> 
						<span aria-hidden="true">&raquo;</span>
					</a>
			</c:if>
	
			</ul>
	    </div> 
	</body>
</html>
<script type="text/javascript">
function del(articleId){
		if(confirm("确定要删除吗？")){
		location="${pageContext.request.contextPath}/admin/secondnotedelservlet?articleId="+articleId;
	}
}
</script>
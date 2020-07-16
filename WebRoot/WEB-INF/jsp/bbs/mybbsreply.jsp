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
    
    <title>所有公告</title>
    
	<link rel="stylesheet" type="text/css" href="css/default.css" />
	<link rel="stylesheet" type="text/css" href="css/common.css" />
	<link href="/favicon.ico" type="image/x-icon" rel="shortcut icon"/> 
	<link rel="stylesheet" href="css/style.css" type="text/css"/>
	<link href="css/default.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/jquery.min.js"></script>

  </head>
  
  <body>
    <div cellSpacing="0" cellPadding="0" style="width: 1292px;height:600px;padding-top: 10px;border:double; border-color:#BEE9F0;">
    	<div id="low-right1">
	    	<div id="list_inner1"> 
	    		<table class="mainbox tableborder" cellSpacing=0 cellPadding=0 style="width:1160px;">
			    <tr>
			    	<th style="text-align:center">状态</th>
					<th style="text-align:center">回复主题</th>
					<th style="text-align:center">时间</th>
					<th style="text-align:center;">操作</th>
			    </tr>
			    <c:forEach items="${pageBean.list }" var="bbarticle">
			    	<tr class=trout onmouseover="this.className='tron'" onmouseout="this.className='trout'">
			    	<td class=list1>
						<img border=0 src="img/article.jpg">
					</td>
					<td class=list2>
						<span>${bbarticle.title }</span>
					</td>
					<td class=list3>
						<a href="javascript:void(0);">${bbarticle.createtime }</a><br>
					</td>
					<td class=list6>
						<a href="javascript:" onclick="del(${bbarticle.id})">删除</a>                
					</td>
				</tr>
			    </c:forEach>
	    	</table>
    	</div>
    </div>
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
				<a href="${pageContext.request.contextPath}/draftbbsservlet?currentPage=${pageBean.currentPage-1 }&id=3" aria-label="Previous">
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
				<a href="${pageContext.request.contextPath}/draftbbsservlet?currentPage=${page }&id=3">&nbsp;&nbsp;${page }&nbsp;&nbsp;</a>
			</c:if>
		</c:forEach>


		<!-- 下一页 -->
		<c:if test="${pageBean.currentPage==pageBean.totalPage }">
				<a href="javascript:void(0);" aria-label="Next"> 
					<span aria-hidden="true">&raquo;</span>
				</a>
			
		</c:if>
		<c:if test="${pageBean.currentPage!=pageBean.totalPage }">
				<a href="${pageContext.request.contextPath}/draftbbsservlet?currentPage=${pageBean.currentPage+1 }&id=3" aria-label="Next"> 
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
		location="${pageContext.request.contextPath}/delebbsarticleservlet?articleId="+articleId+"&id="+3;
	}
}
</script>
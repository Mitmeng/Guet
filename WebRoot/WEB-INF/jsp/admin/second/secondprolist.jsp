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
			        <th>标题</th>
			        <th>图片</th>
			        <th>价格</th>
			        <th>内容</th>
			        <th>作者</th>
			        <th>发布时间</th>
			        <th>留言数</th>
			        <th>类型</th>
			        <th>分类</th>
			        <th>状态</th>
			        <th colspan="2" style="text-align:center;">操作</th>
			    </tr>
		    </thead>
		    <c:forEach items="${pageBean.list }" var="article">
				<tr>
					<td>${article.title }</td>
					<td><img alt="#图片" src="${secondlist.img }" onload="javascript:DrawImage(this,100,70)" style="cursor:pointer;"/></td>
					<td>￥${article.price }</td>
					<td>${article.content }</td>
					<td>${article.createperson }</td>
					<td>${article.createtime }</td>
					<td>${article.totalreply }</td>
					<td>
						<c:if test="${article.buyorsale==1 }">出售</c:if>
						<c:if test="${article.buyorsale==0 }">购买</c:if>
					</td>
					<td>
						<c:forEach items="${alltypelist }" var="typelist">
							<c:if test="${typelist.id==article.producttype }"><span>类型：${typelist.typename }</span></c:if>
						</c:forEach>
					</td>
					<td>
						<c:if test="${article.state==0&&article.buyorsale==1 }">未售出</c:if> 
						<c:if test="${article.state==1&&article.buyorsale==1 }">已售出</c:if>
						<c:if test="${article.state==0&&article.buyorsale==0 }">未购买</c:if> 
						<c:if test="${article.state==1&&article.buyorsale==0 }">已购买</c:if>
					</td>
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
					<a href="${pageContext.request.contextPath}/admin/secondproductservlet?currentPage=${pageBean.currentPage-1 }" aria-label="Previous">
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
					<a href="${pageContext.request.contextPath}/admin/secondproductservlet?currentPage=${page }">&nbsp;&nbsp;${page }&nbsp;&nbsp;</a>
				</c:if>
			</c:forEach>
	
	
			<!-- 下一页 -->
			<c:if test="${pageBean.currentPage==pageBean.totalPage }">
					<a href="javascript:void(0);" aria-label="Next"> 
						<span aria-hidden="true">&raquo;</span>
					</a>
				
			</c:if>
			<c:if test="${pageBean.currentPage!=pageBean.totalPage }">
					<a href="${pageContext.request.contextPath}/admin/secondproductservlet?currentPage=${pageBean.currentPage+1 }" aria-label="Next"> 
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
		location="${pageContext.request.contextPath}/admin/secondprodelservlet?articleId="+articleId;
	}
}


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
</script>
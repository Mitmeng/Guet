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
    
    <title>论坛</title>
    
	<link rel="stylesheet" type="text/css" href="css/default.css" />
	<link rel="stylesheet" type="text/css" href="css/common.css" />
	<link href="/favicon.ico" type="image/x-icon" rel="shortcut icon"/> 
	<link rel="stylesheet" href="css/style.css" type="text/css"/>
	<link href="css/default.css" rel="stylesheet" type="text/css" />
	
    <link type="text/css" rel="Stylesheet" href="styles/index.css" />
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="Scripts/index.js"></script>

  </head>
  
  <style>
	#menu{
		border: 1px solid hidden;
		width: 100%;
		height: 65px;
		background-color: #000000;
	}
	#low-left{
		float: right;
		table-layout: fixed;
		word-break: break-all;
		padding-left: 8px;
	}
	#low-right1{
		table-layout: fixed;
		word-break: break-all;
		float: right;
	}
	#ul{
		padding-top: 20px;
		padding-left: 20px;
	}
	#ul li{
		display: inline;
		color: white;
		font-size: 18px;
	}
	a{
		text-decoration: none;
	}
</style>
  
  <body>
    <jsp:include page="/header.jsp"></jsp:include>
    <div>
		<div style="float: left;">
			<img src="img/logo.png" />
		</div>
		<form>
			<div class="notice"style="padding-top: 47px;padding-right: 25px;">
				<input style="background-color:#C0C0C0;" type="text" name="keyword" size="35" placeholder="请输入关键字" value="${title }"/>&nbsp;&nbsp;&nbsp;
				<button type="submit" class="btn btn-primary ">搜索</button>&nbsp;&nbsp;
			</div>
		</form>
	</div>
    <div id="father">
    	<table style="width:100%;" cellSpacing="0" cellPadding="0">
			<tr>
				<td style="text-align:left; padding-bottom:5px;">
					<a href="mybbs" target="_self"><img style="padding-left:20px;" src="img/post.gif" /></a>
				</td>				
			</tr>
		</table>
		<div id="low">
			<div id="low-left">
    			<div class="content_left"> 
		            <div class="global_module news">
		                <h4 style="font-size: 17px;">最热帖子</h4>
		                <div class="scrollNews">
		                    <ul>
		                    	<c:forEach items="${articlelist }" var="bbsarticle">
		                    		<li><img src="img/hot.jpg"><a href="${pageContext.request.contextPath}/bbsdetailarticleservlet?articleid=${bbsarticle.id }"  class="tooltip" title="长江大学协会会员信息表">${bbsarticle.title }</a></li>
		                    	</c:forEach>
		                    </ul>
		                </div>		                
		            </div>
	            </div>
	        </div>
            <div id="low-right1">
	    	<div id="list_inner1"> 
	    		<table class="mainbox tableborder" cellSpacing=0 cellPadding=0 style="width:1160px;">
			    <tr>
					<th style="text-align:center">
						<a title=批量管理帖子 href="javascript:void(0);">状态</a>
					</th>
					<th style="text-align:center">主题</th>
					<th style="text-align:center">
						<a title=按发表时间排序 href="javascript:void(0);" >作者</a>
					</th>
					<th style="text-align: center">
						<a title=按回复人数排序 href="javascript:void(0);">回复数量</a>
					</th>
					<th style="text-align: center">
						<a title=按回复时间排序 href="javascript:void(0);">最后更新</a>
					</th>
			    </tr>
			    <c:forEach items="${pageBean.list }" var="bbsArticle">
			    	<tr class=trout onmouseover="this.className='tron'" onmouseout="this.className='trout'">
					<td class=list1>
						<a href="${pageContext.request.contextPath}/bbsdetailarticleservlet?articleid=${bbsArticle.id }">
							<img border=0 title="在新窗口打开帖子" src="img/article.jpg">
						</a>
					</td>
					<td class=list2>
						<span>${bbsArticle.title }</span>
					</td>
					<td class=list3>
						<a href="javascript:void(0);">${bbsArticle.createperson }</a><br>
					</td>
					<td class=list5>
					    <span>${bbsArticle.totalreply }</span>
					</td>
					<td class="list4 font10">
						<span>${bbsArticle.lastupdatetime }</span>
					</td>
				</tr>
			    </c:forEach>
		    </table>
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
					<a href="${pageContext.request.contextPath}/bbslistservlet?currentPage=${pageBean.currentPage-1 }" aria-label="Previous">
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
						<a href="${pageContext.request.contextPath}/bbslistservlet?currentPage=${page }">&nbsp;&nbsp;${page }&nbsp;&nbsp;</a>
					</c:if>
				</c:forEach>
		
		
				<!-- 下一页 -->
				<c:if test="${pageBean.currentPage==pageBean.totalPage }">
					<a href="javascript:void(0);" aria-label="Next"> 
						<span aria-hidden="true">&raquo;</span>
					</a>
					
				</c:if>
				<c:if test="${pageBean.currentPage!=pageBean.totalPage }">
					<a href="${pageContext.request.contextPath}/bbslistservlet?currentPage=${pageBean.currentPage+1 }" aria-label="Next"> 
						<span aria-hidden="true">&raquo;</span>
					</a>
				</c:if>
		
				</ul>
		    </div><br><br>
		</div>
    </div><br><br>
    <jsp:include page="/footer.jsp"></jsp:include>
  </body>
</html>

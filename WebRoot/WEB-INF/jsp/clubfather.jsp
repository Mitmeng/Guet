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
    
    <title>桂林电子科技大学社团文化</title>
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
    <jsp:include page="/clubheader.jsp"></jsp:include>
	<div id="father">
		<div class="nav" >
			<div style="float:left;">
				<a href="myclubc" target="_self"><img src="img/anniu.gif" /></a>&nbsp;
			</div>
			<form>
				<div class="notice">
				<input style="background: #B3B3B3;" type="text" name="title" placeholder="请输入关键字" value="${title }" size="35" />&nbsp;&nbsp;&nbsp;
				<button type="submit" class="btn btn-primary ">搜索</button>&nbsp;&nbsp;
			</div>
			</form>
		</div><br/>
		<div id="low"> 
	    	<div id="low-left">
    			<div class="content_left"> 
		            <div class="global_module news">
		                <h4>社团概况</h4>
		                <div class="scrollNews">
		                    <ul>
		                    	<c:forEach items="${clublist }" var="club">
		                    		<li><img src="img/laba1.jpg"><a href="Introduceservle?clubname=${club.clubname }&clubintroid=2" class="tooltip" title="长江大学协会会员信息表">${club.clubname }</a></li>
		                    	</c:forEach>
		                    </ul>
		                </div>		                
		            </div>
		            <div class="global_module procatalog">
		                <h4>最热公告</h4>
		                <ul class="m-treeview">
		                	<c:forEach items="${articlelist }" var="clubarticle">
	                    		<li><img src="img/hot.jpg"><a href="${pageContext.request.contextPath}/clubdetailarticleservlet?articleid=${clubarticle.id }" class="tooltip" title="长江大学协会会员信息表">${clubarticle.clubtitle }</a></li>
	                    	</c:forEach>
		                </ul>   
		            </div>
	            </div>
       		</div>	
		    <div id="low-right1">
		    	<div id="list_inner1"> 
		    		<table class="mainbox tableborder" cellSpacing=0 cellPadding=0 style="width:1160px;">
				    <tr>
						<th style="text-align:center">
							<a title=批量管理帖子 href="">状态</a>
						</th>
						<th style="text-align:center">标题</th>
						<th style="text-align:center">
							<a title=按发表时间排序 href="" >社团</a>
						</th>
						<th style="text-align: center">
							<a title=按回复人数排序 href="">发布时间</a>
						</th>
						<th style="text-align: center">
							<a title=按回复时间排序 href="">点击量</a>
						</th>
				    </tr>
				    <c:forEach items="${pageBean.list }" var="clubarticle">
				    	<tr class=trout onmouseover="this.className='tron'" onmouseout="this.className='trout'">
						<td class=list1>
							<a href="${pageContext.request.contextPath}/clubdetailarticleservlet?articleid=${clubarticle.id }">
								<img border=0 title="在新窗口打开帖子" src="img/laba.jpg">
							</a>
						</td>
						<td class=list2>
							<span>${clubarticle.clubtitle }</span>
						</td>
						<td class=list3>
							<a href="javascript:void(0);">${clubarticle.clubname }</a><br>
						</td>
						<td class="list4 font10">
							<span>${clubarticle.releasedate }</span>
						</td>
						<td class=list5>
						    <c:if test="${clubarticle.totalread==null }">
						    	<span>0</span>
						    </c:if>
						    <c:if test="${clubarticle.totalread!=null }">
						    	<span>${clubarticle.totalread }</span>
						    </c:if>
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
							<a href="${pageContext.request.contextPath}/listclubarticle?currentPage=${pageBean.currentPage-1 }" aria-label="Previous">
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
							<a href="${pageContext.request.contextPath}/listclubarticle?currentPage=${page }">&nbsp;&nbsp;${page }&nbsp;&nbsp;</a>
						</c:if>
					</c:forEach>
			
			
					<!-- 下一页 -->
					<c:if test="${pageBean.currentPage==pageBean.totalPage }">
							<a href="javascript:void(0);" aria-label="Next"> 
								<span aria-hidden="true">&raquo;</span>
							</a>
						
					</c:if>
					<c:if test="${pageBean.currentPage!=pageBean.totalPage }">
							<a href="${pageContext.request.contextPath}/listclubarticle?currentPage=${pageBean.currentPage+1 }" aria-label="Next"> 
								<span aria-hidden="true">&raquo;</span>
							</a>
					</c:if>
			
					</ul>
			    </div>        
        </div>
        <!--footer.jsp,尾部页面-->
   </div> 
</div>
</body>
</html>
<script type="text/javascript">
    var w,h,className;
	function getSrceenWH(){
		w = $(window).width();
		h = $(window).height();
		$('#dialogBg').width(w).height(h);
	}
	
	window.onresize = function(){  
		getSrceenWH();
	}  
	$(window).resize();  
	
	$(function(){
		getSrceenWH();
		
		//显示弹框
		$('.box #login').click(function(){
			className = $(this).attr('class');
			$('#dialogBg').fadeIn(300);
			$('#dialog').removeAttr('class').addClass('animated '+className+'').fadeIn();
			$('#userName').focus();
		});
		
		//关闭弹窗
		$('.closeDialogBtn').click(function(){
			$('#dialogBg').fadeOut(300,function(){
				$('#dialog').addClass('bounceOutUp').fadeOut();
			});
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

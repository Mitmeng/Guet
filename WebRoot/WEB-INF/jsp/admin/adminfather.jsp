<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
	<head>
	    <title>桂林电子科技大学生活服务后台管理系统</title>
	    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	    <link href="assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
	    <link href="assets/css/bui-min.css" rel="stylesheet" type="text/css" />
	    <link href="assets/css/main-min.css" rel="stylesheet" type="text/css" />
	    <script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/jquery-migrate-1.2.1.js"></script>
		<script type="text/javascript" src="assets/js/bui-min.js"></script>
		<script type="text/javascript" src="assets/js/common/main-min.js"></script>
		<script type="text/javascript" src="assets/js/config-min.js"></script>
		<script>
		    BUI.use('common/main', function(){
		    	/** 定义导航菜单配置信息数组 */
		        var config = [{id:'1', // 唯一标识符id
		        			   homePage:'11', // 当前显示的菜单id
		        		       menu:[{text:'公告管理', // 主菜单
		        				      items:[ 
		        				            {id:'11',text:'所有公告',href:'admin/clublistservlet'},
											{id:'12',text:'待审核公告',href:'admin/clubwaitlistservlet'}
		        			  ]},{text:'市场管理',
		        				      items:[ 
		        				            {id:'21',text:'供求管理',href:'admin/secondproductservlet'},
											{id:'22',text:'分类管理',href:'admin/secondtypeservlet'},
											{id:'23',text:'留言管理',href:'admin/secondnoteservlet'}
		        			  ]},{text:'图书管理', 
		        				      items:[ 
		        				            {id:'31',text:'信息管理',href:'后台-用户管理.html'},
											{id:'32',text:'分类管理',href:'admin/booktypeservlet'},
											{id:'33',text:'留言管理',href:'后台-角色管理.html'}
		        			  ]},{text:'失物管理', // 主菜单
		        				      items:[ 
		        				            {id:'41',text:'分类管理',href:'后台-用户管理.html'},
											{id:'42',text:'失物管理',href:'后台-角色管理.html'}
		        			  ]},{text:'论坛管理', // 主菜单
		        				      items:[ 
		        				            {id:'51',text:'帖子管理',href:'admin/bbslistservlet'}
		        			  ]},{text:'用户管理', // 主菜单
		        				      items:[ 
		        				            {id:'61',text:'所有用户',href:'admin/userlistservlet'},
		        				            {id:'62',text:'所有社团',href:'admin/cluberlistservlet'}
		        			  ]}]}];
		    	
		    	/** 显示导航菜单 */
		        new PageUtil.MainPage({
		            modulesConfig : config
		        });
		    });
		    
		    $(function(){
		    	/** 用户退出 */
		    	$(".dl-log-quit").click(function(){
		    		if(confirm("您确定要退出系统吗？")){
		    			window.location = "logoutservlet";
		    		}
		    	});
		    });
		</script>
	</head>
	<body>
		<!-- 头部分 -->
		<div class="header">
		    <div class="dl-title">
		       <img src="assets/img/top.png"/>
		    </div>
		
		    <div class="dl-log">欢迎您，<span class="dl-log-user">${loginAdmin }</span>
		    	<a href="javascript:;" title="退出系统" class="dl-log-quit">[退出]</a>
		    </div>
		</div>
		
		<!-- 内容部分 -->
		<div class="content">
		    <div class="dl-main-nav">
		        <div class="dl-inform">
		        	<div class="dl-inform-title">
		        		<s class="dl-inform-icon dl-up"></s>
		        	</div>
		        </div>
		        <!-- 上面导航栏 -->
		        <ul id="J_Nav" class="nav-list ks-clear">
		            <li class="nav-item dl-selected"><div class="nav-item-inner nav-home">管理菜单</div></li>	
		        </ul>
		    </div>
		    <!-- 下面菜单导航 -->
		    <ul id="J_NavContent" class="dl-tab-conten">
				
		    </ul>
		</div>
	</body>
</html>
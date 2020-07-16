package com.meng.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meng.beans.ClubArticle;
import com.meng.dao.ClubArticleDao;
import com.meng.domain.PageBean;
import com.meng.service.ClubArticleListService;

public class ClubListServlet extends HttpServlet {

	ClubArticleDao clubArticleDao = new ClubArticleDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//获取搜索内容
		String title=request.getParameter("title");
		
		String currentPageStr =  request.getParameter("currentPage");
		if(currentPageStr==null) currentPageStr="1";
		int currentPage = Integer.parseInt(currentPageStr);
		int currentCount = 4;
		
		ClubArticleListService service = new ClubArticleListService();
		PageBean pageBean = null;
		
		try {
			pageBean = service.findClubArticleList(0,title,currentPage,currentCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//把数据存储到Request域对象中
		request.setAttribute("pageBean",pageBean);
		request.setAttribute("title", title);
		//跳转到文章管理页面
		request.getRequestDispatcher("/WEB-INF/jsp/admin/clublist.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//处理中文乱码问题
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}

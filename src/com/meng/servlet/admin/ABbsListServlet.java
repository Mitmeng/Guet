package com.meng.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meng.beans.Bbs;
import com.meng.dao.BbsArticleDao;
import com.meng.domain.PageBean;
import com.meng.service.BbsArticleListService;

public class ABbsListServlet extends HttpServlet {

	BbsArticleDao bbsArticleDao = new BbsArticleDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//获取搜索内容
		String title=request.getParameter("title");
		//获取当前页数
		String currentPageStr =  request.getParameter("currentPage");
		if(currentPageStr==null) currentPageStr="1";
		int currentPage = Integer.parseInt(currentPageStr);
		int currentCount = 4;
		
		BbsArticleListService service = new BbsArticleListService();
		PageBean pageBean = null;
		try {
			pageBean = service.findBbsArticleList(null,title,currentPage, currentCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//搜索关键字
		request.setAttribute("title",title);
		request.setAttribute("pageBean",pageBean);
		request.getRequestDispatcher("/WEB-INF/jsp/admin/bbslist.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}

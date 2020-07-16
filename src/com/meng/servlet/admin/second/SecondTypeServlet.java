package com.meng.servlet.admin.second;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meng.dao.SecondTypeDao;
import com.meng.domain.PageBean;
import com.meng.service.SecondTypeListService;

public class SecondTypeServlet extends HttpServlet {

	SecondTypeDao secondTypeDao = new SecondTypeDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//获取搜索内容
		String title=request.getParameter("title");
		//获取当前页数
		String currentPageStr =  request.getParameter("currentPage");
		if(currentPageStr==null) currentPageStr="1";
		int currentPage = Integer.parseInt(currentPageStr);
		int currentCount = 15;
		
		SecondTypeListService service = new SecondTypeListService();
		PageBean pageBean = null;
		
		try {
			pageBean = service.findTypelist(currentPage, currentCount, title);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		request.setAttribute("title",title);
		request.setAttribute("pageBean",pageBean);
		
		request.getRequestDispatcher("/WEB-INF/jsp/admin/second/secondtype.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}

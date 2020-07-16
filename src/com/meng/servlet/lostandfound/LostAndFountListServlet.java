package com.meng.servlet.lostandfound;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meng.dao.LostAndFoundDao;
import com.meng.domain.PageBean;
import com.meng.service.LostAndFoundListService;

public class LostAndFountListServlet extends HttpServlet {

	LostAndFoundDao lostAndFoundDao = new LostAndFoundDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//处理中文乱码问题
		response.setContentType("text/html;charset=utf-8");
		//获取搜索内容
		String title=request.getParameter("keyword");
		//String id = request.getParameter("id");
		//获取当前页数
		String currentPageStr =  request.getParameter("currentPage");
		if(currentPageStr==null) currentPageStr="1";
		int currentPage = Integer.parseInt(currentPageStr);
		int currentCount = 2;
		
		LostAndFoundListService service = new LostAndFoundListService();
		PageBean pageBean = null;
		
		try {
			pageBean = service.findLostandFoundArticleList(title,currentPage, currentCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("title",title);
		request.setAttribute("pageBean",pageBean);
		request.getRequestDispatcher("/WEB-INF/jsp/lostandfound/lostandfoundlist.jsp").forward(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}

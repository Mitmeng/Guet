package com.meng.servlet.admin.second;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meng.dao.SecondNoteDao;
import com.meng.domain.PageBean;
import com.meng.service.SecondNoteListService;

public class SecondNoteServlet extends HttpServlet {

	SecondNoteDao secondNoteDao = new SecondNoteDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//处理中文乱码问题
		response.setContentType("text/html;charset=utf-8");
		//获取搜索内容
		String title=request.getParameter("title");
		String currentPageStr =  request.getParameter("currentPage");
		if(currentPageStr==null) currentPageStr="1";
		int currentPage = Integer.parseInt(currentPageStr);
		int currentCount = 15;
		
		SecondNoteListService service = new SecondNoteListService();
		PageBean pageBean = null;
		try {
			pageBean = service.findSecondproreply(title,currentPage,currentCount);
		} catch (SQLException e) {
			// TODO: handle exception
		}
		request.setAttribute("title", title);
		request.setAttribute("pageBean",pageBean);
		request.getRequestDispatcher("/WEB-INF/jsp/admin/second/secondnotelist.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}

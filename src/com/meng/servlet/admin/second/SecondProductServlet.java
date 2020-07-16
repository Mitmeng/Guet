package com.meng.servlet.admin.second;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meng.beans.SecondType;
import com.meng.dao.SecondHandDao;
import com.meng.dao.SecondTypeDao;
import com.meng.domain.PageBean;
import com.meng.service.SecondHandListService;

public class SecondProductServlet extends HttpServlet {

	SecondHandDao secondHandDao = new SecondHandDao();
	SecondTypeDao secondTypeDao = new SecondTypeDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//处理中文乱码问题
		response.setContentType("text/html;charset=utf-8");
		//获取搜索内容
		String title=request.getParameter("title");
		String currentPageStr =  request.getParameter("currentPage");
		if(currentPageStr==null) currentPageStr="1";
		int currentPage = Integer.parseInt(currentPageStr);
		int currentCount = 15;
		
		SecondHandListService service = new SecondHandListService();
		PageBean pageBean = null;
		try {
			pageBean = service.findSecondArticleList(1,null,title,currentPage, currentCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("title", title);
		List<SecondType> list = secondTypeDao.findall();
		request.setAttribute("alltypelist", list);
		request.setAttribute("pageBean",pageBean);
		request.getRequestDispatcher("/WEB-INF/jsp/admin/second/secondprolist.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}

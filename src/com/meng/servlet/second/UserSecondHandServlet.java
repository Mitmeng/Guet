package com.meng.servlet.second;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meng.beans.SecondType;
import com.meng.dao.SecondHandDao;
import com.meng.dao.SecondTypeDao;
import com.meng.domain.PageBean;
import com.meng.service.SecondHandListService;

public class UserSecondHandServlet extends HttpServlet {

	SecondHandDao secondHandDao = new SecondHandDao();
	SecondTypeDao secondTypeDao = new SecondTypeDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idstr = request.getParameter("id");
		int id = Integer.parseInt(idstr);
		System.out.println(".......");
		System.out.println(id);
		String currentPageStr =  request.getParameter("currentPage");
		if(currentPageStr==null) currentPageStr="1";
		int currentPage = Integer.parseInt(currentPageStr);
		int currentCount = 3;
		
		SecondHandListService service = new SecondHandListService();
		PageBean pageBean = null;
		HttpSession session = request.getSession();
		String stuid = (String) session.getAttribute("loginStuid");
		//secondHandDao.findbystuid(stuid);
		try {
			pageBean = service.findSecondArticleList(id,stuid,null,currentPage, currentCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<SecondType> list = secondTypeDao.findall();
		request.setAttribute("alltypelist", list);
		request.setAttribute("pageBean",pageBean);
		request.getRequestDispatcher("/WEB-INF/jsp/second/privatesecond.jsp").forward(request,response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}

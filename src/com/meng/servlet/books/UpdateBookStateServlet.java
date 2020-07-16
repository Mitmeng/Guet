package com.meng.servlet.books;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meng.dao.BookCrossingDao;

public class UpdateBookStateServlet extends HttpServlet {

	BookCrossingDao bookCrossingDao = new BookCrossingDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String articleId = request.getParameter("articleId");
		HttpSession session = request.getSession();
		String stuidstr = (String) session.getAttribute("loginStuid");
		int stuid = Integer.parseInt(stuidstr);
		boolean issuccess = bookCrossingDao.updatestatebyid(stuid,articleId);
		if(issuccess){
			response.sendRedirect(request.getContextPath()+"/booklistservlet?id=0");
		}
		else{
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<SCRIPT>alert('您没有权限！');history.back();</SCRIPT>");
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}

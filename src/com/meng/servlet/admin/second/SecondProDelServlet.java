package com.meng.servlet.admin.second;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meng.dao.SecondHandDao;

public class SecondProDelServlet extends HttpServlet {

	SecondHandDao secondHandDao = new SecondHandDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String proid = request.getParameter("articleId");
		secondHandDao.Delesecondbyid(proid);
		response.sendRedirect(request.getContextPath()+"/admin/secondproductservlet");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}

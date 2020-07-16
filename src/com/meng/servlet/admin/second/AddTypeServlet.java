package com.meng.servlet.admin.second;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meng.beans.SecondType;
import com.meng.dao.SecondTypeDao;

public class AddTypeServlet extends HttpServlet {

	SecondTypeDao secondTypeDao = new SecondTypeDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		//String id = request.getParameter("typeid");
		String name = request.getParameter("typename");
		boolean issuccess = secondTypeDao.addnewtype(name);
		if(issuccess){
			response.sendRedirect(request.getContextPath()+"/admin/secondtypeservlet");
		}else{
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<SCRIPT>alert('好像出了点问题。。。');history.back();</SCRIPT>");
		}
	}

}

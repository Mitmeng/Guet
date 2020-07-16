package com.meng.servlet.admin.second;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meng.beans.SecondType;
import com.meng.dao.SecondTypeDao;

public class TypeModifyServlet extends HttpServlet {

	SecondTypeDao secondTypeDao = new SecondTypeDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String articleId = request.getParameter("articleId");
		int id = Integer.parseInt(articleId);
		SecondType secondType = secondTypeDao.findbyid(id);
		request.setAttribute("secondType", secondType);
		request.getRequestDispatcher("/WEB-INF/jsp/admin/second/updatetype.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}

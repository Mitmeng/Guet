package com.meng.servlet.admin.second;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meng.dao.SecondNoteDao;

public class SecondNoteDelServlet extends HttpServlet {

	SecondNoteDao secondNoteDao = new SecondNoteDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String articleId = request.getParameter("articleId");
		secondNoteDao.Delereplybbyid(articleId);
		response.sendRedirect(request.getContextPath()+"/admin/secondnoteservlet");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}

package com.meng.servlet.bbs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meng.dao.BbsArticleDao;

public class DeleBbsArticleServlet extends HttpServlet {

	BbsArticleDao bbsArticleDao = new BbsArticleDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String artId = request.getParameter("articleId");
		String idd = request.getParameter("id");
		bbsArticleDao.Delearticlebyid(artId);
		response.sendRedirect(request.getContextPath()+"/draftbbsservlet?id="+idd);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}

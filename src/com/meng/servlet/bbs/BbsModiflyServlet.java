package com.meng.servlet.bbs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meng.dao.BbsArticleDao;

public class BbsModiflyServlet extends HttpServlet {

	BbsArticleDao bbsArticleDao = new BbsArticleDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String articleIdstr = request.getParameter("articleId");
		int articleId = Integer.parseInt(articleIdstr);
		bbsArticleDao.updatemodifly(articleId);
		PrintWriter writer=response.getWriter();
		writer.write("<script>window.open('bbslistservlet','_top');</script>");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}

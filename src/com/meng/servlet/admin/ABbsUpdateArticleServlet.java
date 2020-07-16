package com.meng.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meng.dao.BbsArticleDao;

public class ABbsUpdateArticleServlet extends HttpServlet {

	BbsArticleDao bbsArticleDao = new BbsArticleDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//处理中文乱码问题
		request.setCharacterEncoding("utf-8");
		String articleid = request.getParameter("articleId");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		bbsArticleDao.updateArticle(articleid, title, content);
		response.sendRedirect(request.getContextPath()+"/admin/bbslistservlet");
	}

}

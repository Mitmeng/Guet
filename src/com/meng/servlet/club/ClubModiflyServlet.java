package com.meng.servlet.club;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meng.dao.ClubArticleDao;

public class ClubModiflyServlet extends HttpServlet {

	ClubArticleDao clubArticleDao = new ClubArticleDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String articleIdstr = request.getParameter("articleId");
		int articleId = Integer.parseInt(articleIdstr);
		clubArticleDao.updatemodifly(articleId);
		String clubintroid="1";
		response.sendRedirect(request.getContextPath()+"/Introduceservle?clubintroid="+clubintroid);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}

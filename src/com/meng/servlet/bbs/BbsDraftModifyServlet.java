package com.meng.servlet.bbs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meng.beans.Bbs;
import com.meng.beans.ClubArticle;
import com.meng.dao.BbsArticleDao;

public class BbsDraftModifyServlet extends HttpServlet {

	BbsArticleDao bbsArticleDao = new BbsArticleDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idstr = request.getParameter("articleId");
		Bbs cArticle = bbsArticleDao.findArticlebyid(idstr);
		request.setAttribute("formodiflyarticle",cArticle);
		request.getRequestDispatcher("/WEB-INF/jsp/bbs/bbsmodifly.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}

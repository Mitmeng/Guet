package com.meng.servlet.club;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meng.beans.ClubArticle;
import com.meng.dao.ClubArticleDao;

public class ClubDraftModifyServlet extends HttpServlet {

	ClubArticleDao clubArticleDao = new ClubArticleDao();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idd = request.getParameter("id");
		String idstr = request.getParameter("articleId");
		int id = Integer.parseInt(idstr);
		ClubArticle cArticle = clubArticleDao.findArticlebyid(id);
		request.setAttribute("formodiflyarticle",cArticle);
		request.setAttribute("idd", idd);
		request.getRequestDispatcher("/WEB-INF/jsp/club/clubmodifly.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}

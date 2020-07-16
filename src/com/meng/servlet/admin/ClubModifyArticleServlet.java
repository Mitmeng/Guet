package com.meng.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meng.beans.Bbs;
import com.meng.beans.ClubArticle;
import com.meng.dao.ClubArticleDao;

public class ClubModifyArticleServlet extends HttpServlet {

	ClubArticleDao cArticleDao = new ClubArticleDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String articleId = request.getParameter("articleId");
		int id = Integer.parseInt(articleId);
		ClubArticle cArticle = cArticleDao.findArticlebyid(id);
		request.setAttribute("cArticle", cArticle);
		request.getRequestDispatcher("/WEB-INF/jsp/admin/clubarticlemodifly.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}

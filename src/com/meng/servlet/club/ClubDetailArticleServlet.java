package com.meng.servlet.club;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meng.beans.ClubArticle;
import com.meng.dao.ClubArticleDao;

public class ClubDetailArticleServlet extends HttpServlet {

	ClubArticleDao clubArticleDao = new ClubArticleDao();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//获取jsp传来的id
		String articleid = request.getParameter("articleid");
		int id = Integer.parseInt(articleid);
		System.out.println(articleid);
		ClubArticle cArticle = clubArticleDao.findArticlebyid(id);
		request.setAttribute("cArticle",cArticle);
		request.getRequestDispatcher("/WEB-INF/jsp/club/clubdetailarticle.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}

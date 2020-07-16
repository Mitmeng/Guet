package com.meng.servlet.club;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meng.dao.ClubArticleDao;

public class DelArticleServlet extends HttpServlet {

	ClubArticleDao clubArticleDao = new ClubArticleDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String articleIdstr = request.getParameter("articleId");
		int ctticleId = Integer.parseInt(articleIdstr);
		clubArticleDao.DeleteArticle(ctticleId);
		/*HttpSession session=request.getSession(); 
		String clubname = (String) session.getAttribute("loginClub");
		System.err.println(clubname);*/
		String clubintroid="1";
		/*request.setAttribute("clubintroid",1);
		request.setAttribute("clubname",session.getAttribute("loginClub"));
		request.getRequestDispatcher("Introduceservle").forward(request,response);*/
		response.sendRedirect("/guet/Introduceservle?clubintroid="+clubintroid);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}

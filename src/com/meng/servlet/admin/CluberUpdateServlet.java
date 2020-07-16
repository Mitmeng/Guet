package com.meng.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meng.beans.Club;
import com.meng.dao.ClubDao;

public class CluberUpdateServlet extends HttpServlet {

	ClubDao clubDao = new ClubDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String articleId = request.getParameter("articleId");
		//System.out.println(articleId);
		Club club = clubDao.findClubbyid(articleId);
		//System.out.println(user.getUsername());
		request.setAttribute("club", club);
		request.getRequestDispatcher("/WEB-INF/jsp/admin/nnewclubaddupdate.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}

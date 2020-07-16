package com.meng.servlet.club;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meng.beans.Club;
import com.meng.dao.ClubDao;

public class ClubIntroduceServle extends HttpServlet {

	ClubDao clubDao = new ClubDao();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 String clubintroid = request.getParameter("clubintroid");
		 int introid = Integer.parseInt(clubintroid);
		 if(introid==1){
			 HttpSession session = request.getSession();
			 String clubname = (String) session.getAttribute("loginClub");
			 Club club = clubDao.findclubidbyclubname(clubname);
			 request.setAttribute("club",club);
			 request.getRequestDispatcher("/WEB-INF/jsp/club/rightclubarticle.jsp").forward(request, response);
		 }
		 else if(introid==2){
			 String clubname = request.getParameter("clubname");
			 Club clubb = clubDao.findclubidbyclubname(clubname);
			 request.setAttribute("club",clubb);
			 request.getRequestDispatcher("/WEB-INF/jsp/club/clubintroduce.jsp").forward(request, response);
		 }
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}

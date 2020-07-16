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

public class ClubLoginServlet extends HttpServlet {
	ClubDao clubDao = new ClubDao();

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String clubid=request.getParameter("clubid");
		String password=request.getParameter("password");
		boolean issuccess=clubDao.validataClub(clubid, password);
		HttpSession session=request.getSession();
		if(issuccess){
			Club club=clubDao.findClubname(clubid);
			session.setAttribute("loginClub", club.getClubname());
			session.setAttribute("Clubintroid",1);
			//request.getRequestDispatcher("/WEB-INF/jsp/clubfather.jsp").forward(request, response);
			response.sendRedirect("/guet/listclubarticle");
		}else{
			
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<SCRIPT>alert('用户名或密码不正确！');history.back();</SCRIPT>");
		}
	}

}

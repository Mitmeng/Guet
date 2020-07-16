package com.meng.servlet.club;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meng.dao.ClubDao;

public class ClubRegisterServlet extends HttpServlet {
	ClubDao clubDao = new  ClubDao();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String clubid = request.getParameter("clubid");
		String clubname = request.getParameter("clubname");
		String password = request.getParameter("password");
		//数据库插入操作
		boolean issuccess=clubDao.insertClub1(clubid,clubname,password);
		if(issuccess){
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<script>alert('注册成功！！');history.back();</script>");
			//request.getRequestDispatcher("/WEB-INF/jsp/clubfather.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath()+"/listclubarticle");
		}
		else{
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<SCRIPT>alert('好像出了点问题。。。');history.back();</SCRIPT>");
			//request.getRequestDispatcher("/WEB-INF/jsp/clubregist.jsp").forward(request, response);;
		}
	}

}

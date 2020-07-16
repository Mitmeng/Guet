package com.meng.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meng.dao.ClubDao;

public class AdminRegisterClubServlet extends HttpServlet {

	ClubDao clubDao = new ClubDao();
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String clubid = request.getParameter("clubid");
		String clubname = request.getParameter("clubname");
		String password = request.getParameter("password");
		String idstr = request.getParameter("id");
		int id = Integer.parseInt(idstr);
		//数据库插入操作
		boolean issuccess=clubDao.admininsertClub(id,clubid,clubname,password);
		if(issuccess){
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<script>alert('注册成功！！');history.back();</script>");
			//response.sendRedirect(request.getContextPath()+"/listclubarticle");
			response.sendRedirect(request.getContextPath()+"/admin/cluberlistservlet");
		}
		else{
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<SCRIPT>alert('好像出了点问题。。。');history.back();</SCRIPT>");
			//request.getRequestDispatcher("/WEB-INF/jsp/clubregist.jsp").forward(request, response);;
		}
	}

}

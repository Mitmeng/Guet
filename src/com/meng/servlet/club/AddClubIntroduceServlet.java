package com.meng.servlet.club;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meng.beans.Club;
import com.meng.dao.ClubDao;

public class AddClubIntroduceServlet extends HttpServlet {
	ClubDao clubDao = new ClubDao();

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//处理中文乱码问题
		request.setCharacterEncoding("utf-8");
		//获取表单数据
		//String title = request.getParameter("title");
		String content = request.getParameter("content");
		String createClub =(String)request.getSession().getAttribute("loginClub");
		clubDao.Addintroduce(content,createClub);
		String clubintroid="1";
		response.sendRedirect(request.getContextPath()+"/Introduceservle?clubintroid="+clubintroid);
		//response.sendRedirect(request.getContextPath()+"/rightclubarticle");
	}

}

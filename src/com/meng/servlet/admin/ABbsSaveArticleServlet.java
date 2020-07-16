package com.meng.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meng.dao.BbsArticleDao;

public class ABbsSaveArticleServlet extends HttpServlet {

	BbsArticleDao bbsArticleDao = new BbsArticleDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//处理中文乱码问题
		request.setCharacterEncoding("utf-8");
		String content = request.getParameter("content");
		String title = request.getParameter("title");
		HttpSession session = request.getSession();
		String createperson = (String) session.getAttribute("loginAdmin");
		String stuid = (String) session.getAttribute("loginAdminstu");
		bbsArticleDao.addArticle(stuid, title, content, createperson);
		response.sendRedirect(request.getContextPath()+"/admin/bbslistservlet");
	}

}

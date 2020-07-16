package com.meng.servlet.club;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meng.dao.ClubArticleDao;

public class AddNewArticleServlet extends HttpServlet {

	ClubArticleDao clubArticleDao = new ClubArticleDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//保存到草稿箱的操作
		//处理中文乱码问题
		request.setCharacterEncoding("utf-8");
		//获取表单数据
		String iddstr = request.getParameter("idd");
		int idd = Integer.parseInt(iddstr);
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String articleId = request.getParameter("articleId");
		clubArticleDao.updateArticle(idd,articleId,title, content);
		String clubintroid="1";
		response.sendRedirect(request.getContextPath()+"/Introduceservle?clubintroid="+clubintroid);
	}

}

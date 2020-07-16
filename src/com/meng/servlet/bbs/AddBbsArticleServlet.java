package com.meng.servlet.bbs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meng.dao.BbsArticleDao;

public class AddBbsArticleServlet extends HttpServlet {

	BbsArticleDao bbsArticleDao = new BbsArticleDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//保存到草稿箱的操作
		//处理中文乱码问题
		request.setCharacterEncoding("utf-8");
		//获取表单数据
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String articleId = request.getParameter("articleId");
		bbsArticleDao.updateArticle(articleId,title, content);
		PrintWriter writer=response.getWriter();
		writer.write("<script>window.open('bbslistservlet','_top');</script>");
	}

}

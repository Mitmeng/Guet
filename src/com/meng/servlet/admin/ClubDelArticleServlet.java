package com.meng.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meng.dao.ClubArticleDao;

public class ClubDelArticleServlet extends HttpServlet {

	ClubArticleDao clubArticleDao = new ClubArticleDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//根据id删除帖子记录
		String strid = request.getParameter("id");
		int idd = Integer.parseInt(strid);
		String articleId = request.getParameter("articleId");
		int id = Integer.parseInt(articleId);
		clubArticleDao.DeleteArticle(id);
		if(idd==1){
			response.sendRedirect(request.getContextPath()+"/admin/clubwaitlistservlet");
		}else if(idd==2){
			response.sendRedirect(request.getContextPath()+"/admin/clublistservlet");
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}

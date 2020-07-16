package com.meng.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meng.beans.Bbs;
import com.meng.dao.BbsArticleDao;

public class ABbsModifyArticleServlet extends HttpServlet {

	BbsArticleDao bbsArticleDao = new BbsArticleDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String articleId = request.getParameter("articleId");
		Bbs bbs = bbsArticleDao.findArticlebyid(articleId);
		request.setAttribute("bbs", bbs);
		request.getRequestDispatcher("/WEB-INF/jsp/admin/articlemodifly.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}

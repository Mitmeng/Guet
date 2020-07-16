package com.meng.servlet.bbs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meng.beans.Bbs;
import com.meng.dao.BbsArticleDao;

public class AddBbsReplyArticle extends HttpServlet {

	BbsArticleDao bbsArticleDao = new BbsArticleDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//处理中文乱码问题
		request.setCharacterEncoding("utf-8");
		//为指定id的帖子添加回复
		String AritcleId = request.getParameter("AritcleId");
		String content = request.getParameter("content");
		//System.out.println("**********");
		HttpSession session = request.getSession();
		String stuid = (String) session.getAttribute("loginStuid");
		String createperson = (String) session.getAttribute("loginUser");
		Bbs bbs = bbsArticleDao.findArticlebyid(AritcleId);
		String title = bbs.getTitle();
		bbsArticleDao.Addreplyarticle(stuid,title,content,createperson,AritcleId);
		response.sendRedirect(request.getContextPath()+"/bbsdetailarticleservlet?articleid="+AritcleId);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}

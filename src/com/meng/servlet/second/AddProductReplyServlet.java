package com.meng.servlet.second;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meng.beans.Bbs;
import com.meng.beans.SecondHand;
import com.meng.dao.SecondHandDao;
import com.meng.dao.SecondNoteDao;

public class AddProductReplyServlet extends HttpServlet {

	SecondNoteDao secondNoteDao = new SecondNoteDao();
	SecondHandDao secondHandDao = new SecondHandDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		//处理中文乱码问题
		request.setCharacterEncoding("utf-8");
		//为指定id的帖子添加回复
		String AritcleId = request.getParameter("AritcleId");
		String content = request.getParameter("content");
		//System.out.println("**********");
		HttpSession session = request.getSession();
		String stuid = (String) session.getAttribute("loginStuid");
		String createperson = (String) session.getAttribute("loginUser");
		secondNoteDao.Addreplyarticle(stuid,content,createperson,AritcleId);
		secondHandDao.updatetotalreply(AritcleId);
		response.sendRedirect(request.getContextPath()+"/seconddetailservlet?secondid="+AritcleId+"&id="+1);
	}

}

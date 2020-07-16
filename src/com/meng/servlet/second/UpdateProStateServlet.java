package com.meng.servlet.second;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meng.beans.SecondHand;
import com.meng.dao.SecondHandDao;

public class UpdateProStateServlet extends HttpServlet {

	SecondHandDao secondHandDao = new SecondHandDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String iddstr = request.getParameter("id");
		int idd = Integer.parseInt(iddstr);
		String articleId = request.getParameter("articleId");
		SecondHand secondHand = secondHandDao.findbyid(articleId);
		HttpSession session = request.getSession();
		String stustr = (String) session.getAttribute("loginStuid");
		int stuid = Integer.parseInt(stustr);
		if(stuid!=secondHand.getStuid()){
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<SCRIPT>alert('您没有权限！');history.back();</SCRIPT>");
		}else {
			secondHandDao.updatestatebyid(articleId);
			if(idd==1){
				response.sendRedirect(request.getContextPath()+"/secondlistservlet");
			}else{
				response.sendRedirect(request.getContextPath()+"/usersecondhandservlet?id="+"1");
			}
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}

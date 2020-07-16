package com.meng.servlet.bbs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meng.dao.BbsArticleDao;

public class DelBbsArticleServlet extends HttpServlet {

	BbsArticleDao bbsArticleDao = new BbsArticleDao();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String articleIdstr = request.getParameter("articleId");
		String id = request.getParameter("id");
		int ctticleId = Integer.parseInt(articleIdstr);
		HttpSession session=request.getSession();
		String loginuser = (String) session.getAttribute("loginUser");
		boolean issuccess=bbsArticleDao.validataUser(loginuser,ctticleId);
		if(issuccess){
			if(articleIdstr.equals(id)||articleIdstr==id){
				//删除的为主题帖
				bbsArticleDao.Deletearticlebyid(ctticleId,1,id);
				response.sendRedirect(request.getContextPath()+"/bbslistservlet");
			}else{
				//删除的为回复贴
				bbsArticleDao.Deletearticlebyid(ctticleId,0,id);
				response.sendRedirect(request.getContextPath()+"/bbsdetailarticleservlet?articleid="+id);
			}
		}else{
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<SCRIPT>alert('您没有权限！');history.back();</SCRIPT>");
		}
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}

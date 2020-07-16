package com.meng.servlet.second;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meng.dao.SecondHandDao;
import com.meng.dao.SecondNoteDao;

public class DelSecondReplyServlet extends HttpServlet {

	SecondNoteDao secondNoteDao = new SecondNoteDao();
	SecondHandDao secondHandDao = new SecondHandDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		String replyid = request.getParameter("articleId");
		String parentid = request.getParameter("parentid");
		HttpSession session=request.getSession();
		String loginstuid = (String) session.getAttribute("loginStuid");
		boolean issuccess = secondNoteDao.validateUser(id,loginstuid,replyid);
		if(issuccess){
			if(id=="1"||id.equals("1"))
			{
				secondHandDao.Delesecondbyid(replyid);
				secondNoteDao.Delereplybbyproid(parentid);
				response.sendRedirect(request.getContextPath()+"/secondlistservlet");
			}else{
				secondNoteDao.Delereplybbyid(replyid);
				secondHandDao.updatetotalreplys(parentid);
				response.sendRedirect(request.getContextPath()+"/seconddetailservlet?secondid="+parentid+"&id="+1);
			}
		}else{
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<SCRIPT>alert('您没有权限！');history.back();</SCRIPT>");
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}

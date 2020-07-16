package com.meng.servlet.bbs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meng.dao.BbsArticleDao;
import com.meng.domain.PageBean;
import com.meng.service.BbsArticleListService;

public class DraftBbsServlet extends HttpServlet {

	BbsArticleDao bbsArticleDao = new BbsArticleDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//获取草稿箱的操作
		//获取当前页数
		String currentPageStr =  request.getParameter("currentPage");
		String id = request.getParameter("id");
		
		if(currentPageStr==null) currentPageStr="1";
		int currentPage = Integer.parseInt(currentPageStr);
		int currentCount = 8;
		int selectid = Integer.parseInt(id);
		
		String Stuid =(String)request.getSession().getAttribute("loginStuid");
		BbsArticleListService service = new BbsArticleListService();
		PageBean pageBean = null;
		pageBean = service.findClubDraftArticle(selectid,Stuid,currentPage, currentCount);
		request.setAttribute("pageBean",pageBean);
		System.out.println("************");
		System.out.println(pageBean.getList().size());
		if(selectid==1){
			request.getRequestDispatcher("/WEB-INF/jsp/bbs/mybbsdraft.jsp").forward(request, response);
		}
		else if (selectid==2) {
			request.getRequestDispatcher("/WEB-INF/jsp/bbs/mybbsarticle.jsp").forward(request, response);
		}
		else{
			request.getRequestDispatcher("/WEB-INF/jsp/bbs/mybbsreply.jsp").forward(request, response);
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}

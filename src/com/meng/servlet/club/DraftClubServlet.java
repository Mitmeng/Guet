package com.meng.servlet.club;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meng.beans.Club;
import com.meng.beans.ClubArticle;
import com.meng.dao.ClubArticleDao;
import com.meng.domain.PageBean;
import com.meng.service.ClubArticleListService;

public class DraftClubServlet extends HttpServlet {
	ClubArticleDao articleDao = new ClubArticleDao();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		//获取草稿箱的操作
		//获取当前页数
		String currentPageStr =  request.getParameter("currentPage");
		String id = request.getParameter("id");
		if(currentPageStr==null) currentPageStr="1";
		int currentPage = Integer.parseInt(currentPageStr);
		int currentCount = 8;
		int selectid = Integer.parseInt(id);
		
		String clubname =(String)request.getSession().getAttribute("loginClub");
		ClubArticleListService service = new ClubArticleListService();
		PageBean pageBean = null;
		pageBean = service.findClubDraftArticle(selectid,clubname,currentPage, currentCount);
		request.setAttribute("pageBean",pageBean);
		if(selectid==1){
			request.getRequestDispatcher("/WEB-INF/jsp/club/draftclub.jsp").forward(request, response);
		}
		else if (selectid==2) {
			request.getRequestDispatcher("/WEB-INF/jsp/club/waitaudit.jsp").forward(request, response);
		}
		else if (selectid==3) {
			request.getRequestDispatcher("/WEB-INF/jsp/club/waitpublish.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("/WEB-INF/jsp/club/clubtotalarticle.jsp").forward(request, response);
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}

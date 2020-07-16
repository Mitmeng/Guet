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
import com.meng.dao.ClubDao;
import com.meng.domain.PageBean;
import com.meng.service.ClubArticleListService;

public class ListClubArticleServlet extends HttpServlet {
	ClubArticleDao clubarticleDao = new ClubArticleDao();
	ClubDao clubDao = new ClubDao();
	

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//response.setContentType("text/html;charset=utf-8");
		//获取搜索内容
		String title=request.getParameter("title");
		//获取当前页数
		String currentPageStr =  request.getParameter("currentPage");
		if(currentPageStr==null) currentPageStr="1";
		int currentPage = Integer.parseInt(currentPageStr);
		int currentCount = 3;
		
		ClubArticleListService service = new ClubArticleListService();
		PageBean pageBean = null;
		try {
			pageBean = service.findClubArticleList
					(0,title,currentPage, currentCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		List<ClubArticle> articlelist = clubarticleDao.findTotalread();
		List<Club> clublist = clubDao.findClub();
		//System.out.println(pageBean.getList().size());
		request.setAttribute("title",title);
		request.setAttribute("articlelist",articlelist);
		request.setAttribute("clublist", clublist);
		request.setAttribute("pageBean",pageBean);
		request.getRequestDispatcher
		("/WEB-INF/jsp/clubfather.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}

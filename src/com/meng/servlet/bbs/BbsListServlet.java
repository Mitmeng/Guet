package com.meng.servlet.bbs;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meng.beans.Bbs;
import com.meng.dao.BbsArticleDao;
import com.meng.domain.PageBean;
import com.meng.service.BbsArticleListService;

public class BbsListServlet extends HttpServlet {

	BbsArticleDao bbsArticleDao = new BbsArticleDao();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//处理中文乱码问题
		response.setContentType("text/html;charset=utf-8");
		//获取搜索内容
		String title=request.getParameter("keyword");
		//获取当前页数
		String currentPageStr =  request.getParameter("currentPage");
		if(currentPageStr==null) currentPageStr="1";
		int currentPage = Integer.parseInt(currentPageStr);
		int currentCount = 3;
		
		BbsArticleListService service = new BbsArticleListService();
		PageBean pageBean = null;
		try {
			pageBean = service.findBbsArticleList(null,title,currentPage, currentCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//所有帖子中回复数最多的前10个
		List<Bbs> articlelist = bbsArticleDao.findTotalread();
		//List<Club> clublist = clubDao.findClub();
		//System.out.println(pageBean.getList().size());
		//搜索关键字
		request.setAttribute("title",title);
		//热贴
		request.setAttribute("articlelist",articlelist);
		//request.setAttribute("clublist", clublist);
		request.setAttribute("pageBean",pageBean);
		request.getRequestDispatcher("/WEB-INF/jsp/bbs/bbsfather.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}

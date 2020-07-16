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
import com.meng.beans.User;
import com.meng.dao.BbsArticleDao;
import com.meng.dao.UserDao;
import com.meng.domain.PageBean;
import com.meng.service.BbsArticleListService;

public class BbsDetailArticleServlet extends HttpServlet {

	BbsArticleDao bbsArticleDao = new BbsArticleDao();
	UserDao userDao = new UserDao();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//获取搜索内容,现在在这里没起什么作用
		String title=null;
		//获取jsp传来的id
		String articleid = request.getParameter("articleid");
		//int id = Integer.parseInt(articleid);
		Bbs bArticle = bbsArticleDao.findArticlebyid(articleid);
		int stuid =bArticle.getStuid();
		String stuidstr = Integer.toString(stuid);
		//System.out.println(stuidstr);
		int authortotal = bbsArticleDao.findTotalArticle(stuid);
		User user = userDao.findUsername(stuidstr);
		//System.out.println(user.getUsername());
		//分页
		String currentPageStr =  request.getParameter("currentPage");
		if(currentPageStr==null) currentPageStr="1";
		int currentPage = Integer.parseInt(currentPageStr);
		int currentCount = 4;
		
		BbsArticleListService service = new BbsArticleListService();
		PageBean pageBean = null;
		try {
			pageBean = service.findBbsArticleList(articleid,title,currentPage,currentCount);
			System.out.println(pageBean.getTotalCount());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//传帖子记录
		request.setAttribute("bArticle",bArticle);
		//传楼主的信息
		request.setAttribute("user", user);
		//传作者的所有帖子数
		request.setAttribute("totalnumber", authortotal);
		//传检索关键字
		request.setAttribute("title",title);
		//传分页
		request.setAttribute("pageBean",pageBean);
		request.getRequestDispatcher("/WEB-INF/jsp/bbs/bbsdetailarticle.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}

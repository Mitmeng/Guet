package com.meng.servlet.books;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meng.beans.BooksType;
import com.meng.dao.BookCrossingDao;
import com.meng.dao.BooksTypeDao;
import com.meng.domain.PageBean;
import com.meng.service.BookCrossingListService;

public class BookListServlet extends HttpServlet {

	BookCrossingDao bookCrossingDao = new BookCrossingDao();
	BooksTypeDao booksTypeDao = new BooksTypeDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//处理中文乱码问题
		response.setContentType("text/html;charset=utf-8");
		//获取搜索内容
		String title=request.getParameter("keyword");
		String id = request.getParameter("id");
		//System.out.println(id);
		//获取当前页数
		String currentPageStr =  request.getParameter("currentPage");
		if(currentPageStr==null) currentPageStr="1";
		int currentPage = Integer.parseInt(currentPageStr);
		int currentCount = 2;
		
		BookCrossingListService service = new BookCrossingListService();
		PageBean pageBean = null;
		
		try {
			pageBean = service.findBookCrossingArticleList(id,title,currentPage, currentCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<BooksType> booksType = (List<BooksType>) booksTypeDao.findall();
		request.setAttribute("alltypelist", booksType);
		request.setAttribute("pageBean",pageBean);
		request.getRequestDispatcher("/WEB-INF/jsp/book/bookcrossinglist.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}

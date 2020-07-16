package com.meng.servlet.books;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meng.beans.BooksType;
import com.meng.dao.BooksTypeDao;

public class BookTypeForMybookServlet extends HttpServlet {

	BooksTypeDao booksTypeDao = new BooksTypeDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<BooksType> list = booksTypeDao.findall();
		request.setAttribute("Alltypelist", list);
		request.getRequestDispatcher("/WEB-INF/jsp/book/mybook.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}

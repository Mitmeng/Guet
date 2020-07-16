package com.meng.servlet.second;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meng.beans.SecondType;
import com.meng.dao.SecondTypeDao;

public class ForAddNewSecondHandServlet extends HttpServlet {

	SecondTypeDao secondTypeDao = new SecondTypeDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<SecondType> secondType = (List<SecondType>) secondTypeDao.findall();
		request.setAttribute("typelist", secondType);
		request.getRequestDispatcher("/WEB-INF/jsp/second/addnewsecond.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}

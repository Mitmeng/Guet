package com.meng.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meng.beans.User;
import com.meng.dao.UserDao;

public class UserUpdateServlet extends HttpServlet {

	UserDao userDao = new UserDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String articleId = request.getParameter("articleId");
		//System.out.println(articleId);
		User user = userDao.findUser(articleId);
		//System.out.println(user.getUsername());
		request.setAttribute("user", user);
		request.getRequestDispatcher("/WEB-INF/jsp/admin/nnewuseraddupdate.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}

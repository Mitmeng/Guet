package com.meng.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meng.dao.UserDao;

public class AdminRegisterServlet extends HttpServlet {

	UserDao userDao = new UserDao();
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String stuid = request.getParameter("stuid");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String birthday = request.getParameter("birthday");
		String address = request.getParameter("address");
		String ismanager = request.getParameter("ismanager");
		String idstr = request.getParameter("id");
		int id = Integer.parseInt(idstr);
		//数据库插入操作
		boolean issuccess=userDao.insertUseradmin(id,stuid,username,password,gender,email,phone,birthday,address,ismanager);
		if(issuccess){
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<SCRIPT>alert('注册成功！！');history.back();</SCRIPT>");
			//request.getRequestDispatcher("/WEB-INF/jsp/wellcome.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath()+"/admin/userlistservlet");
		}
		else{
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<SCRIPT>alert('好像出了点问题。。。');history.back();</SCRIPT>");
			//request.getRequestDispatcher("/WEB-INF/jsp/regist.jsp").forward(request, response);;
		}
	}

}

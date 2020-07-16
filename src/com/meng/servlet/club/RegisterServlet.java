package com.meng.servlet.club;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meng.dao.UserDao;

public class RegisterServlet extends HttpServlet {
	UserDao userDao = new UserDao();

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

	
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
		//数据库插入操作
		boolean issuccess=userDao.insertUser(stuid,username,password,gender,email,phone,birthday,address);
		if(issuccess){
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<SCRIPT>alert('注册成功！！');history.back();</SCRIPT>");
			request.getRequestDispatcher("/WEB-INF/jsp/wellcome.jsp").forward(request, response);
		}
		else{
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<SCRIPT>alert('好像出了点问题。。。请按照正确格式填写好每一项！');history.back();</SCRIPT>");
			//request.getRequestDispatcher("/WEB-INF/jsp/regist.jsp").forward(request, response);;
		}
	}

}

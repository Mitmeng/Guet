package com.meng.servlet.club;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meng.beans.User;
import com.meng.dao.UserDao;

public class LoginServlet extends HttpServlet {
	UserDao userDao=new UserDao();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Stuid=request.getParameter("stuid");
		String Password=request.getParameter("userPass");
		boolean issuccess=userDao.validataUser(Stuid,Password);
		HttpSession session=request.getSession();
		if(issuccess){
			User user=userDao.findUsername(Stuid);
			if(user.getIsmanager()==1){
				session.setAttribute("loginAdmin", user.getUsername());
				session.setAttribute("loginAdminstu", Stuid);
			}
			session.setAttribute("loginUser", user.getUsername());
			session.setAttribute("loginStuid", Stuid);
			response.sendRedirect(request.getContextPath()+"/wellcome");
		}else{
			
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<SCRIPT>alert('用户名或密码不正确！');history.back();</SCRIPT>");
		}
	}

	private void print(String string) {
		// TODO Auto-generated method stub
		
	}

}

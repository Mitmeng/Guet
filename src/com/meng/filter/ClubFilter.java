package com.meng.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ClubFilter implements Filter {

    public ClubFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resq=(HttpServletResponse)response;
		//中文处理
		response.setContentType("text/html;charset=utf-8");
		//获取session对象
		HttpSession session=req.getSession();
		Object o = session.getAttribute("loginClub");
		if(o==null){
			PrintWriter writer=resq.getWriter();
			writer.write("<SCRIPT>alert('请先登录！');history.back();</SCRIPT>");
		}
		else{
			chain.doFilter(req, resq);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

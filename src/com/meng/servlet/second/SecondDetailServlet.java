package com.meng.servlet.second;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meng.beans.SecondHand;
import com.meng.beans.SecondNote;
import com.meng.beans.SecondType;
import com.meng.dao.SecondHandDao;
import com.meng.dao.SecondNoteDao;
import com.meng.dao.SecondTypeDao;

public class SecondDetailServlet extends HttpServlet {

	SecondHandDao secondHandDao = new SecondHandDao();
	SecondTypeDao secondTypeDao = new SecondTypeDao();
	SecondNoteDao secondNoteDao = new SecondNoteDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idstr = request.getParameter("id");
		int id = Integer.parseInt(idstr);
		String secondid = request.getParameter("secondid");
		SecondHand sHand = secondHandDao.findbyid(secondid);
		SecondType sType = secondTypeDao.findbyid(sHand.getProducttype());
		List<SecondNote> list = secondNoteDao.findbyparentid(secondid);
		request.setAttribute("replylist", list);
		request.setAttribute("typename", sType.getTypename());
		request.setAttribute("secondhand", sHand);
		if(id==1){
			request.getRequestDispatcher("/WEB-INF/jsp/second/seconddetail.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/WEB-INF/jsp/second/priseconddetail.jsp").forward(request, response);
		}
	}

}

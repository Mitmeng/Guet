package com.meng.service;

import java.sql.SQLException;
import java.util.List;

import com.meng.beans.User;
import com.meng.dao.UserDao;
import com.meng.domain.PageBean;

public class UserListService {

	public PageBean findUser(int currentPage, int currentCount, String title) throws SQLException {
		
		UserDao clubdao = new UserDao();
		
		//封装一个PageBean 返回web层
		PageBean<User> pageBean = new PageBean<User>();
		//1、封装当前页
		pageBean.setCurrentPage(currentPage);
		//2、封装每页显示的条数
		pageBean.setCurrentCount(currentCount);
		
		int totalCount = 0;
		if(title==null||("".equals(title))){
			//3、封装总条数
			totalCount = clubdao.getCount();
			pageBean.setTotalCount(totalCount);
			
			//4、封装总页数
			int totalPage = (int) Math.ceil(1.0*totalCount/currentCount);
			pageBean.setTotalPage(totalPage);
			
			//5、当前页显示的数据
			// select * from product where cid=? limit ?,?
			// 当前页与起始索引index的关系
			int index = (currentPage-1)*currentCount;
			List<User> list = null;
			list = clubdao.findUser(index,currentCount);
			pageBean.setList(list);
		}else{
			//3、封装总条数
			totalCount = clubdao.getCountlike(title);
			pageBean.setTotalCount(totalCount);
			
			//4、封装总页数
			int totalPage = (int) Math.ceil(1.0*totalCount/currentCount);
			pageBean.setTotalPage(totalPage);
			
			//5、当前页显示的数据
			// select * from product where cid=? limit ?,?
			// 当前页与起始索引index的关系
			int index = (currentPage-1)*currentCount;
			List<User> list = null;
			list = clubdao.findUserlike(title,index,currentCount);
			pageBean.setList(list);
		}
		
		return pageBean;
	}
}

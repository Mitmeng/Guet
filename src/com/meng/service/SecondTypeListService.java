package com.meng.service;

import java.sql.SQLException;
import java.util.List;

import com.meng.beans.SecondType;
import com.meng.dao.SecondTypeDao;
import com.meng.domain.PageBean;

public class SecondTypeListService {

	public PageBean findTypelist(int currentPage, int currentCount, String title) throws SQLException {
		SecondTypeDao secondTypeDao = new SecondTypeDao();
		//封装一个PageBean 返回web层
		PageBean<SecondType> pageBean = new PageBean<SecondType>();
		//1、封装当前页
		pageBean.setCurrentPage(currentPage);
		//2、封装每页显示的条数
		pageBean.setCurrentCount(currentCount);
		
		int totalCount = 0;
		if(title==null||("".equals(title))){
			//3、封装总条数
			totalCount = secondTypeDao.getCount();
			pageBean.setTotalCount(totalCount);
			
			//4、封装总页数
			int totalPage = (int) Math.ceil(1.0*totalCount/currentCount);
			pageBean.setTotalPage(totalPage);
			
			//5、当前页显示的数据
			// select * from product where cid=? limit ?,?
			// 当前页与起始索引index的关系
			int index = (currentPage-1)*currentCount;
			List<SecondType> list = null;
			list = secondTypeDao.findType(index,currentCount);
			pageBean.setList(list);
		}else{
			//3、封装总条数
			totalCount = secondTypeDao.getCountlike(title);
			pageBean.setTotalCount(totalCount);
			
			//4、封装总页数
			int totalPage = (int) Math.ceil(1.0*totalCount/currentCount);
			pageBean.setTotalPage(totalPage);
			
			//5、当前页显示的数据
			// select * from product where cid=? limit ?,?
			// 当前页与起始索引index的关系
			int index = (currentPage-1)*currentCount;
			List<SecondType> list = null;
			list = secondTypeDao.findTypelike(title,index,currentCount);
			pageBean.setList(list);
		}
		
		return pageBean;
	}

}

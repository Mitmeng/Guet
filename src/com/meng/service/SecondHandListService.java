package com.meng.service;

import java.sql.SQLException;
import java.util.List;

import com.meng.beans.SecondHand;
import com.meng.dao.SecondHandDao;
import com.meng.domain.PageBean;

public class SecondHandListService {

	public PageBean findSecondArticleList(int id,String stuid, String title, int currentPage, int currentCount) throws SQLException {
		SecondHandDao secondHandDao = new SecondHandDao();
		//封装一个PageBean 返回web层
		PageBean<SecondHand> pageBean = new PageBean<SecondHand>();
		
		//1、封装当前页
		pageBean.setCurrentPage(currentPage);
		//2、封装每页显示的条数
		pageBean.setCurrentCount(currentCount);
		
		int totalCount = 0;
		if(title==null||("".equals(title))){
			//3、封装总条数
			totalCount = secondHandDao.getCount(id,stuid);
			pageBean.setTotalCount(totalCount);
			
			//4、封装总页数
			int totalPage = (int) Math.ceil(1.0*totalCount/currentCount);
			pageBean.setTotalPage(totalPage);
			
			//5、当前页显示的数据
			// select * from product where cid=? limit ?,?
			// 当前页与起始索引index的关系
			int index = (currentPage-1)*currentCount;
			List<SecondHand> list = null;
			list = secondHandDao.findSecondHand(id,stuid,index,currentCount);
			pageBean.setList(list);
		}else{
			//3、封装总条数
			totalCount = secondHandDao.getCountlike(title);
			pageBean.setTotalCount(totalCount);
			
			//4、封装总页数
			int totalPage = (int) Math.ceil(1.0*totalCount/currentCount);
			pageBean.setTotalPage(totalPage);
			
			//5、当前页显示的数据
			// select * from product where cid=? limit ?,?
			// 当前页与起始索引index的关系
			int index = (currentPage-1)*currentCount;
			List<SecondHand> list = null;
			list = secondHandDao.findSecondHandlike(title,index,currentCount);
			pageBean.setList(list);
		}
		
		return pageBean;
		
	}

}

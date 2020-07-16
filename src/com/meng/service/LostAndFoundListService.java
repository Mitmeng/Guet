package com.meng.service;

import java.sql.SQLException;
import java.util.List;

import com.meng.beans.LostAndFound;
import com.meng.dao.LostAndFoundDao;
import com.meng.domain.PageBean;

public class LostAndFoundListService {

	public PageBean findLostandFoundArticleList( String title, int currentPage, int currentCount) throws SQLException {
		LostAndFoundDao lostAndFoundDao = new LostAndFoundDao();
		
		//封装一个PageBean 返回web层
		PageBean<LostAndFound> pageBean = new PageBean<LostAndFound>();
		
		//1、封装当前页
		pageBean.setCurrentPage(currentPage);
		//2、封装每页显示的条数
		pageBean.setCurrentCount(currentCount);
		
		int totalCount = 0;
		if(title==null||("".equals(title))){
			//3、封装总条数
			totalCount = lostAndFoundDao.getCount();
			pageBean.setTotalCount(totalCount);
			
			//4、封装总页数
			int totalPage = (int) Math.ceil(1.0*totalCount/currentCount);
			pageBean.setTotalPage(totalPage);
			
			//5、当前页显示的数据
			// select * from product where cid=? limit ?,?
			// 当前页与起始索引index的关系
			int index = (currentPage-1)*currentCount;
			List<LostAndFound> list = null;
			list = lostAndFoundDao.findLostandFound(index,currentCount);
			pageBean.setList(list);
		}else{
			//3、封装总条数
			totalCount = lostAndFoundDao.getCountlike(title);
			pageBean.setTotalCount(totalCount);
			
			//4、封装总页数
			int totalPage = (int) Math.ceil(1.0*totalCount/currentCount);
			pageBean.setTotalPage(totalPage);
			
			//5、当前页显示的数据
			// select * from product where cid=? limit ?,?
			// 当前页与起始索引index的关系
			int index = (currentPage-1)*currentCount;
			List<LostAndFound> list = null;
			list = lostAndFoundDao.findLostandFoundlike(title,index,currentCount);
			pageBean.setList(list);
		}
		
		return pageBean;
	}

}

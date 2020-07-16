package com.meng.service;

import java.sql.SQLException;
import java.util.List;

import com.meng.beans.ClubArticle;
import com.meng.dao.ClubArticleDao;
import com.meng.domain.PageBean;

public class ClubArticleListService {
	
	
public PageBean findClubArticleList(int i, String title, int currentPage,
		int currentCount) throws SQLException {
		
		ClubArticleDao clubarticledao = new ClubArticleDao();
		
		//封装一个PageBean 返回web层
		PageBean<ClubArticle> pageBean = new PageBean<ClubArticle>();
		
		//1、封装当前页
		pageBean.setCurrentPage(currentPage);
		//2、封装每页显示的条数
		pageBean.setCurrentCount(currentCount);
		//3、封装总条数
		int totalCount = 0;
		totalCount = clubarticledao.getCount(i,title);
		pageBean.setTotalCount(totalCount);
		//4、封装总页数
		int totalPage = (int) Math.ceil(1.0*totalCount/currentCount);
		pageBean.setTotalPage(totalPage);
		
		//5、当前页显示的数据
		// select * from product where cid=? limit ?,?
		// 当前页与起始索引index的关系
		int index = (currentPage-1)*currentCount;
		List<ClubArticle> list = null;
		if(title==null||("".equals(title)))
		{
			list = clubarticledao.findArticleByPage
					(i,index,currentCount);
		}
		else {
			list = clubarticledao.findArticleByPageLike
					(i,title,index, currentCount);
		}
		pageBean.setList(list);
		
		return pageBean;
	}

public PageBean findClubDraftArticle(int selectid, String clubname, int currentPage, int currentCount) {
	ClubArticleDao clubarticledao = new ClubArticleDao();
	
	//封装一个PageBean 返回web层
	PageBean<ClubArticle> pageBean = new PageBean<ClubArticle>();
	
	//1、封装当前页
	pageBean.setCurrentPage(currentPage);
	//2、封装每页显示的条数
	pageBean.setCurrentCount(currentCount);
	//3、封装总条数
	int totalCount = 0;
	totalCount = clubarticledao.getCountforDraft(selectid,clubname);
	pageBean.setTotalCount(totalCount);
	//4、封装总页数
	int totalPage = (int) Math.ceil(1.0*totalCount/currentCount);
	pageBean.setTotalPage(totalPage);
	
	//5、当前页显示的数据
	// select * from product where cid=? limit ?,?
	// 当前页与起始索引index的关系
	int index = (currentPage-1)*currentCount;
	List<ClubArticle> list = null;
	list = clubarticledao.findArticleByDraft(selectid,clubname,index, currentCount);
	pageBean.setList(list);
	
	return pageBean;
}

}

package com.meng.service;

import java.sql.SQLException;
import java.util.List;

import com.meng.beans.Bbs;
import com.meng.beans.ClubArticle;
import com.meng.dao.BbsArticleDao;
import com.meng.domain.PageBean;

public class BbsArticleListService {

	public PageBean findBbsArticleList(String articleid, String title, int currentPage, int currentCount) throws SQLException {
	
		BbsArticleDao bbsarticledao = new BbsArticleDao();
		
		//封装一个PageBean 返回web层
		PageBean<Bbs> pageBean = new PageBean<Bbs>();
		//1、封装当前页
		pageBean.setCurrentPage(currentPage);
		//2、封装每页显示的条数
		pageBean.setCurrentCount(currentCount);
		//3、封装总条数
		int totalCount = 0;
		totalCount = bbsarticledao.getCount(articleid,title);
		pageBean.setTotalCount(totalCount);
		//4、封装总页数
		int totalPage = (int) Math.ceil(1.0*totalCount/currentCount);
		pageBean.setTotalPage(totalPage);
		
		//5、当前页显示的数据
		// select * from product where cid=? limit ?,?
		// 当前页与起始索引index的关系
		int index = (currentPage-1)*currentCount;
		List<Bbs> list = null;
		//不是搜索时的查询
		if(title==null||("".equals(title)))
		{
			//查询不是回复时
			if(articleid==null){
				list = bbsarticledao.findArticleByPage(index,currentCount);
			}
			else{
				//查询回复时
				list = bbsarticledao.findArticleByParentid(articleid,index,currentCount);
			}
		}
		//搜索时的 查询
		else {
			if(articleid==null){
				//查询不是回复时
				list = bbsarticledao.findArticleByPageLike(title,index, currentCount);
			}
			else{
				//查询为回复时
				list = bbsarticledao.findArticleByPageParentidLike(articleid,title,index, currentCount);
			}
		}
		pageBean.setList(list);
		
		return pageBean;
	}

	public PageBean findClubDraftArticle(int selectid, String Stuid, int currentPage, int currentCount) {
		
		BbsArticleDao bbsarticledao = new BbsArticleDao();
		
		//封装一个PageBean 返回web层
		PageBean<Bbs> pageBean = new PageBean<Bbs>();
		//1、封装当前页
		pageBean.setCurrentPage(currentPage);
		//2、封装每页显示的条数
		pageBean.setCurrentCount(currentCount);
		//3、封装总条数
		int totalCount = 0;
		totalCount = bbsarticledao.getCountfordarft(selectid,Stuid);
		pageBean.setTotalCount(totalCount);
		//4、封装总页数
		int totalPage = (int) Math.ceil(1.0*totalCount/currentCount);
		pageBean.setTotalPage(totalPage);
		
		//5、当前页显示的数据
		// select * from product where cid=? limit ?,?
		// 当前页与起始索引index的关系
		int index = (currentPage-1)*currentCount;
		List<Bbs> list = null;
		list = bbsarticledao.findArticleByDraft(selectid,Stuid,index,currentCount);
		pageBean.setList(list);
		
		return pageBean;
	}

}

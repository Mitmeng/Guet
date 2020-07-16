package com.meng.dao;

import java.util.List;

import com.meng.beans.BookCrossing;
import com.meng.util.BeanHandler;
import com.meng.util.BeanListHandler;

public class BookCrossingDao extends BaseDao{

	public int getCount(String id) {
		String sql = "select * from guet_bookcrossing_table";
		String sql2 = "select * from guet_bookcrossing_table where booktype=?";
		int idd = Integer.parseInt(id);
		if(idd==0){
			List<BookCrossing> list = (List<BookCrossing>) find(sql, null, new BeanListHandler(BookCrossing.class));
			return list.size();
		}else{
			List<BookCrossing> list = (List<BookCrossing>) find(sql2, new Object[]{id}, new BeanListHandler(BookCrossing.class));
			return list.size();
		}
	}

	public List<BookCrossing> findBook(String id, int index, int currentCount) {
		String sql = "select * from guet_bookcrossing_table order by createtime desc limit ?,?";
		String sql1 = "select * from guet_bookcrossing_table where booktype=? order by createtime desc limit ?,?";
		int idd = Integer.parseInt(id);
		if(idd==0){
			return (List<BookCrossing>) find(sql, new Object[]{index,currentCount}, new BeanListHandler(BookCrossing.class));
		}else{
			return (List<BookCrossing>) find(sql1, new Object[]{id,index,currentCount}, new BeanListHandler(BookCrossing.class));
		}
	}

	public int getCountlike(String title) {
		String sql = "select * from guet_bookcrossing_table where bookname like ? or content like ?";
		List<BookCrossing> list = (List<BookCrossing>) find(sql, new Object[]{"%"+title+"%","%"+title+"%"}, new BeanListHandler(BookCrossing.class));
		return list.size();
	}

	public List<BookCrossing> findBooklike(String title, int index, int currentCount) {
		String sql = "select * from guet_bookcrossing_table where bookname like ? or content like ? order by createtime desc limit ?,?";
		return (List<BookCrossing>) find(sql, new Object[]{"%"+title+"%","%"+title+"%",index,currentCount}, new BeanListHandler(BookCrossing.class));
	}

	public boolean delebookbyid(int stuid, String articleId) {
		String sql1 = "select * from guet_bookcrossing_table where id=?";
		String sql = "delete from guet_bookcrossing_table where id=?";
		BookCrossing bookCrossing = (BookCrossing) find(sql1, new Object[]{articleId}, new BeanHandler(BookCrossing.class));
		if(stuid!=bookCrossing.getStuid()){
			return false;
		}else{
			update(sql, new Object[]{articleId});
			return true;
		}
	}

	public boolean updatestatebyid(int stuid, String articleId) {
		String sql1 = "select * from guet_bookcrossing_table where id=?";
		String sql = "update guet_bookcrossing_table set state=1 where id=?";
		BookCrossing bookCrossing = (BookCrossing) find(sql1, new Object[]{articleId}, new BeanHandler(BookCrossing.class));
		if(stuid!=bookCrossing.getStuid()){
			return false;
		}else{
			update(sql, new Object[]{articleId});
			return true;
		}
		
	}

}

package com.meng.dao;

import java.util.List;

import com.meng.beans.LostAndFound;
import com.meng.util.BeanHandler;
import com.meng.util.BeanListHandler;

public class LostAndFoundDao extends BaseDao{

	public List<LostAndFound> findLostandFound(int index, int currentCount) {
		String sql = "select * from guet_lostandfound_table order by createtime desc limit ?,?";
		return (List<LostAndFound>) find(sql, new Object[]{index,currentCount}, new BeanListHandler(LostAndFound.class));
	}

	public int getCount() {
		String sql = "select * from guet_lostandfound_table";
		List<LostAndFound> list = (List<LostAndFound>) find(sql, null, new BeanListHandler(LostAndFound.class));
		return list.size();
	}

	public int getCountlike(String title) {
		String sql = "select * from guet_lostandfound_table where content like ?";
		List<LostAndFound> list = (List<LostAndFound>) find(sql, new Object[]{"%"+title+"%"}, new BeanListHandler(LostAndFound.class));
		return list.size();
	}

	public List<LostAndFound> findLostandFoundlike(String title, int index, int currentCount) {
		String sql = "select * from guet_lostandfound_table where content like ? order by createtime desc limit ?,?";
		List<LostAndFound> list = (List<LostAndFound>) find(sql, new Object[]{"%"+title+"%",index,currentCount}, new BeanListHandler(LostAndFound.class));
		return list;
	}

	public boolean delelostbyid(int stuid, String articleId) {
		String sql1 = "select * from guet_lostandfound_table where id=?";
		String sql = "delete from guet_lostandfound_table where id=?";
		LostAndFound lostAndFound = (LostAndFound) find(sql1, new Object[]{articleId}, new BeanHandler(LostAndFound.class));
		if(stuid!=lostAndFound.getStuid()){
			return false;
		}else{
			update(sql, new Object[]{articleId});
			return true;
		}
	}

	public boolean updatestatebyid(int stuid, String articleId) {
		String sql = "update guet_lostandfound_table set state=1 where id=?";
		String sql1 = "select * from guet_lostandfound_table where id=?";
		LostAndFound lostAndFound = (LostAndFound) find(sql1, new Object[]{articleId}, new BeanHandler(LostAndFound.class));
		if(stuid!=lostAndFound.getStuid()){
			return false;
		}else {
			update(sql, new Object[]{articleId});
			return true;
		}
	}

	public void Addnewlost(String stuid, String username, String content, String buyorsale, String img) {
		String sql = "insert into guet_lostandfound_table(stuid,img,lostorfount,content,createtime,createperson,totalreply,state)"+"values(?,?,?,?,now(),?,0,0)";
		update(sql, new Object[]{ stuid,img,buyorsale,content,username});
	}

}

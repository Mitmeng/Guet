package com.meng.dao;

import java.util.List;

import com.meng.beans.Club;
import com.meng.beans.ClubArticle;
import com.meng.util.BeanHandler;
import com.meng.util.BeanListHandler;

public class ClubDao extends BaseDao {
	//登录
	public boolean validataClub(String clubid,String password){
		String sql="select * from guet_club_table where clubid=? and password=?";
		Object o=find(sql,new Object[]{clubid,password}, new BeanHandler(Club.class));
		return o!=null;
	}
	//根据clubid查找
	public Club findClubname(String clubid) {
		String sql="select * from guet_club_table where clubid=?";
		return (Club)find(sql,new Object[]{clubid},new BeanHandler(Club.class));
	}
	//插入一个记录
	public boolean insertClub1(String clubid, String clubname, String password) {
		String sql="insert into guet_club_table(clubid,clubname,password)"+"values(?,?,?)";
		if(clubid==null||("".equals(clubid))||clubname==null||("".equals(clubname))||password==null||("".equals(password))){
			return false;
		}
		else{
			update(sql, new Object[]{clubid,clubname,password});
			return true;
		}
	}
	//查找所有概况不为空的社团
	public List<Club> findClub() {
		String sql="select * from guet_club_table where introduce is not null";
		List<Club> clublist = (List<Club>)find(sql,null,new BeanListHandler(Club.class));
		return clublist;
	}
	//根据社团名称查找该记录
	public Club findclubidbyclubname(String createClub) {
		String sql="select * from guet_club_table where clubname=?";
		return (Club)find(sql,new Object[]{createClub},new BeanHandler(Club.class));
	}
	public void Addintroduce(String content, String createClub) {
		String sql="update guet_club_table set introduce=? where clubname=?";
		update(sql, new Object[]{content,createClub});
		
	}
	//查表中所有的社团的数量
	public int getCount() {
		String sql ="select * from guet_club_table";
		List<Club> list = (List<Club>) find(sql, null,new BeanListHandler(Club.class));
		return list.size();
	}
	//查表中所有的社团
	public List<Club> findUser(int index, int currentCount) {
		String sql ="select * from guet_club_table order by id asc limit ?,?";
		return (List<Club>) find(sql,new Object[]{index,currentCount}, new BeanListHandler(Club.class));
	}
	//按社团名字搜索表中的社团的数量
	public int getCountlike(String title) {
		String sql ="select * from guet_club_table where clubid like ?";
		List<Club> list = (List<Club>) find(sql,new Object[]{"%"+title+"%"},new BeanListHandler(Club.class));
		return list.size();
	}
	
	//按社团名字搜索表中的社团
	public List<Club> finduserLike(String title, int index, int currentCount) {
		String sql1 ="select * from guet_club_table where clubid like ? limit ?,?";
		return (List<Club>) find(sql1,new Object[]{"%"+title+"%",index,currentCount},new BeanListHandler(Club.class));
	}
	public void delecluberbyid(String id) {
		String sql = "delete from guet_club_table where id=?";
		update(sql, new Object[]{id});
	}
	public boolean admininsertClub(int id, String clubid, String clubname, String password) {
		String sql="insert into guet_club_table(clubid,clubname,password)"+"values(?,?,?)";
		String sql1="update guet_club_table set clubname=?,password=? where clubid=?";
		if(clubid==null||("".equals(clubid))||clubname==null||("".equals(clubname))||password==null||("".equals(password))){
			return false;
		}
		else{
			if(id==1){
				update(sql,new Object[]{clubid,clubname,password});
			}
			else if(id==2){
				update(sql1,new Object[]{clubname,password,clubid});
			}
			return true;
		}
	}
	//根据id查找
	public Club findClubbyid(String clubid) {
		String sql="select * from guet_club_table where id=?";
		return (Club)find(sql,new Object[]{clubid},new BeanHandler(Club.class));
	}

}

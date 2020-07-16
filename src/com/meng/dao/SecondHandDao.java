package com.meng.dao;

import java.util.List;

import com.meng.beans.SecondHand;
import com.meng.beans.SecondType;
import com.meng.util.BeanHandler;
import com.meng.util.BeanListHandler;

public class SecondHandDao extends BaseDao{

	//查询数据库中所有的二手交易记录
	public int getCount(int id, String stuid) {
		String sql = "select * from guet_secondhand_table";
		String sql1 = "select * from guet_secondhand_table where stuid=?";
		//求未结贴的商品
		String sql2 = "select * from guet_secondhand_table where stuid=? and state=0";
		//出售的商品
		String sql3 = "select * from guet_secondhand_table where stuid=? and buyorsale=1";
		//购买的商品
		String sql4 = "select * from guet_secondhand_table where stuid=? and buyorsale=0";
		//String sql2 = "select * from guet_secondhand_table where producttype=?";
		if(stuid==null||("".equals(stuid))){
			List<SecondHand> list = (List<SecondHand>) find(sql, null, new BeanListHandler(SecondHand.class));
			return list.size();
		}else {
			if(id==1){
				List<SecondHand> list = (List<SecondHand>) find(sql1, new Object[]{stuid}, new BeanListHandler(SecondHand.class));
				return list.size();
			}else if (id==2) {
				//未结贴的商品
				List<SecondHand> list = (List<SecondHand>) find(sql2, new Object[]{stuid}, new BeanListHandler(SecondHand.class));
				return list.size();
			}
			else if (id==3) {
				//出售的商品
				List<SecondHand> list = (List<SecondHand>) find(sql3, new Object[]{stuid}, new BeanListHandler(SecondHand.class));
				return list.size();
			}
			else{
				//购买的商品
				List<SecondHand> list = (List<SecondHand>) find(sql4,  new Object[]{stuid}, new BeanListHandler(SecondHand.class));
				return list.size();
			}
		}
	}
    
	//查询数据库中所有的二手交易记录
	public List<SecondHand> findSecondHand(int id, String stuid, int index, int currentCount) {
		String sql = "select * from guet_secondhand_table order by createtime desc limit ?,?";
		String sql1 = "select * from guet_secondhand_table where stuid=? order by createtime desc limit ?,?";
		//求未结贴的商品
		String sql2 = "select * from guet_secondhand_table where stuid=? and state=0 order by createtime desc limit ?,?";
		//出售的商品
		String sql3 = "select * from guet_secondhand_table where stuid=? and buyorsale=1 order by createtime desc limit ?,?";
		//购买的商品
		String sql4 = "select * from guet_secondhand_table where stuid=? and buyorsale=0 order by createtime desc limit ?,?";
		if(stuid==null||("".equals(stuid))){
			return (List<SecondHand>) find(sql,new Object[]{index,currentCount}, new BeanListHandler(SecondHand.class));
		}else{
			if(id==1){
				return (List<SecondHand>) find(sql1,new Object[]{stuid,index,currentCount}, new BeanListHandler(SecondHand.class));
			}else if (id==2) {
				return (List<SecondHand>) find(sql2,new Object[]{stuid,index,currentCount}, new BeanListHandler(SecondHand.class));
			}
			else if(id==3){
				return (List<SecondHand>) find(sql3,new Object[]{stuid,index,currentCount}, new BeanListHandler(SecondHand.class));
			}
			else{
				return (List<SecondHand>) find(sql4,new Object[]{stuid,index,currentCount}, new BeanListHandler(SecondHand.class));
			}
		}
	}

	//根据查询title和类型关键字查询，因为在不同的两个表，所以相似类型查询总数支取一个
	public int getCountlike(String title) {
		String sql = "select * from guet_secondhand_table where title like ? or producttype=?";
		String sql1 = "select * from guet_secondtype_table where typename like ?";
		SecondType secondType = (SecondType) find(sql1,new Object[]{"%"+title+"%"}, new BeanHandler(SecondType.class));
		int typeid = secondType.getId();
		List<SecondHand> list = (List<SecondHand>)find(sql, new Object[]{"%"+title+"%",typeid}, new BeanListHandler(SecondHand.class));
		return list.size();
	}

	public List<SecondHand> findSecondHandlike(String title, int index, int currentCount) {
		String sql = "select * from guet_secondhand_table where title like ? or producttype=? order by createtime desc limit ?,?";
		String sql1 = "select * from guet_secondtype_table where typename like ?";
		SecondType secondType = (SecondType) find(sql1,new Object[]{"%"+title+"%"}, new BeanHandler(SecondType.class));
		int typeid = secondType.getId();
		List<SecondHand> list = (List<SecondHand>)find(sql, new Object[]{"%"+title+"%",typeid,index,currentCount}, new BeanListHandler(SecondHand.class));
		return list;
	}

	//根据id查表中记录
	public SecondHand findbyid(String secondid) {
		String sql = "select * from guet_secondhand_table where id=?";
		return (SecondHand) find(sql, new Object[]{secondid}, new BeanHandler(SecondHand.class));
	}

	//根据id删除记录
	public void Delesecondbyid(String replyid) {
		String sql = "delete from guet_secondhand_table where id=?";
		update(sql, new Object[]{replyid});
		
	}

	public void Addnewsecondpro(String stuid, String username, String title, String content, String buyorsale,
			String producttype, String img, String price) {
		String sql = "insert into guet_secondhand_table(stuid,title,content,img,createtime,createperson,price,buyorsale,producttype,totalreply,state)"+"values(?,?,?,?,now(),?,?,?,?,0,0)";
		update(sql, new Object[]{stuid,title,content,img,username,price,buyorsale,producttype});
	}

	public void updatestatebyid(String articleId) {
		String sql = "update guet_secondhand_table set state=1 where id=?";
		update(sql, new Object[]{articleId});
	}

	public void updatetotalreply(String aritcleId) {
		String sql = "update guet_secondhand_table set totalreply=totalreply+1 where id=?";
		update(sql, new Object[]{aritcleId});
		
	}

	public void updatetotalreplys(String parentid) {
		String sql = "update guet_secondhand_table set totalreply=totalreply-1 where id=?";
		update(sql, new Object[]{parentid});
		
	}


}

package com.meng.dao;

import java.util.List;

import com.meng.beans.SecondType;
import com.meng.util.BeanHandler;
import com.meng.util.BeanListHandler;

public class SecondTypeDao extends BaseDao{

	//查询所有的类型
	public List<SecondType> findall() {
		String sql = "select * from guet_secondtype_table";
		return (List<SecondType>) find(sql,null, new BeanListHandler(SecondType.class));
	}

	//根据id查询类型
	public SecondType findbyid(int producttype) {
		String sql = "select * from guet_secondtype_table where id =?";
		return (SecondType) find(sql, new Object[]{producttype}, new BeanHandler(SecondType.class));
	}

	//查所有类型的总数量
	public int getCount() {
		String sql = "select * from guet_secondtype_table";
		List<SecondType> list = (List<SecondType>) find(sql,null, new BeanListHandler(SecondType.class));
		return list.size();
	}

	public List<SecondType> findType(int index, int currentCount) {
		String sql = "select * from guet_secondtype_table limit ?,?";
		List<SecondType> list = (List<SecondType>) find(sql,new Object[]{index,currentCount}, new BeanListHandler(SecondType.class));
		return list;
	}

	//查询搜索关键字的数量
	public int getCountlike(String title) {
		String sql = "select * from guet_secondtype_table where typename like ?";
		List<SecondType> list = (List<SecondType>) find(sql, new Object[]{"%"+title+"%"}, new BeanListHandler(SecondType.class));
		return list.size();
	}

	public List<SecondType> findTypelike(String title, int index, int currentCount) {
		String sql = "select * from guet_secondtype_table where typename like ? limit ?,?";
		return (List<SecondType>) find(sql, new Object[]{"%"+title+"%",index,currentCount}, new BeanListHandler(SecondType.class));
	}

	//添加新类型
	public boolean addnewtype(String name) {
		String sql = "insert into guet_secondtype_table(typename) values(?)";
		if(name==null||("".equals(name))){
			return false;
		}else{
			update(sql, new Object[]{name});
			return true;
		}
	}

	public boolean updatetype(String name,String id) {
		String sql = "update guet_secondtype_table set typename=? where id=?";
		if(name==null||("".equals(name))){
			return false;
		}else{
			update(sql, new Object[]{name,id});
			return true;
		}
	}

	public void deletypebyid(String articleId) {
		String sql = "delete from guet_secondtype_table where id=?";
		update(sql, new Object[]{articleId});
	}

}

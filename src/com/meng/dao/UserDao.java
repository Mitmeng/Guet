package com.meng.dao;

import java.util.List;

import com.meng.beans.User;
import com.meng.util.BeanHandler;
import com.meng.util.BeanListHandler;
import com.meng.dao.BaseDao;

public class UserDao extends BaseDao {
	
	public boolean validataUser(String stuid,String password){
		String sql="select * from guet_user_table where stuid=? and password=?";
		Object o=find(sql,new Object[]{stuid,password}, new BeanHandler(User.class));
		return o!=null;
	}

	public boolean validateAdminUser(String name, String password) {
		String sql="select * from guet_user_table where stuid=? and password=? and ismanager=1";
		Object o=find(sql,new Object[]{name,password}, new BeanHandler(User.class));
		return o!=null;
	}
	
	//根据stuid查找用户记录
	public User findUsername(String stuid) {
		String sql="select * from guet_user_table where stuid=?";
		return (User)find(sql,new Object[]{stuid},new BeanHandler(User.class));
	}

	//插入一个记录
	public boolean insertUser(String stuid, String username, String password, String gender, String email, String phone,
		String birthday, String address) {
		String sql="insert into guet_user_table(stuid,username,password,gender,email,phone,birthday,address,"
				+ "isonline,ismanager,registtime)"+"values(?,?,?,?,?,?,?,?,0,0,now())";
		if(stuid==null||("".equals(stuid))||username==null||("".equals(username))||password==null
				||("".equals(password))||gender==null||("".equals(gender))||email==null||("".equals(email))
				||phone==null||("".equals(phone))||birthday==null||("".equals(birthday))||address==null||("".equals(address))){
			return false;
		}
		else{
			update(sql, new Object[]{stuid,username,password,gender,email,phone,birthday,address});
			return true;
		}
	}

	//根据stuid查找用户记录
	public User findUser(int ii) {
		String sql="select * from guet_user_table where stuid=?";
		return (User)find(sql,new Object[]{ii},new BeanHandler(User.class));
	}
	
	//查表中所有的用户的数量
	public int getCount() {
		String sql ="select * from guet_user_table";
		List<User> list = (List<User>) find(sql, null,new BeanListHandler(User.class));
		return list.size();
	}
	//查表中所有的用户
	public List<User> findUser(int index, int currentCount) {
		String sql ="select * from guet_user_table order by ismanager desc limit ?,?";
		return (List<User>) find(sql,new Object[]{index,currentCount}, new BeanListHandler(User.class));
	}
	//按用户名字搜索表中的用户的数量
	public int getCountlike(String title) {
		String sql ="select * from guet_user_table where stuid like ?";
		List<User> list = (List<User>) find(sql,new Object[]{"%"+title+"%"},new BeanListHandler(User.class));
		return list.size();
	}
	
	//按用户名字搜索表中的用户
	public List<User> findUserlike(String title, int index, int currentCount) {
		String sql ="select * from guet_user_table where stuid like ? order by ismanager desc limit ?,?";
		return (List<User>) find(sql,new Object[]{"%"+title+"%",index,currentCount},new BeanListHandler(User.class));
	}

	public void DeleteUser(String articleId) {
		//String sql = "select * from guet_user_table where id=?";
		String sql1 = "delete from guet_user_table where id=?";
		//User user = (User) find(sql, new Object[]{articleId},new BeanHandler(User.class));
		//int stuid = user.getStuid();
		update(sql1,  new Object[]{articleId});
		
		
	}

	public boolean insertUseradmin(int id, String stuid, String username, String password, String gender, String email,
			String phone, String birthday, String address, String ismanager) {
		String sql="insert into guet_user_table(stuid,username,password,gender,"
				+ "email,phone,birthday,address,isonline,ismanager,registtime)"+"values(?,?,?,?,?,?,?,?,0,?,now())";
		String sql1="update guet_user_table set username=?,password=?,gender=?,"
				+ "email=?,phone=?,birthday=?,address=?,ismanager=? where stuid=?";
		if(stuid==null||("".equals(stuid))||username==null||("".equals(username))
				||password==null||("".equals(password))||gender==null||("".equals(gender))
				||email==null||("".equals(email))||phone==null||("".equals(phone))||birthday==null
				||("".equals(birthday))||address==null||("".equals(address))||ismanager==null||("".equals(ismanager))){
			return false;
		}
		else{
			if(id==1){
				update(sql, new Object[]{stuid,username,password,gender,email,phone,birthday,address,ismanager});
			}else if(id==2){
				update(sql1, new Object[]{username,password,gender,email,phone,birthday,address,ismanager,stuid});
			}
			return true;
		}
	}
	
	//根据stuid查找用户记录
	public User findUser(String id) {
		String sql="select * from guet_user_table where id=?";
		return (User)find(sql,new Object[]{id},new BeanHandler(User.class));
	}

}

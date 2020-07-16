package com.meng.dao;

import java.util.List;

import com.meng.beans.SecondHand;
import com.meng.beans.SecondNote;
import com.meng.util.BeanHandler;
import com.meng.util.BeanListHandler;

public class SecondNoteDao extends BaseDao {

	//根据父主题查询相应的回复
	public List<SecondNote> findbyparentid(String secondid) {
		String sql = "select * from guet_secondnote_table where proid=? order by createtime asc";
		return (List<SecondNote>) find(sql, new Object[]{secondid}, new BeanListHandler(SecondNote.class));
	}

	//添加留言
	public void Addreplyarticle(String stuid, String content, String createperson, String aritcleId) {
		String sql = "insert into guet_secondnote_table(proid,stuid,content,createperson,createtime,state)"+"values(?,?,?,?,now(),0)";
		update(sql, new Object[]{aritcleId,stuid,content,createperson});
	}

	//判断该回复信息的创建者是否为登录者
	public boolean validateUser(String id,String loginstuid, String replyid) {
		String sql = "select * from guet_secondnote_table where id =?";
		String sql1 = "select * from guet_secondhand_table where id =?";
		if(id=="1"||id.equals("1")){
			SecondHand sNote = (SecondHand) find(sql1, new Object[]{replyid}, new BeanHandler(SecondHand.class));
			int stuid = Integer.parseInt(loginstuid);
			if(stuid==sNote.getStuid()){
				return true;
			}else {
				return false;
			}
		}else{
			SecondNote sNote = (SecondNote) find(sql, new Object[]{replyid}, new BeanHandler(SecondNote.class));
			int stuid = Integer.parseInt(loginstuid);
			if(stuid==sNote.getStuid()){
				return true;
			}else {
				return false;
			}
		}
	}

	//删除回复
	public void Delereplybbyid(String replyid) {
		String sql = "delete from guet_secondnote_table where id=?";
		update(sql, new Object[]{replyid});	
	}

	//根据proid删除回复
	public void Delereplybbyproid(String parentid) {
		String sql = "delete from guet_secondnote_table where proid=?";
		update(sql, new Object[]{parentid});	
		
	}

	//查询所有留言的总数
	public int getCount() {
		String sql =  "select * from guet_secondnote_table";
		List<SecondNote> list = (List<SecondNote>) find(sql, null, new BeanListHandler(SecondNote.class));
		return list.size();
	}

	//查询所有留言
	public List<SecondNote> findNote(int index, int currentCount) {
		String sql =  "select * from guet_secondnote_table order by createtime desc limit ?,?";
		return (List<SecondNote>) find(sql, new Object[]{index,currentCount}, new BeanListHandler(SecondNote.class));
	}

	//根据关键字查询留言的数量
	public int getCountlike(String title) {
		String sql =  "select * from guet_secondnote_table where content like ? or createperson like ?";
		List<SecondNote> list = (List<SecondNote>) find(sql,new Object[]{"%"+title+"%","%"+title+"%"}, new BeanListHandler(SecondNote.class));
		return list.size();
	}

	//根据关键字查询留言
	public List<SecondNote> findNotelike(String title, int index, int currentCount) {
		String sql =  "select * from guet_secondnote_table where content like ? or createperson like ? order by createtime desc limit ?,?";
		List<SecondNote> list = (List<SecondNote>) find(sql,new Object[]{"%"+title+"%","%"+title+"%",index,currentCount}, new BeanListHandler(SecondNote.class));
		return list;
	}

}

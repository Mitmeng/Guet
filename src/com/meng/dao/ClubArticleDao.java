package com.meng.dao;

import java.util.List;
import com.meng.beans.ClubArticle;
import com.meng.util.BeanHandler;
import com.meng.util.BeanListHandler;
import com.meng.dao.BaseDao;

public class ClubArticleDao extends BaseDao{

	public int getCount(int i, String title) {
		String sql = "select * from guet_clubarticle_table where `release`=1";
		String sql1 = "select * from guet_clubarticle_table where `release`=1 and clubtitle like ?";
		String sql2 = "select * from guet_clubarticle_table where draft=0 and audit=0";
		String sql3 = "select * from guet_clubarticle_table where draft=0 and audit=0 and clubtitle like ?";
		List<ClubArticle> list = null;
		if(title==null||("".equals(title)))
		{
			if(i==0){
				list = (List<ClubArticle>)find(sql,null, new BeanListHandler(ClubArticle.class));
			}else{
				list = (List<ClubArticle>)find(sql2,null, new BeanListHandler(ClubArticle.class));
			}
		}
		else if(title!=null&&!("".equals(title))){
			if(i==0){
				list = (List<ClubArticle>)find(sql1,new Object[]{"%"+title+"%"}, new BeanListHandler(ClubArticle.class));
			}
			else{
				list = (List<ClubArticle>)find(sql3,new Object[]{"%"+title+"%"}, new BeanListHandler(ClubArticle.class));
			}
		}
		return list.size();
	}
	
	//查找所有的公告并按时间顺序排序

	public List<ClubArticle> findArticleByPage(int i, int index, int currentCount) {
		String sql = "select * from guet_clubarticle_table where `release`=1 order by releasedate desc limit ?,?";
		String sql1 = "select * from guet_clubarticle_table where draft=0 and audit=0 limit ?,?";
		if(i==0){
			return (List<ClubArticle>) find(sql,new Object[]{index,currentCount},new BeanListHandler(ClubArticle.class));
		}else{
			return (List<ClubArticle>) find(sql1,new Object[]{index,currentCount},new BeanListHandler(ClubArticle.class));
		}
	}
	
	//在所有的公告中查点击量最高的10个
	public List<ClubArticle> findTotalread(){
		String sql = "select * from guet_clubarticle_table where `release`=1 order by totalread desc limit 0,10";
		List<ClubArticle> list = (List<ClubArticle>)find(sql, null, new BeanListHandler(ClubArticle.class));
		return list;
	}

	//按标题搜索
	public List<ClubArticle> findArticleByPageLike(int i, String title, int index, int currentCount) {
		String sql = "select * from guet_clubarticle_table where `release`=1 and clubtitle like ? order by releasedate desc limit ?,?";
		String sql1 = "select * from guet_clubarticle_table where draft=0 and audit=0 and clubtitle like ? limit ?,?";
		if(i==0){
			return (List<ClubArticle>) find(sql,new Object[]{"%"+title+"%",index,currentCount},new BeanListHandler(ClubArticle.class));
		}else{
			return (List<ClubArticle>) find(sql1,new Object[]{"%"+title+"%",index,currentCount},new BeanListHandler(ClubArticle.class));
		}
	}

	//添加新纪录（提交审核）
	public void addArticle(Integer clubid, String title, String content, String createClub) {
		String sql="insert into guet_clubarticle_table(clubid,clubname,clubtitle,clubcontent,draft,audit,`release`,totalread)"+"values(?,?,?,?,0,0,0,0)";
		update(sql, new Object[]{clubid,createClub,title,content});
		
	}

	//添加到草稿箱
	public void addArticleDraft(Integer clubid, String title, String content, String createClub) {
		String sql="insert into guet_clubarticle_table(clubid,clubname,clubtitle,clubcontent,draft,audit,`release`,totalread)"+"values(?,?,?,?,1,0,0,0)";
		update(sql, new Object[]{clubid,createClub,title,content});
		
	}

	public int getCountforDraft(int selectid, String clubname) {
		//查草稿箱
		String sql1 = "select * from guet_clubarticle_table where draft=1 and clubname=?";
		//查已提交审核但未审核的公告
		String sql2 = "select * from guet_clubarticle_table where draft=0 and audit=0 and clubname=?";
		//查已经审核的草稿箱，即未发布但已经审核的公告
		String sql3 = "select * from guet_clubarticle_table where draft=0 and audit!=0 and `release`=0 and clubname=?";
		//查该社团所有的非草稿箱的公告
		String sql4 = "select * from guet_clubarticle_table where draft=0 and clubname=?";
		List<ClubArticle> list = null;
		if(selectid==1){
			list = (List<ClubArticle>)find(sql1,new Object[]{clubname}, new BeanListHandler(ClubArticle.class));
		}
		else if(selectid==2){
			list = (List<ClubArticle>)find(sql2,new Object[]{clubname}, new BeanListHandler(ClubArticle.class));
		}
		else if(selectid==3){
			list = (List<ClubArticle>)find(sql3,new Object[]{clubname}, new BeanListHandler(ClubArticle.class));
		}
		else{
			list = (List<ClubArticle>)find(sql4,new Object[]{clubname}, new BeanListHandler(ClubArticle.class));
		}
		return list.size();
	}

	public List<ClubArticle> findArticleByDraft(int selectid, String clubname, int index, int currentCount) {
		//查草稿箱
		String sql1 = "select * from guet_clubarticle_table where draft=1 and clubname=? limit ?,?";
		//查已提交审核但未审核的公告
		String sql2 = "select * from guet_clubarticle_table where draft=0 and audit=0 and clubname=? limit ?,?";
		//查已经审核的草稿箱，即未发布但已经审核的公告
		String sql3 = "select * from guet_clubarticle_table where draft=0 and audit!=0 and `release`=0 and clubname=? limit ?,?";
		//查该社团所有的非草稿箱的公告
		String sql4 = "select * from guet_clubarticle_table where draft=0 and clubname=? limit ?,?";
		if(selectid==1){
			return (List<ClubArticle>) find(sql1,new Object[]{clubname,index,currentCount},new BeanListHandler(ClubArticle.class));
		}
		else if (selectid==2) {
			return (List<ClubArticle>) find(sql2,new Object[]{clubname,index,currentCount},new BeanListHandler(ClubArticle.class));
		}
		else if (selectid==3) {
			return (List<ClubArticle>) find(sql3,new Object[]{clubname,index,currentCount},new BeanListHandler(ClubArticle.class));
		}
		else {
			return (List<ClubArticle>) find(sql4,new Object[]{clubname,index,currentCount},new BeanListHandler(ClubArticle.class));
		}
	}

	public ClubArticle findArticlebyid(int id) {
		String sql = "select * from guet_clubarticle_table where id=?";
		return (ClubArticle) find(sql, new Object[]{id}, new BeanHandler(ClubArticle.class));
	}

	//草稿箱->编辑 进行保存操作,idd=1为普通操作，idd=2为审核为通过后的操作
	public void updateArticleDraft(int idd, String articleId, String title, String content) {
		String sql = "update guet_clubarticle_table set clubtitle=?,clubcontent=? where id=?";
		String sql1 = "update guet_clubarticle_table set clubtitle=?,clubcontent=?,draft=1,audit=0 where id=?";
		if(idd==2){
			update(sql1, new Object[]{title,content,articleId});
		}
		else{
			update(sql, new Object[]{title,content,articleId});
		}
	}

	//草稿箱->编辑 进行提交审核操作,idd=1为普通操作，idd=2为审核为通过后的操作
	public void updateArticle(int idd, String articleId, String title, String content) {
		String sql = "update guet_clubarticle_table set clubtitle=?,clubcontent=?,draft=0 where id=?";
		String sql1 = "update guet_clubarticle_table set clubtitle=?,clubcontent=?,draft=0,audit=0 where id=?";
		if(idd==2){
			update(sql1, new Object[]{title,content,articleId});
		}
		else{
			update(sql, new Object[]{title,content,articleId});
		}
	}

	//发布公告
	public void publishArticle(int articleId) {
		String sql = "update guet_clubarticle_table set `release`=1,releasedate=now() where id=?";
		update(sql, new Object[]{articleId});
	}

	//草稿箱->提交审核
	public void updatemodifly(int articleId) {
		String sql = "update guet_clubarticle_table set draft=0 where id=?";
		update(sql, new Object[]{articleId});	
	}

	//删除一条记录
	public void DeleteArticle(int ctticleId) {
		String sql = "delete from guet_clubarticle_table where id=?";
		update(sql, new Object[]{ctticleId});
		
	}

	//根据articleid进行审核，id等于2为审核不通过，id等于1为审核通过
	public void updateAduitbyid(int id, String articleid) {
		String sql = "update guet_clubarticle_table set audit=1 where id=?";
		String sql1 = "update guet_clubarticle_table set audit=2 where id=?";
		if(id==1){
			update(sql, new Object[]{articleid});
		}
		else if(id==2){
			update(sql1, new Object[]{articleid});
		}
	}

}

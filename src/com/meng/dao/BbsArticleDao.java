package com.meng.dao;

import java.util.List;
import com.meng.dao.BaseDao;
import com.meng.beans.Bbs;
import com.meng.beans.ClubArticle;
import com.meng.util.BeanHandler;
import com.meng.util.BeanListHandler;

public class BbsArticleDao extends BaseDao{

	//用于分页，查询所有已发布的帖子的总数
	public int getCount(String articleid, String title) {
		String sql = "select * from guet_bbs_table where `release`=1 and parentarticleid is null";
		String sql1 = "select * from guet_bbs_table where `release`=1 and parentarticleid is null and title like ?";
		//帖子的回复数
		String sql2 = "select * from guet_bbs_table where parentarticleid=?";
		String sql3 = "select * from guet_bbs_table where parentarticleid=? and title like ?";
		List<Bbs> list = null;
		if(title==null||("".equals(title)))
		{
			if(articleid==null){
				list = (List<Bbs>)find(sql,null,new BeanListHandler(Bbs.class));
			}
			else{
				list = (List<Bbs>)find(sql2,new Object[]{articleid},new BeanListHandler(Bbs.class));
			}
		}
		else if(title!=null&&!("".equals(title))){
			if(articleid==null){
				list = (List<Bbs>)find(sql1,new Object[]{"%"+title+"%"}, new BeanListHandler(Bbs.class));
			}
			else{
				list = (List<Bbs>)find(sql3,new Object[]{articleid,"%"+title+"%"}, new BeanListHandler(Bbs.class));
			}
		}
		return list.size();
	}

	//查所有已发布的帖子并按时间先后顺序排序
	public List<Bbs> findArticleByPage(int index, int currentCount) {
		String sql = "select * from guet_bbs_table where `release`=1 and parentarticleid is null order by lastupdatetime desc limit ?,?";
		return (List<Bbs>) find(sql,new Object[]{index,currentCount},new BeanListHandler(Bbs.class));
	}

	//按标题搜索
	public List<Bbs> findArticleByPageLike(String title, int index, int currentCount) {
		String sql = "select * from guet_bbs_table where `release`=1 and parentarticleid is null and title like ? order by lastupdatetime desc limit ?,?";
		return (List<Bbs>) find(sql,new Object[]{"%"+title+"%",index,currentCount},new BeanListHandler(Bbs.class));
	}

	//查所有已发表的帖子中回复最多 的前10 个
	public List<Bbs> findTotalread() {
		String sql = "select * from guet_bbs_table where `release`=1 and parentarticleid is null order by totalreply desc limit 0,10";
		List<Bbs> list = (List<Bbs>)find(sql, null, new BeanListHandler(Bbs.class));
		return list;
	}

	//根据帖子id查找帖子内容
	public Bbs findArticlebyid(String articleid) {
		String sql = "select * from guet_bbs_table where id=?";
		return (Bbs) find(sql, new Object[]{articleid}, new BeanHandler(Bbs.class));
	}

	public int findTotalArticle(int stuid) {
		String sql = "select * from guet_bbs_table where stuid=?";
		List<Bbs> list = (List<Bbs>)find(sql, new Object[]{stuid}, new BeanListHandler(Bbs.class));
		return list.size();
	}

	//根据帖子id查该帖子的所有回复
	public List<Bbs> findArticleByParentid(String articleid, int index, int currentCount) {
		String sql = "select * from guet_bbs_table where parentarticleid=? order by lastupdatetime asc limit ?,?";
		return (List<Bbs>) find(sql,new Object[]{articleid,index,currentCount},new BeanListHandler(Bbs.class));
	}

	//按内容检索指定id的帖子的所有回复
	public List<Bbs> findArticleByPageParentidLike(String articleid, String title, int index, int currentCount) {
		String sql = "select * from guet_bbs_table where parentarticleid=? and content like ? order by lastupdatetime desc limit ?,?";
		return (List<Bbs>) find(sql,new Object[]{articleid,"%"+title+"%",index,currentCount},new BeanListHandler(Bbs.class));
	}

	//验证操作者是否为登录者
	public boolean validataUser(String loginuser, int ctticleId) {
		String sql = "select * from guet_bbs_table where id=?";
		Bbs bbs=(Bbs) find(sql,new Object[]{ctticleId}, new BeanHandler(Bbs.class));
		if(bbs.getCreateperson().equals(loginuser)||bbs.getCreateperson()==loginuser){
			return true;
		}else{
			return false;
		}
	}

	//根据id删除帖子记录(包含其所有的回复)
	public void Deletearticlebyid(int ctticleId,int idd, String id) {
		String sql = "delete from guet_bbs_table where id=?";
		String sql1 = "delete from guet_bbs_table where parentarticleid=?";
		String sql2 = "update guet_bbs_table set totalreply=totalreply-1 where id=?";
		//删除的为主题帖
		if(idd==1){
			update(sql, new Object[]{ctticleId});
			update(sql1, new Object[]{ctticleId});
		}
		//删除的为回复帖
		else{
			update(sql, new Object[]{ctticleId});
			update(sql2, new Object[]{id});
		}
	}

	//为指定id的主题帖子添加回复并更新主题贴
	public void Addreplyarticle(String stuid, String title, String content, String createperson, String aritcleId) {
		String sql ="insert into guet_bbs_table(stuid,title,content,`release`,createtime,createperson,lastupdateperson,lastupdatetime,"
				+ "parentarticleid,totalreply,agree,disagree)"+"values(?,?,?,1,now(),?,?,now(),?,0,0,0)";
		String sql1 = "update guet_bbs_table set totalreply=totalreply+1 where id=?";
		update(sql, new Object[]{stuid,title,content,createperson,createperson,aritcleId});
		update(sql1, new Object[]{aritcleId});
	}

	//添加同意数量
	public void updateAgree(String aticleId) {
		String sql = "update guet_bbs_table set agree=agree+1 where id=?";
		update(sql, new Object[]{aticleId});
	}

	//再点击一次取消同意
	public void updateAgree1(String aticleId) {
		String sql = "update guet_bbs_table set agree=agree-1 where id=?";
		update(sql, new Object[]{aticleId});
		
	}

	//添加不同意数量
	public void updateDisagree(String aticleId) {
		String sql = "update guet_bbs_table set disagree=disagree+1 where id=?";
		update(sql, new Object[]{aticleId});
		
	}
	//再点击一次取消不同意
	public void updateDisagree1(String aticleId) {
		String sql = "update guet_bbs_table set disagree=disagree-1 where id=?";
		update(sql, new Object[]{aticleId});
		
	}

	//添加主题帖到草稿箱
	public void addArticleDraft(String stuid, String title, String content, String createperson) {
		String sql = "insert into guet_bbs_table(stuid,title,content,`release`,createtime,createperson,lastupdateperson,lastupdatetime,"
				+ "totalreply,agree,disagree)"+"values(?,?,?,0,now(),?,?,now(),0,0,0)";
		update(sql, new Object[]{stuid,title,content,createperson,createperson});
	}

	//添加并发布主题帖
	public void addArticle(String stuid, String title, String content, String createperson) {
		String sql = "insert into guet_bbs_table(stuid,title,content,`release`,createtime,createperson,lastupdateperson,lastupdatetime,"
				+ "totalreply,agree,disagree)"+"values(?,?,?,1,now(),?,?,now(),0,0,0)";
		update(sql, new Object[]{stuid,title,content,createperson,createperson});
		
	}

	public int getCountfordarft(int selectid, String stuid) {
		//查草稿箱
		String sql1 = "select * from guet_bbs_table where stuid=? and `release`=0";
		//查所有主题帖
		String sql2 = "select * from guet_bbs_table where stuid=? and parentarticleid is null";
		//查所有回复帖
		String sql3 = "select * from guet_bbs_table where stuid=? and parentarticleid is not null";
		List<Bbs> list = null;
		if(selectid==1){
			list = (List<Bbs>) find(sql1,new Object[]{stuid},new BeanListHandler(Bbs.class));
		}else if (selectid==2) {
			list = (List<Bbs>) find(sql2,new Object[]{stuid},new BeanListHandler(Bbs.class));
		}else {
			list = (List<Bbs>) find(sql3,new Object[]{stuid},new BeanListHandler(Bbs.class));
		}
		return list.size();
	}

	public List<Bbs> findArticleByDraft(int selectid, String stuid, int index, int currentCount) {
		//查草稿箱
		String sql1 = "select * from guet_bbs_table where stuid=? and `release`=0";
		//查所有主题帖
		String sql2 = "select * from guet_bbs_table where stuid=? and parentarticleid is null";
		//查所有回复帖
		String sql3 = "select * from guet_bbs_table where stuid=? and parentarticleid is not null";
		List<Bbs> list = null;
		if(selectid==1){
			return (List<Bbs>) find(sql1,new Object[]{stuid},new BeanListHandler(Bbs.class));
		}else if (selectid==2) {
			return (List<Bbs>) find(sql2,new Object[]{stuid},new BeanListHandler(Bbs.class));
		}else {
			return (List<Bbs>) find(sql3,new Object[]{stuid},new BeanListHandler(Bbs.class));
		}
	}

	public void Delearticlebyid(String artId) {
		String sql = "select * from guet_bbs_table where id=?";
		String sql1 = "delete from guet_bbs_table where id=?";
		String sql2 = "delete from guet_bbs_table where parentarticleid=?";
		Bbs list = (Bbs) find(sql,new Object[]{artId},new BeanHandler(Bbs.class));
		if(list.getParentarticleid()==null||"".equals(list.getParentarticleid())){
			update(sql1, new Object[]{artId});
			update(sql2, new Object[]{artId});
		}
		else{
			update(sql1, new Object[]{artId});
		}
	}

	//发表草稿箱
	public void updatemodifly(int articleId) {
		String sql = "update guet_bbs_table set `release`=1 where id=?";
		update(sql, new Object[]{articleId});
	}

	//草稿箱保存到草稿箱
	public void updateArticleDraft(String articleId, String title, String content) {
		String sql = "update guet_bbs_table set title=?,content=? where id=?";
		update(sql, new Object[]{title,content,articleId});
		
	}

	//草稿箱到发布
	public void updateArticle(String articleId, String title, String content) {
		String sql = "update guet_bbs_table set title=?,content=?,`release`=1 where id=?";
		update(sql, new Object[]{title,content,articleId});
	}
	

}

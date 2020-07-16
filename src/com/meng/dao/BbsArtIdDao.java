package com.meng.dao;

import com.meng.beans.BbsArtId;
import com.meng.util.BeanHandler;

public class BbsArtIdDao extends BaseDao {

	public BbsArtId findBbsArt(String stuid, String aticleId) {
		String sql = "select * from `guet_bbs-art_table` where stuid=? and bbsarticleid=?";
		return (BbsArtId) find(sql, new Object[]{stuid,aticleId}, new BeanHandler(BbsArtId.class));
	}

	//第一次操作，若点击了同意，封锁不同意
	public void AddbbsArtIdforagree(String stuid, String aticleId) {
		String sql = "insert into `guet_bbs-art_table` (stuid,bbsarticleid,flag,forflag) values (?,?,1,1)";
		update(sql,new Object[]{stuid,aticleId});
	}
	//第一次操作，若点击了同意，封锁不同意
	public void AddbbsArtIdfordisagree(String stuid, String aticleId) {
		String sql = "insert into `guet_bbs-art_table` (stuid,bbsarticleid,flag,forflag) values (?,?,1,0)";
		update(sql,new Object[]{stuid,aticleId});
	}

	
	public void updateFlag1(String stuid, String aticleId) {
		String sql = "update `guet_bbs-art_table` set flag=0 where stuid=? and bbsarticleid=?";
		update(sql,new Object[]{stuid,aticleId});
	}

	
	public void updateFlag2(String stuid, String aticleId) {
		String sql = "update `guet_bbs-art_table` set flag=1 where stuid=? and bbsarticleid=?";
		update(sql,new Object[]{stuid,aticleId});
	}

	
	public void updateforFlag1(String stuid, String aticleId) {
		String sql = "update `guet_bbs-art_table` set forflag=0 where stuid=? and bbsarticleid=?";
		update(sql,new Object[]{stuid,aticleId});
	}

	
	public void updateforFlag2(String stuid, String aticleId) {
		String sql = "update `guet_bbs-art_table` set forflag=1 where stuid=? and bbsarticleid=?";
		update(sql,new Object[]{stuid,aticleId});
	}
}

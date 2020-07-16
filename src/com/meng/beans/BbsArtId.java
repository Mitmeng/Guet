package com.meng.beans;

/**
 * 论坛帖子与用户的中间实体类
 **/
public class BbsArtId {

	private int id;
	private int stuid;
	private int bbsarticleid;
	private int flag;
	private int forflag;
	
	
	public int getForflag() {
		return forflag;
	}
	public void setForflag(int forflag) {
		this.forflag = forflag;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStuid() {
		return stuid;
	}
	public void setStuid(int stuid) {
		this.stuid = stuid;
	}
	public int getBbsarticleid() {
		return bbsarticleid;
	}
	public void setBbsarticleid(int bbsarticleid) {
		this.bbsarticleid = bbsarticleid;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
}

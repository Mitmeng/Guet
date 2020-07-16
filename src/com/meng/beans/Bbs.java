package com.meng.beans;

import java.util.Date;

/**
 * 论坛帖子实体类
 **/

public class Bbs {
	
	private int id;
	private int stuid;
	private String title;
	private String content;
	private int release;
	private Date createtime;
	private String createperson;
	private String lastupdateperson;
	private Date lastupdatetime;
	private Integer parentarticleid;
	private int totalreply;
	private int agree;
	private int disagree;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getRelease() {
		return release;
	}
	public void setRelease(int release) {
		this.release = release;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getCreateperson() {
		return createperson;
	}
	public void setCreateperson(String createperson) {
		this.createperson = createperson;
	}
	public String getLastupdateperson() {
		return lastupdateperson;
	}
	public void setLastupdateperson(String lastupdateperson) {
		this.lastupdateperson = lastupdateperson;
	}
	public Date getLastupdatetime() {
		return lastupdatetime;
	}
	public void setLastupdatetime(Date lastupdatetime) {
		this.lastupdatetime = lastupdatetime;
	}
	
	public Integer getParentarticleid() {
		return parentarticleid;
	}
	public void setParentarticleid(Integer parentarticleid) {
		this.parentarticleid = parentarticleid;
	}
	public int getTotalreply() {
		return totalreply;
	}
	public void setTotalreply(int totalreply) {
		this.totalreply = totalreply;
	}
	
	public int getAgree() {
		return agree;
	}
	public void setAgree(int agree) {
		this.agree = agree;
	}
	public int getDisagree() {
		return disagree;
	}
	public void setDisagree(int disagree) {
		this.disagree = disagree;
	}
	
	
	
	
	

}

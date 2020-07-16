package com.meng.beans;

import java.util.Date;

public class BookCrossing {

	
	private int id;
	private int stuid;
	private String img;
	private String bookname;
	private String content;
	private Date createtime;
	private String createperson;
	private int booktype;
	private int totalreply;
	private int state;
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
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public int getBooktype() {
		return booktype;
	}
	public void setBooktype(int booktype) {
		this.booktype = booktype;
	}
	public int getTotalreply() {
		return totalreply;
	}
	public void setTotalreply(int totalreply) {
		this.totalreply = totalreply;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
}

package com.meng.beans;

import java.util.Date;

public class SecondHand {
	
	private int id;
	private int stuid;
	private String title;
	private String content;
	private String img;
	private Date createtime;
	private String createperson;
	private int buyorsale;
	private int producttype;
	private int totalreply;
	private int state;
	private double price;
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
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
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
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
	public int getBuyorsale() {
		return buyorsale;
	}
	public void setBuyorsale(int buyorsale) {
		this.buyorsale = buyorsale;
	}
	public int getProducttype() {
		return producttype;
	}
	public void setProducttype(int producttype) {
		this.producttype = producttype;
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

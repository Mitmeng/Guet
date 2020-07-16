package com.meng.beans;

import java.util.Date;

public class ClubArticle {
	
	private Integer id;
	private Integer clubid;
	private String clubname;
	private String clubtitle;
	private String clubcontent;
	private Integer draft;
	private Integer audit;
	private Integer release;
	private Date releasedate;
	private Integer totalread;
	
	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getClubid() {
		return this.clubid;
	}

	public void setClubid(Integer clubid) {
		this.clubid = clubid;
	}
	
	public String getClubname() {
		return this.clubname;
	}

	public void setClubname(String clubname) {
		this.clubname = clubname;
	}

	public String getClubtitle() {
		return this.clubtitle;
	}

	public void setClubtitle(String clubtitle) {
		this.clubtitle = clubtitle;
	}

	public String getClubcontent() {
		return this.clubcontent;
	}

	public void setClubcontent(String clubcontent) {
		this.clubcontent = clubcontent;
	}

	public Integer getDraft() {
		return this.draft;
	}

	public void setDraft(Integer draft) {
		this.draft = draft;
	}

	public Integer getAudit() {
		return this.audit;
	}

	public void setAudit(Integer audit) {
		this.audit = audit;
	}

	public Integer getRelease() {
		return this.release;
	}

	public void setRelease(Integer release) {
		this.release = release;
	}

	public Date getReleasedate() {
		return this.releasedate;
	}

	public void setReleasedate(Date releasedate) {
		this.releasedate = releasedate;
	}
	
	public Integer getTotalread() {
		return this.totalread;
	}

	public void setTotalread(Integer totalread) {
		this.totalread = totalread;
	}

}

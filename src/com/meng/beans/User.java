package com.meng.beans;

import java.util.Date;

public class User {
	
	private Integer id;
	private Integer stuid;
	private String username;
	private String password;
	private Integer gender;
	private String email;
	private String phone;
	private Date birthday;
	private String address;
	private Integer isonline;
	private Integer ismanager;
	private Date registTime;
	
	// Property accessors

		public Integer getId() {
			return this.id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Integer getStuid() {
			return this.stuid;
		}

		public void setStuid(Integer stuid) {
			this.stuid = stuid;
		}

		public String getUsername() {
			return this.username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return this.password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Integer getGender() {
			return this.gender;
		}

		public void setGender(Integer gender) {
			this.gender = gender;
		}

		public String getEmail() {
			return this.email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhone() {
			return this.phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public Date getBirthday() {
			return this.birthday;
		}

		public void setBirthday(Date birthday) {
			this.birthday = birthday;
		}

		public String getAddress() {
			return this.address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public Integer getIsonline() {
			return this.isonline;
		}

		public void setIsonline(Integer isonline) {
			this.isonline = isonline;
		}

		public Integer getIsmanager() {
			return this.ismanager;
		}

		public void setIsmanager(Integer ismanager) {
			this.ismanager = ismanager;
		}

		public Date getRegistTime() {
			return this.registTime;
		}

		public void setRegistTime(Date registTime) {
			this.registTime = registTime;
		}

}

package com.ezen.dto;

import java.util.Date;

public class JoinBoardVO {
	private int bSeq;
	private String title;
	private String id;
	private int pay;
	private String content;
	private String upload;
	private Date inDate;
	private String pwd;
	private String name;
	private String profile;
	private int role;
	private String email;
	private Date reg_date;
	
	public int getbSeq() {
		return bSeq;
	}
	public void setbSeq(int bSeq) {
		this.bSeq = bSeq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUpload() {
		return upload;
	}
	public void setUpload(String upload) {
		this.upload = upload;
	}
	public Date getInDate() {
		return inDate;
	}
	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	
	@Override
	public String toString() {
		return "JoinBoard [bSeq=" + bSeq + ", title=" + title + ", id=" + id + ", pay=" + pay + ", content=" + content
				+ ", upload=" + upload + ", inDate=" + inDate + ", pwd=" + pwd + ", name=" + name + ", profile="
				+ profile + ", role=" + role + ", email=" + email + ", reg_date=" + reg_date + "]";
	}
	
	
	
}

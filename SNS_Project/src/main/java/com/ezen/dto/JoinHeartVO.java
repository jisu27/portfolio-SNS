package com.ezen.dto;

import java.util.Date;

public class JoinHeartVO {

	private int bSeq;
	private String title;
	private String id;
	private String id_1;
	private int pay;
	private String content;
	private String upload;
	private Date inDate; 
	private String use_like;
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
	public String getId_1() {
		return id_1;
	}
	public void setId_1(String id_1) {
		this.id_1 = id_1;
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
	public String getUse_like() {
		return use_like;
	}
	public void setUse_like(String use_like) {
		this.use_like = use_like;
	}
	@Override
	public String toString() {
		return "JoinHeartVO [bSeq=" + bSeq + ", title=" + title + ", id=" + id + ", id_1=" + id_1 + ", pay=" + pay
				+ ", content=" + content + ", upload=" + upload + ", inDate=" + inDate + ", use_like=" + use_like + "]";
	}
	
	
}

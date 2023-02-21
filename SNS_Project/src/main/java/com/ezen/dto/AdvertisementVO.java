package com.ezen.dto;

import java.util.Date;

public class AdvertisementVO {
	private int aSeq;
	private String title;
	private String id;
	private int pay;
	private String content;
	private String img;
	private Date inDate;
	public int getaSeq() {
		return aSeq;
	}
	public void setaSeq(int aSeq) {
		this.aSeq = aSeq;
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
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Date getInDate() {
		return inDate;
	}
	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}
	@Override
	public String toString() {
		return "AdvertisementVO [aSeq=" + aSeq + ", title=" + title + ", id=" + id + ", pay=" + pay + ", content="
				+ content + ", img=" + img + ", inDate=" + inDate + "]";
	}
	
	
	
}

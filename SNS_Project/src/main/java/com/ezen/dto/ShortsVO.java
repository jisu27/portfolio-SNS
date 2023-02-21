package com.ezen.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class ShortsVO {

	private int sSeq;
	private String sTitle;
	private String id;
	private String upload;
	private Date inDate;
	private MultipartFile uploadFile;
	private String sContent;
	private String searchKeyword;
	private int count;
	private int pay;
	
	

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public int getsSeq() {
		return sSeq;
	}

	public void setsSeq(int sSeq) {
		this.sSeq = sSeq;
	}

	public String getsTitle() {
		return sTitle;
	}

	public void setsTitle(String sTitle) {
		this.sTitle = sTitle;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public MultipartFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getsContent() {
		return sContent;
	}

	public void setsContent(String sContent) {
		this.sContent = sContent;
	}

	@Override
	public String toString() {
		return "ShortsVO [sSeq=" + sSeq + ", sTitle=" + sTitle + ", id=" + id
				+ ", upload=" + upload + ", inDate=" + inDate + ", uploadFile="
				+ uploadFile + ", sContent=" + sContent + ", searchKeyword="
				+ searchKeyword + ", count=" + count + ", pay=" + pay + "]";
	}
}

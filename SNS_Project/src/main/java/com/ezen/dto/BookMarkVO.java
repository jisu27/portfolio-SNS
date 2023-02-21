package com.ezen.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class BookMarkVO {
	private int bmSeq;
	private int bSeq;
	private int sSeq;
	private String bmTitle;
	private String bmUrl;
	private String id;
	private String upload;
	private Date inDate;
	private MultipartFile uploadfile;
	private int count;
	private String keyWord;
	private String searchKeyword;
	private String sTitle;
	private int pay;
	private String content;

	public int getBmSeq() {
		return bmSeq;
	}

	public void setBmSeq(int bmSeq) {
		this.bmSeq = bmSeq;
	}

	public int getbSeq() {
		return bSeq;
	}

	public void setbSeq(int bSeq) {
		this.bSeq = bSeq;
	}

	public int getsSeq() {
		return sSeq;
	}

	public void setsSeq(int sSeq) {
		this.sSeq = sSeq;
	}

	public String getBmTitle() {
		return bmTitle;
	}

	public void setBmTitle(String bmTitle) {
		this.bmTitle = bmTitle;
	}

	public String getBmUrl() {
		return bmUrl;
	}

	public void setBmUrl(String bmUrl) {
		this.bmUrl = bmUrl;
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

	public MultipartFile getUploadfile() {
		return uploadfile;
	}

	public void setUploadfile(MultipartFile uploadfile) {
		this.uploadfile = uploadfile;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	
	public String getsTitle() {
		return sTitle;
	}

	public void setsTitle(String sTitle) {
		this.sTitle = sTitle;
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

	@Override
	public String toString() {
		return "BookMarkVO [bmSeq=" + bmSeq + ", bSeq=" + bSeq + ", sSeq=" + sSeq + ", bmTitle=" + bmTitle + ", bmUrl="
				+ bmUrl + ", id=" + id + ", upload=" + upload + ", inDate=" + inDate + ", uploadfile=" + uploadfile
				+ ", count=" + count + ", keyWord=" + keyWord + ", searchKeyword=" + searchKeyword + ", sTitle="
				+ sTitle + ", pay=" + pay + ", content=" + content + "]";
	}

}

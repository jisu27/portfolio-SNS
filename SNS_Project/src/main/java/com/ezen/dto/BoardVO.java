package com.ezen.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class BoardVO {
	private int bSeq;
	private String title;
	private String id;
	private int pay;
	private String content;
	private String upload;
	private Date inDate;
	private MultipartFile uploadfile;
	private int count;
	private String keyWord;

	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public int getCount() {
		return count;
	}
	public int setCount(int count) {
		return this.count = count;
	}

	public MultipartFile getUploadfile() {
		return uploadfile;
	}

	public void setUploadfile(MultipartFile uploadfile) {
		this.uploadfile = uploadfile;
	}

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

	@Override
	public String toString() {
		return "BoardVO [bSeq=" + bSeq + ", title=" + title + ", id=" + id
				+ ", pay=" + pay + ", content=" + content + ", upload=" + upload
				+ ", inDate=" + inDate + ", uploadfile=" + uploadfile
				+ ", count=" + count + ", keyWord=" + keyWord + "]";
	}

}

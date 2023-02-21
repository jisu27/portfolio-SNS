package com.ezen.dto;

import java.util.Date;

public class CommentVO {
	private int cseq;
	private int bSeq;
	private int sSeq;
	private String id;
	private String ccontent;
	private Date indate;
	private int count;
	
	
	public int getsSeq() {
		return sSeq;
	}
	public void setsSeq(int sSeq) {
		this.sSeq = sSeq;
	}
	public int getCseq() {
		return cseq;
	}
	public void setCseq(int cseq) {
		this.cseq = cseq;
	}
	public int getBseq() {
		return bSeq;
	}
	public void setBseq(int bSeq) {
		this.bSeq = bSeq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCcontent() {
		return ccontent;
	}
	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}
	public Date getIndate() {
		return indate;
	}
	public void setIndate(Date indate) {
		this.indate = indate;
	}
	@Override
	public String toString() {
		return "CommentVO [cseq=" + cseq + ", bSeq=" + bSeq + ", sSeq=" + sSeq
				+ ", id=" + id + ", ccontent=" + ccontent + ", indate=" + indate
				+ ", count=" + count + "]";
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getbSeq() {
		return bSeq;
	}
	public void setbSeq(int bSeq) {
		this.bSeq = bSeq;
	}
	
	
	
}
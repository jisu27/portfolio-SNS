package com.ezen.dto;

import java.util.Date;

public class AdminVO {

	private int aSeq;
	private int bSeq;
	private int sSeq;
	private Date inDate;
	private String id;
	private int role;
	
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public int getaSeq() {
		return aSeq;
	}
	public void setaSeq(int aSeq) {
		this.aSeq = aSeq;
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
	public Date getinDate() {
		return inDate;
	}
	public void setinDate(Date inDate) {
		this.inDate = inDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "AdminVO [aSeq=" + aSeq + ", bSeq=" + bSeq + ", sSeq=" + sSeq
				+ ", inDate=" + inDate + ", id=" + id + ", role=" + role + "]";
	}
	
	
}

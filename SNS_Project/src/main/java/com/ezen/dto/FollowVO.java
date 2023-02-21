package com.ezen.dto;

public class FollowVO {
	int fSeq;
	String id1;
	String id2;

	public int getfSeq() {
		return fSeq;
	}

	public void setfSeq(int fSeq) {
		this.fSeq = fSeq;
	}

	public String getId1() {
		return id1;
	}

	public void setId1(String id1) {
		this.id1 = id1;
	}

	public String getId2() {
		return id2;
	}

	public void setId2(String id2) {
		this.id2 = id2;
	}

	@Override
	public String toString() {
		return "FollowVO [fSeq=" + fSeq + ", id1=" + id1 + ", id2=" + id2 + "]";
	}

}

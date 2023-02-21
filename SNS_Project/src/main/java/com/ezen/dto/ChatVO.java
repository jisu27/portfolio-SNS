package com.ezen.dto;

import java.util.Date;

public class ChatVO {
	private int chatSeq;
	private int chatRoomSeq;
	private String id1;
	private String id2;
	private String text;
	private Date chatInDate;

	public int getChatSeq() {
		return chatSeq;
	}

	public void setChatSeq(int chatSeq) {
		this.chatSeq = chatSeq;
	}

	public int getChatRoomSeq() {
		return chatRoomSeq;
	}

	public void setChatRoomSeq(int chatRoomSeq) {
		this.chatRoomSeq = chatRoomSeq;
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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getChatInDate() {
		return chatInDate;
	}

	public void setChatInDate(Date chatInDate) {
		this.chatInDate = chatInDate;
	}

	@Override
	public String toString() {
		return "ChatVO [chatSeq=" + chatSeq + ", chatRoomSeq=" + chatRoomSeq + ", id1=" + id1 + ", id2=" + id2
				+ ", text=" + text + ", chatInDate=" + chatInDate + "]";
	}

}

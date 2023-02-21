package com.ezen.dto;

import java.util.Date;

public class ChatRoomVO {
	private int chatRoomSeq;
	private int chatSeq;
	private String chatRoomTitle;
	private Date chatRoomInDate;

	public int getChatRoomSeq() {
		return chatRoomSeq;
	}

	public void setChatRoomSeq(int chatRoomSeq) {
		this.chatRoomSeq = chatRoomSeq;
	}

	public int getChatSeq() {
		return chatSeq;
	}

	public void setChatSeq(int chatSeq) {
		this.chatSeq = chatSeq;
	}

	public String getChatRoomTitle() {
		return chatRoomTitle;
	}

	public void setChatRoomTitle(String chatRoomTitle) {
		this.chatRoomTitle = chatRoomTitle;
	}

	public Date getChatRoomInDate() {
		return chatRoomInDate;
	}

	public void setChatRoomInDate(Date chatRoomInDate) {
		this.chatRoomInDate = chatRoomInDate;
	}

	@Override
	public String toString() {
		return "ChatRoomVO [chatRoomSeq=" + chatRoomSeq + ", chatSeq=" + chatSeq + ", chatRoomTitle=" + chatRoomTitle
				+ ", chatRoomInDate=" + chatRoomInDate + "]";
	}

}

package com.ezen.service;

import java.util.List;

import com.ezen.dto.ChatVO;

public interface ChatService {
	public void insertPrivateChat(ChatVO vo);
	public void insertRoomChat(ChatVO vo);
	public void deleteChat(ChatVO vo);
	public List<ChatVO> getPrivateChatList(ChatVO vo);
	public List<ChatVO> getRoomChatList(ChatVO vo);
	public ChatVO getChat(ChatVO vo);
}

package com.ezen.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ezen.dao.ChatDAO;
import com.ezen.dto.ChatVO;

@Service
public class ChatServiceImpl implements ChatService {
	ChatDAO cDAO;

	@Override
	public void insertPrivateChat(ChatVO vo) {
		cDAO.insertPrivateChat(vo);
	}

	@Override
	public void insertRoomChat(ChatVO vo) {
		cDAO.insertRoomChat(vo);
	}

	@Override
	public void deleteChat(ChatVO vo) {
		cDAO.deleteChat(vo);
	}

	@Override
	public List<ChatVO> getPrivateChatList(ChatVO vo) {
		return cDAO.getPrivateChatList(vo);
	}

	@Override
	public List<ChatVO> getRoomChatList(ChatVO vo) {
		return cDAO.getRoomChatList(vo);
	}

	@Override
	public ChatVO getChat(ChatVO vo) {
		return cDAO.getChat(vo);
	}

}

package com.ezen.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezen.dto.ChatVO;

@Repository
public class ChatDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	public void insertPrivateChat(ChatVO vo) {
		sqlSession.insert("chatMapper.insertPrivateChat", vo);
	}

	public void insertRoomChat(ChatVO vo) {
		sqlSession.insert("chatMapper.insertRoomChat", vo);
	}

	public void deleteChat(ChatVO vo) {
		sqlSession.delete("chatMapper.deleteChat", vo);
	}

	public List<ChatVO> getPrivateChatList(ChatVO vo) {
		return sqlSession.selectList("chatMapper.getPrivateChatList", vo);
	}

	public List<ChatVO> getRoomChatList(ChatVO vo) {
		return sqlSession.selectList("chatMapper.getRoomChatList", vo);
	}

	public List<ChatVO> getChatList(ChatVO vo) {
		return sqlSession.selectList("chatMapper.getChatList", vo);
	}
	
	public ChatVO getChat(ChatVO vo) {
		return sqlSession.selectOne("chatMapper.getChat", vo);
	}

	public int insertChat(ChatVO vo) {
		return sqlSession.insert("chatMapper.insertChat", vo);
	}
}
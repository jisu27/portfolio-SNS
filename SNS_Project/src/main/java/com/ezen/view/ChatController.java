package com.ezen.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ezen.dto.ChatVO;
import com.ezen.service.ChatService;

@Controller
public class ChatController {

	@Autowired
	private ChatService chatService;

	@RequestMapping(value = "/insertPrivateChat", method = RequestMethod.POST)
	public void insertPrivateChat(ChatVO vo) {
		chatService.insertPrivateChat(vo);
	}

	@RequestMapping(value = "/insertRoomChat", method = RequestMethod.POST)
	public void insertRoomChat(ChatVO vo) {
		chatService.insertRoomChat(vo);
	}

	@RequestMapping(value = "/deleteChat", method = RequestMethod.DELETE)
	public void deleteChat(ChatVO vo) {
		chatService.deleteChat(vo);
	}

	@RequestMapping(value = "/getPrivateChatList", method = RequestMethod.GET)
	public List<ChatVO> getPrivateChatList(ChatVO vo) {
		return chatService.getPrivateChatList(vo);
	}

	@RequestMapping(value = "/getRoomChatList", method = RequestMethod.GET)
	public List<ChatVO> getRoomChatList(ChatVO vo) {
		return chatService.getRoomChatList(vo);
	}

	@RequestMapping(value = "/getChat", method = RequestMethod.GET)
	public ChatVO getChat(ChatVO vo) {
		return chatService.getChat(vo);
	}
	
	@GetMapping(value="chat_room")
	public String testChat(ChatVO vo) {
		return "chat_room";
	}
	
	@GetMapping(value="direct_chat_box") 
	public String testChat2() {
		
		return "direct_chat_box";
	}
}
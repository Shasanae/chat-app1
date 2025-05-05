package com.example.chatapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.chatapp.dto.MessageDTO;
import com.example.chatapp.dto.UserDTO;
import com.example.chatapp.mapper.ConversationMapper;
import com.example.chatapp.mapper.Conversation_ParticipantMapper;
import com.example.chatapp.mapper.MessageMapper;
import com.example.chatapp.mapper.UserMapper;
import com.example.chatapp.model.Conversation;
import com.example.chatapp.model.ConversationExample;
import com.example.chatapp.model.Message;
import com.example.chatapp.model.MessageExample;
import com.example.chatapp.model.UserExample;
import com.example.chatapp.service.RandomID;


@RestController

public class ChatController{
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplatel;
	
	@Autowired
	private MessageMapper messageMapper;
	
	@Autowired
	private Conversation_ParticipantMapper conversation_ParticipantMapper;
	
	@MessageMapping("/chat")
	@SendTo("/topic/public")
	public MessageDTO chat(@Payload MessageDTO message) {
		return message;
	}
	
	
	@MessageMapping("/send")
	public void sendMessage(@Payload MessageDTO chatMessage) {
		 System.out.println("📩 Nhận yêu cầu lấy tin nhắn cho cuộc hội thoại: " + chatMessage.getConversationid());
		Message message = new Message();
		message.setId(RandomID.generateRandomId(12));
		message.setContent(chatMessage.getContent());
		message.setConversationid(chatMessage.getConversationid());
		message.setSenderid(chatMessage.getSenderid());
		message.setTimestamp(chatMessage.getTimestamp());
//		List<String> userIDs = conversation_ParticipantMapper.getUserIdsByConversationId(chatMessage.getConversationid());
//		userIDs.remove(chatMessage.getSenderid());
//		for(String userID : userIDs) {
			simpMessagingTemplatel.convertAndSend("/queue/messages/"+chatMessage.getConversationid(), message);
			messageMapper.insert(message);
		
		
	}
	
	@MessageMapping("/receive")
	public void receiveMessage(@Payload Conversation conversation) {
		 System.out.println("📩 Nhận yêu cầu lấy tin nhắn cho cuộc hội thoại: " + conversation.getId());
		MessageExample example = new MessageExample();
		example.createCriteria().andConversationidEqualTo(conversation.getId());
		List<Message> messageList = messageMapper.selectByExampleWithBLOBs(example);
		for (Message message : messageList) {
			 System.out.println("📤 Gửi tin nhắn: " + message.getContent() + " đến " + message.getSenderid());
			simpMessagingTemplatel.convertAndSend("/queue/messages/"+conversation.getId(), message);
		}
	}
	
	@GetMapping("/getMessage")
	public List<Message> getMessage(@RequestParam String conversationid) {
		MessageExample example = new MessageExample();
		example.createCriteria().andConversationidEqualTo(conversationid);
		List<Message> messageList = messageMapper.selectByExampleWithBLOBs(example);
		return messageList;
	}
	
	
	
	public void deleteMessage() {
		
	}
	
}

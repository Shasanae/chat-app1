package com.example.chatapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.chatapp.dto.Conversation_Participant_DTO;
import com.example.chatapp.mapper.ConversationMapper;
import com.example.chatapp.model.Conversation;
import com.example.chatapp.service.ConversationService;

@RestController

public class ConversationController {
	@Autowired
	private ConversationMapper conversationMapper;
	
	@Autowired
	private ConversationService ConversationService;

	@PostMapping("/addConversation")
	public void addConversation(@RequestBody Conversation_Participant_DTO conversation_Participant_DTO) {
		ConversationService.addConversation(conversation_Participant_DTO.getConversationDTO(), conversation_Participant_DTO.getUserIDs());
	}
	
	public void deleteConversation() {
		
	}
	@GetMapping("/getConversation")
	public List<Conversation> getAllConversation(@RequestParam String userID) {
		return conversationMapper.getConversationsByUserId(userID);
	}
}

package com.example.chatapp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chatapp.dto.ConversationDTO;
import com.example.chatapp.mapper.ConversationMapper;
import com.example.chatapp.mapper.Conversation_ParticipantMapper;
import com.example.chatapp.model.Conversation;

@Service

public class ConversationService {
	
	@Autowired
	private ConversationMapper conversationMapper;
	
	@Autowired
	private Conversation_ParticipantMapper conversation_ParticipantMapper;
	
	public void addConversation(ConversationDTO conversationDTO, List<String> userIds) {
		Conversation conversation = new Conversation();
		conversation.setId(RandomID.generateRandomId(12));
		conversation.setName(conversationDTO.getName());
		conversationMapper.insert(conversation);
		
		Map<String, Object> map = Map.of("conversationId", conversation.getId(), "userIds", userIds);
		
		conversation_ParticipantMapper.insertConversationParticipants(map);
		
	}
}

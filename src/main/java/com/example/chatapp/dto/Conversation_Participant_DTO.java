package com.example.chatapp.dto;

import java.util.List;

public class Conversation_Participant_DTO {

	ConversationDTO conversationDTO;
	List<String> userIds;
	
	public ConversationDTO getConversationDTO() {
		return conversationDTO;
	}
	public void setConversationDTO(ConversationDTO conversationDTO) {
		this.conversationDTO = conversationDTO;
	}
	public List<String> getUserIDs() {
		return userIds;
	}
	public void setUserIDs(List<String> userIDs) {
		this.userIds = userIDs;
	}
	
}

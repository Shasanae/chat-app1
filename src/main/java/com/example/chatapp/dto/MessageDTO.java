package com.example.chatapp.dto;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

public class MessageDTO {
	

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getSenderid() {
		return senderid;
	}
	public void setSenderid(String senderid) {
		this.senderid = senderid;
	}
	public String getConversationid() {
		return conversationid;
	}
	public void setConversationid(String conversationid) {
		this.conversationid = conversationid;
	}
	private String id;
	private String content;
	
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
//	private Date timestamp;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Ho_Chi_Minh")
	private Date timestamp;

	
	private String senderid;
	private String conversationid;
	
}
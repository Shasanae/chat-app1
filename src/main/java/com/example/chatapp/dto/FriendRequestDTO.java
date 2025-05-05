package com.example.chatapp.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FriendRequestDTO{
	private String id;
	private String sender;
	private String receiver;
	private String createat;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getCreateat() {
		return createat;
	}
	public void setCreateat(String createat) {
		this.createat = createat;
	}
	
	
}
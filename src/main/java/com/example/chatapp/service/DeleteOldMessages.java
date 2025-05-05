package com.example.chatapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.example.chatapp.mapper.MessageMapper;

public class DeleteOldMessages {
	@Autowired
	MessageMapper messageMapper;
	
	@Scheduled(cron = "0 0 0 * * ?")
	public void deleteOldMessages() {
		messageMapper.deleteOldMessages();
		
	}
}

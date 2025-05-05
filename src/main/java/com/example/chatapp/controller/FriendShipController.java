package com.example.chatapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.chatapp.dto.FriendRequestDTO;
import com.example.chatapp.mapper.FiendShipMapper;
import com.example.chatapp.mapper.FriendRequestMapper;
import com.example.chatapp.model.FriendShip;
import com.example.chatapp.model.FiendShipExample;
import com.example.chatapp.model.FriendRequest;
import com.example.chatapp.model.UserExample;
import com.example.chatapp.service.RandomID;
import com.example.chatapp.service.TimeUtils;

@RestController

public class FriendShipController {
	
	@Autowired
	private FriendRequestMapper friendRequestMapper;
	
	@Autowired
	private FiendShipMapper fiendShipMapper;
	
	@GetMapping("/getFriend")
	public List<FriendShip> getMethodName(@RequestParam String userId) {
		FiendShipExample example = new FiendShipExample();
		example.createCriteria().andUserEqualTo(userId);
		return fiendShipMapper.selectByExample(example);
	}

	@PostMapping("/friendRequest")
	public ResponseEntity<String> friendRequest(@RequestBody FriendRequestDTO request) {
	    try {
	        FriendRequest friendRequest = new FriendRequest();
	        friendRequest.setId(RandomID.generateRandomId(12));
	        friendRequest.setSender(request.getSender());
	        friendRequest.setReceiver(request.getReceiver());
	        friendRequest.setCreatedat(TimeUtils.getCurrentDate());
	        friendRequestMapper.insert(friendRequest);

	        return ResponseEntity.ok("Gửi lời mời kết bạn thành công.");
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("Gửi lời mời thất bại: " + e.getMessage());
	    }
	}

	@PostMapping("/deleteFriend")
	public void deleteFriend(@RequestBody FriendShip friendShip) {
		fiendShipMapper.deleteByPrimaryKey(friendShip.getId());
	}
	
	@PostMapping("/acceptRequest")
	public ResponseEntity<String> acceptFriend(@RequestBody FriendRequestDTO friendRequest) {
	    try {
	        FriendShip friendShip = new FriendShip();
	        friendShip.setId(friendRequest.getId());
	        friendShip.setUser(friendRequest.getReceiver());
	        friendShip.setFriend(friendRequest.getSender());
	        friendShip.setCreatedat(TimeUtils.getCurrentDate());
	        fiendShipMapper.insert(friendShip);
	        friendRequestMapper.deleteByPrimaryKey(friendRequest.getId());
	        return ResponseEntity.ok("Chấp nhận lời mời kết bạn thành công.");
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("Lỗi khi chấp nhận lời mời: " + e.getMessage());
	    }
	}

	
	@PostMapping("/refuseRequest")
	public void refuseFriend(@RequestBody FriendRequestDTO friendRequest) {
		friendRequestMapper.deleteByPrimaryKey(friendRequest.getId());
	}
}

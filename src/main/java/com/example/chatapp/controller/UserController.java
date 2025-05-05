package com.example.chatapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.chatapp.dto.UserDTO;
import com.example.chatapp.mapper.UserMapper;
import com.example.chatapp.model.User;
import com.example.chatapp.model.UserExample;

@RestController

public class UserController {

	@Autowired
	private UserMapper userMapper;
	
	@GetMapping("/getUser")
	public List<User> getUser(@RequestParam String email) {
		UserExample example = new UserExample();
		example.createCriteria().andEmailEqualTo(email);
		userMapper.selectByExample(example);
		System.out.println("success");
		return userMapper.selectByExample(example);
	}
	@GetMapping("/getUserList")
	public List<User> getUserList(@RequestParam String userid) {
		UserExample example = new UserExample();
		example.createCriteria().andUseridEqualTo(userid);
		userMapper.selectByExample(example);
		System.out.println("success");
		return userMapper.selectByExample(example);
	}
}

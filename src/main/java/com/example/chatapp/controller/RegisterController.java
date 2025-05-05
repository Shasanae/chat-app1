package com.example.chatapp.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.chatapp.dto.UserDTO;
import com.example.chatapp.mapper.UserMapper;
import com.example.chatapp.model.User;
import com.example.chatapp.service.RandomID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class RegisterController {
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@PostMapping("/register")
	public ResponseEntity<?> processRegiste(@RequestBody UserDTO user1) {
		// TODO: process POST request

	    try {
	    	Date sqlDate1 = null;
            if (user1.getDateofbirth() != null ) {
                java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(user1.getDateofbirth());
                sqlDate1 = new Date(utilDate.getTime());
            }
	        
	        User user = new User();
			System.out.println("register successfull " + user);
			user.setUserid(RandomID.generateRandomId(12));
			user.setFullname(user1.getFullname());
			user.setEmail(user1.getEmail());
			user.setPhone(user1.getPhone());
			user.setDateofbirth(sqlDate1);
			user.setPassword(passwordEncoder.encode(user1.getPassword()));
			user.setIsactive(true);

			userMapper.insert(user);
			System.out.println("register successfull " + user);

			return ResponseEntity.ok("register successfull!");
	    } catch (ParseException e) {
	        return ResponseEntity.badRequest().body("register false");
	    }
	}

}

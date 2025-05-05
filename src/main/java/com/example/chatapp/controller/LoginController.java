//package com.example.chatapp.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.chatapp.model.User;
//
//@RestController
//
//public class LoginController {
//	@Autowired
//	AuthenticationManager authenticationManager;
//
//	@PostMapping("/login")
//	public ResponseEntity<?> loginResponse(@RequestBody User user) {
//		try {
//			org.springframework.security.core.Authentication authentication = authenticationManager
//					.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
//
//			SecurityContextHolder.getContext().setAuthentication(authentication);
//			return ResponseEntity.ok("login successfull!");
//		} catch (AuthenticationException e) {
//			// TODO Auto-generated catch block
//			return ResponseEntity.status(402).body("login false");
//		}
//
//	}
//}

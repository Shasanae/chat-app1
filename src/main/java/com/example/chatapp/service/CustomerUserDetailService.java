package com.example.chatapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.chatapp.mapper.UserMapper;
import com.example.chatapp.model.User;
import com.example.chatapp.model.UserExample;

@Service
public class CustomerUserDetailService implements UserDetailsService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserExample example = new UserExample();
		example.createCriteria().andEmailEqualTo(email);
		List<User> userList = userMapper.selectByExample(example);

		if (userList.size() > 0) {
			User user = userList.get(0);
			System.out.println(user.getEmail());
//			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//			SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ADMIN");
//			authorities.add(authority);
			UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
					.username(user.getEmail())
					.password(user.getPassword())
					.roles("USER")
					.build();
					
			return userDetails;
		} else {
			throw new UsernameNotFoundException("User not found with email: " + email);
		}

	}

}

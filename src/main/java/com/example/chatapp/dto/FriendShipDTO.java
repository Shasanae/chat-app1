package com.example.chatapp.dto;

public class FriendShipDTO {
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public UserDTO getUser() {
		return UserDTO;
	}
	public void setUser(UserDTO UserDTO) {
		this.UserDTO = UserDTO;
	}
	public UserDTO getFriend() {
		return friend;
	}
	public void setFriend(UserDTO friend) {
		this.friend = friend;
	}
	private UserDTO UserDTO;
	private UserDTO friend;
}
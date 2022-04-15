package com.brainmentors.chatapp.dto;

public class UserDTO {
	private String userId;
	private char[] password;
	private String email;
	private String city;
	private String phone;
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	
	public UserDTO(String userId, char[] password, String email , String city , String phone){
		this.userId = userId;
		this.password = password;
		this.email = email;
		this.city = city;
		this.phone = phone;
		
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}
}

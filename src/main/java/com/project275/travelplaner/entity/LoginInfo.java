package com.project275.travelplaner.entity;

import lombok.Data;

@Data
public class LoginInfo {
    private String email;
    private String password;
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
}

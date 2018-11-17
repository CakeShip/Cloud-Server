package com.healthcare.demo.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter

public class LoginModel {
	private String username;
	private String password;

	public LoginModel(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

}

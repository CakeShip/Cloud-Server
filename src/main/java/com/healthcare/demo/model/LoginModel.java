package com.healthcare.demo.model;

import lombok.Getter;
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

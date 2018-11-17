package com.healthcare.demo.service;

import java.util.List;

import com.healthcare.demo.model.*;

public interface UserService {
	
	public User getPersonInfo(User UserModel);	
	public List<User> getAll();
	public void registerPerson(User UserModel);
	public User getPersonByUsernamePassword(String username,String password);
}

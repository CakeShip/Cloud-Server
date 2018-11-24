package com.healthcare.demo.service;

import java.util.List;

import com.healthcare.demo.model.User;

public interface UserService {

	public List<User> getAll();
	public void registerPerson(User UserModel);
	public User getPersonByUsernamePassword(String username, String pass);
	public User getPersonById(int id);
	public void deleteUser(int id);
	public void restoreUser(int id);
	public User updatePersonById(int id, User model);
	public List<User> findPersonByName(String name);
}

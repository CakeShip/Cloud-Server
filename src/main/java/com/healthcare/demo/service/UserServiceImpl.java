package com.healthcare.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.demo.model.*;
import com.healthcare.demo.repository.*;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	

	@Override
	@Transactional(rollbackOn = Exception.class)
	public User getPersonByUsernamePassword(String username,String password){
		User user =  userRepository.findUserByUsernamePassword(username,password);
		return user;
	}

	@Override
	public List<User> getAll() {
		List<User> list = new ArrayList<>();
		userRepository.findAll().iterator().forEachRemaining(list::add);
		return list;
	}
	
	@Override
	public void registerPerson(User UserModel) {
		userRepository.save(UserModel);
	}

	@Override
	public void deleteUser(int id){
		userRepository.deleteUserById(id);
	}

	@Override
	public User getPersonById(int id){
		return userRepository.findPersonById(id); 
	}
	
	@Override
	public User updatePersonById(int id, User update_user){
		return userRepository.updatePersonDetailsById(id, update_user); 
	}

	@Override
	public User findPersonByName(String name){
		return userRepository.findPersonDetailsByName(name);
	}
}

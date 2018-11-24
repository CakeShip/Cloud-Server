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
	private User dummyModel;

	@Autowired
	private UserRepository userRepository;
	

	@Override
	@Transactional(rollbackOn = Exception.class)
	public User getPersonByUsernamePassword(String username, String pass){
		return userRepository.findByUsernameAndPassword(username, pass);
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
		User model = userRepository.findById(id);
		model.setIsArchived(true);
		userRepository.save(model);
	}

	@Override
	public void restoreUser(int id){
		User model = userRepository.findById(id);
		model.setIsArchived(false);
		userRepository.save(model);
	}

	@Override
	public User getPersonById(int id){
		return userRepository.findById(id); 
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public Integer updatePersonById(int id, User model){
		return userRepository.updatePersonDetailsById(id, model);
	}

	@Override
	public List<User> findPersonByName(String name){
		String firstname, lastname;
		firstname=lastname=name;
		return userRepository.findByFirstNameOrLastName(firstname, lastname);
	}
}

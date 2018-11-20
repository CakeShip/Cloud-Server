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

	@Autowired // This means to get the bean called userRepository
	// Which is auto-generated by Spring, we will use it to handle the data
	private UserRepository userRepository;

	@Autowired
	private  UserAbilityRepository userAbilityRepository;
	
	// @Override
	// public User getPersonInfo(User UserModel) {
	// 	return userRepository.findById(UserModel.getId()).get();
	// }

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

	/* (non-Javadoc)
	 * @see com.rococo.springboot.service.UserService#registerPerson(com.rococo.springboot.model.User)
	 */
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

}

package com.healthcare.demo.controller;

import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.demo.model.*;
import com.healthcare.demo.service.UserServiceImpl;
import com.healthcare.demo.service.EncryptFiles;

@RestController
@RequestMapping("/users")
@CrossOrigin(value = "http://localhost:4200/")
public class HomeController {

	@Autowired
	private UserServiceImpl userService;

	@GetMapping
	public String home() {
		return "forward:/index.html";
	}

	@PostMapping("/login")
	public @ResponseBody User login(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		try{
			EncryptFiles enc = new EncryptFiles();
			String encrypted=enc.encrypt(password);
			password = encrypted;
		}catch(Exception e){
			e.printStackTrace();
		}
		return userService.getPersonByUsernamePassword(username, password);
	}

	@PostMapping("/authenticate")
	public @ResponseBody User authenticate(@RequestBody LoginModel loginCredentials) {
		try{
			EncryptFiles enc = new EncryptFiles();
			String encrypted=enc.encrypt(loginCredentials.getPassword());
			loginCredentials.setPassword(encrypted);
		}catch(Exception e){
			e.printStackTrace();
		}
		return userService.getPersonByUsernamePassword(loginCredentials.getUsername(), loginCredentials.getPassword());

	}

	@PostMapping(value = "/register/{type}")
	public @ResponseBody String register(@RequestBody User person, @PathVariable String type) {
		try{
			EncryptFiles enc = new EncryptFiles();
			String encrypted=enc.encrypt(person.getPassword());
			person.setPassword(encrypted);
		}catch(Exception e){
			e.printStackTrace();
		}
		if("admin".equals(type.toString())){
		    person.setUsertype("admin");
		}else{
			person.setUsertype("doctor");
		} 
		person.setIsArchived(false);
		userService.registerPerson(person);
		return type;
	}

	@GetMapping(path = "/getAll")
	public @ResponseBody List<User> getAllUsers() {
		return userService.getAll();
	}

	@GetMapping(path = "/getAll/{type}")
	public @ResponseBody List<User> getAllUserType(@PathVariable String type) {
		return userService.getAllUserType(type);
	}

	@PostMapping(path = "/delete")
	public @ResponseBody String delete(@RequestParam('id') int id) {
		userService.deleteUser(id);
		return "deleted";
	}

	@PostMapping(path = "/restore")
	public @ResponseBody String restore(@RequestParam('id') int id) {
		userService.restoreUser(id);
		return "Re-created";
	}

	@GetMapping(path = "/{id}")
	public @ResponseBody User getDetailById(@PathVariable int id) {
		return userService.getPersonById(id);
	}

	@PostMapping(path = "/update")
	public @ResponseBody Integer update(@RequestBody User person, @RequestParam("id") int id) {
		return userService.updatePersonById(id, person);
	}

	@GetMapping(path = "/search/{name}")
	public @ResponseBody List<User> update(@PathVariable String name) {
		return userService.findPersonByName(name);
	}

}

package com.healthcare.demo.controller;

import java.util.List;

import javax.validation.Valid;

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
		return userService.getPersonByUsernamePassword(username, password);

	}

	@PostMapping("/authenticate")
	public @ResponseBody User authenticate(@RequestBody LoginModel loginCredentials) {
		return userService.getPersonByUsernamePassword(loginCredentials.getUsername(), loginCredentials.getPassword());

	}

	@PostMapping(value = "/register")
	public @ResponseBody String register(@RequestBody User person) {
		person.setIsArchived(false);
		person.setUsertype("Admin");
		userService.registerPerson(person);
		return "Saved";
	}

	//
	@GetMapping(path = "/getAll")
	public @ResponseBody List<User> getAllUsers() {
		return userService.getAll();
	}

}

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

import com.healthcare.demo.model.LoginModel;
import com.healthcare.demo.model.User;
import com.healthcare.demo.service.UserServiceImpl;

@RestController
@RequestMapping("/users")
@CrossOrigin(value = "http://localhost:4200/")
public class HomeController {

	@Autowired // This means to get the bean called userRepository
	// Which is auto-generated by Spring, we will use it to handle the data
	private UserServiceImpl userService;

	@GetMapping
	public String home() {
		return "forward:/index.html";
	}

	@PostMapping("/login") // Map ONLY POST Requests
	public @ResponseBody User login(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		return userService.getPersonByUsernamePassword(username, password);

	}

	@PostMapping("/authenticate") // Map ONLY POST Requests
	public @ResponseBody User authenticate(@RequestBody LoginModel loginCredentials) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		return userService.getPersonByUsernamePassword(loginCredentials.getUsername(), loginCredentials.getPassword());

	}

	@PostMapping(value = "/register") // Map ONLY POST Requests
	public @ResponseBody String register( @RequestBody User person) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		person.setIsArchived(false);
		userService.registerPerson(person);
		return "Saved";
	}
//
	@GetMapping(path = "/getAll")
	public @ResponseBody List<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userService.getAll();
	}

}

package com.manish.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class TestController {
	
	@Autowired
	TestService service;
	
	@PostMapping("/add-user")
	String newUser(@RequestBody User user) {
		return service.newUser(user);
	}
		
	@RequestMapping("/user-count")
	Integer getCountOfUsers() {
		return service.getCountOfUser(); 
	}
	
	@RequestMapping("/user-name/{id}")
	String getUserName(@PathVariable Integer id) {
		return service.getUserName(id);
	}
	
	@RequestMapping("/user-details/{id}")
	List<User> getUserDetails(@PathVariable Integer id) {
		return service.getUserDetails(id);
	}
	
	@RequestMapping("/user-details")
	List<User> getAllUsers() {
		return service.getAllUsers();
	}
	
	@PutMapping("/user-details/update/{id}")
	String updateUserDetails(@PathVariable Integer id,@RequestBody User user) {
		return service.updateUserDetails(id, user);
	}
	
	@DeleteMapping("/remove-user/{id}")
	String deleteUser(@PathVariable Integer id) {
		return service.deleteUser(id);
	}
	
	
}

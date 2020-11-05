package com.cognixia.ecommerce.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.ecommerce.models.User;
import com.cognixia.ecommerce.services.UserService;

@RestController
public class UserController {
	
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Integer id) {
		return new ResponseEntity<User>(userService.getUserById(id), HttpStatus.OK);
	}
	
	@PostMapping("/users")
	public ResponseEntity<String> addNewUser(@RequestBody String email,
											 @RequestBody String password,
											 @RequestBody String role) {
		userService.addUser(new User(email, password, role));
		return new ResponseEntity<String>("User added", HttpStatus.OK);
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<String> updateUser(@PathVariable Integer id,
											 @RequestBody String email,
											 @RequestBody String password,
											 @RequestBody String role) {
		userService.updateUser(id, new User(email, password, role));
		return new ResponseEntity<String>("User updated", HttpStatus.OK);
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
		userService.deleteUser(id);
		return new ResponseEntity<String>("User deleted", HttpStatus.OK);
	}

}

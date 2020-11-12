package com.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecommerce.beans.User;
import com.ecommerce.services.UserServiceImpl;

@Controller
public class UserController {
	
	@Autowired
	UserServiceImpl service;
	
	@GetMapping("/user/all")
	public String getAllUsers(Model m) {
		List<User> users = service.getAllUsers();
		m.addAttribute("userList", users);
		return "Link to user list page";
	}
	
	@GetMapping("/user/{id}")
	public String getUser(@PathVariable int id, Model m) {
		User u = service.getUser(id);
		m.addAttribute("user", u);
		return "Link to user page???";
	}
	
	
	

}

package com.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ecommerce.services.UserServiceImpl;

@Controller
public class UserController {
	
	@Autowired
	UserServiceImpl service;
	
	

}

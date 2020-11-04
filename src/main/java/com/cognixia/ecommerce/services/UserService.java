package com.cognixia.ecommerce.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognixia.ecommerce.models.User;
import com.cognixia.ecommerce.repositories.UserRepository;

@Service("userService")
public class UserService {

	private UserRepository userRepo;
	
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
}

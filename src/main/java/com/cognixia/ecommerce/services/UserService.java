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
	
	public User getUserById(Integer id) {
		return userRepo.findById(id).get();
	}
	
	public void addUser(User user) {
		userRepo.save(user);
	}
	
	public void updateUser(Integer id, User user) {
		User updatingUser = getUserById(id);
		updatingUser = user;
		userRepo.save(updatingUser);
	}
	
	public void deleteUser(Integer id) {
		userRepo.deleteById(id);
	}
}

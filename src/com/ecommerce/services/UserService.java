package com.ecommerce.services;

import java.util.List;

import com.ecommerce.beans.Address;
import com.ecommerce.beans.User;

public interface UserService {
	
	public List<User> getAllUsers();
	public User getUser(int id);
	public User getUser(String email);
	public User addUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUser(int id);
	public boolean userExists(int id);
	
	public Address getAddress(int id);
	public Address editAddress(Address address);
}

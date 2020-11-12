package com.ecommerce.dao;

import java.util.List;

import com.ecommerce.beans.User;

public interface UserDao {

	public List<User> getAllUsers();
	public User getUser(int userId);
	public User getUser(String email);
	public boolean userExists(int id);
	public User addUser(User user);
	public boolean editUser(User user);
	public boolean deleteUser(User user);
}

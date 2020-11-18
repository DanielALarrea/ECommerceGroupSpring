package com.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.beans.Address;
import com.ecommerce.beans.User;
import com.ecommerce.dao.AddressDaoImpl;
import com.ecommerce.dao.UserDaoImpl;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDaoImpl userDB;
	
	@Autowired
	AddressDaoImpl addressDB;

	@Override
	public List<User> getAllUsers() {
		return userDB.getAllUsers();
	}

	@Override
	public User getUser(int id) {
		return userDB.getUser(id);
	}

	@Override
	public User getUser(String email) {
		return userDB.getUser(email);
	}

	@Override
	public User addUser(User user) {
		return userDB.addUser(user);
	}

	@Override
	public boolean updateUser(User user, String attribute) {
		return userDB.editUser(user, attribute);
	}

	@Override
	public boolean deleteUser(int id) {
		return userDB.deleteUser(id);
	}

	@Override
	public boolean userExists(int id) {
		return userDB.userExists(id);
	}

	@Override
	public Address getAddress(int id) {
		return addressDB.getAddress(id);
	}

	@Override
	public Address getAddress(String street, String zip) {
		return addressDB.getByStreetAndZipcode(street, zip);
	}
	
	@Override
	public Address addAddress(Address address) {
		return addressDB.createAddress(address);
	}

}

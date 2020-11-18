package com.ecommerce.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ecommerce.beans.Address;
import com.ecommerce.beans.User;
import com.ecommerce.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	private String viewUserPage = "test/viewuser";
	private String editUserPage = "test/edituser";
	private String addUserPage = "test/adduser";
	private String redirectToView = "redirect:/viewuser";
	
	private String registerPage = "test/registration";
	
	@GetMapping("/viewuser")
	public String getAllUsers(Model m) {
		List<User> users = service.getAllUsers();
		m.addAttribute("list", users);
		return viewUserPage;
	}
	
	@GetMapping("/viewuser/{id}")
	public String getUser(@PathVariable int id, Model m) {
		User u = service.getUser(id);
		m.addAttribute("command", u);
		return viewUserPage;
	}
	
	@GetMapping("/adduser")
	public String addUserForm(Model m) {
		m.addAttribute("command", new User());
		return addUserPage;
	}
	
	@PostMapping("/adduser")
	public String addUser(@ModelAttribute("user") User user) {
		if(service.getAddress(user.getBillingAddress().getStreet(), user.getBillingAddress().getZipCode()) == null) {
			user.setBillingAddress(service.addAddress(new Address(-1, user.getBillingAddress().getStreet(), user.getBillingAddress().getCity(), user.getBillingAddress().getState(), user.getBillingAddress().getZipCode())));
		} else {
			user.setBillingAddress(service.getAddress(user.getBillingAddress().getStreet(), user.getBillingAddress().getZipCode()));
		}
		//temporary
		user.setUserRole(User.ROLE.CUSTOMER);
		service.addUser(user);
		return redirectToView;
	}
	
	@GetMapping("/edituser/{id}")
	public String editUserForm(@PathVariable int id, Model m) {
		User user = service.getUser(id);
		m.addAttribute("command", user);
		return editUserPage;
	}
	
	@PostMapping("/edituser")
	public String editUser(@ModelAttribute("user") User user) {
		service.updateUser(user, "username");
		service.updateUser(user, "password");
		service.updateUser(user, "first_name");
		service.updateUser(user, "last_name");
		service.updateUser(user, "email");
		service.updateUser(user, "phone_number");
		if(service.getAddress(user.getBillingAddress().getStreet(), user.getBillingAddress().getZipCode()) == null) {
			user.setBillingAddress(service.addAddress(new Address(-1, user.getBillingAddress().getStreet(), user.getBillingAddress().getCity(), user.getBillingAddress().getState(), user.getBillingAddress().getZipCode())));
		} else {
			user.setBillingAddress(service.getAddress(user.getBillingAddress().getStreet(), user.getBillingAddress().getZipCode()));
		}
		service.updateUser(user, "address_id");
		return redirectToView;
	}
	
	@GetMapping("/deleteuser/{id}")    
    public String deleteUser(@PathVariable int id){
		service.deleteUser(id);
        return redirectToView;    
    }

}

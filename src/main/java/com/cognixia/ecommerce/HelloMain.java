package com.cognixia.ecommerce;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognixia.ecommerce.services.HelloWorldService;
import com.cognixia.ecommerce.services.UserService;

public class HelloMain {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		HelloWorldService service = (HelloWorldService) context.getBean("helloWorldService");
		service.sayHello();
		
		service.setName("Spring");
		service.sayHello();
		
		UserService userServe = (UserService) context.getBean("userService");
		userServe.getAllUsers();
		System.out.println(userServe.getAllUsers());
	}

}

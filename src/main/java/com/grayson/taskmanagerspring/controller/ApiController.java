package com.grayson.taskmanagerspring.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grayson.taskmanagerspring.model.User;
import com.grayson.taskmanagerspring.repository.UserRepository;

@RestController
public class ApiController {

	@Autowired
	UserRepository userRepo;
	
	@RequestMapping(value="/api/insertUser", produces="application/json")
	public Object getDate() {
		
		User user = new User();
		user.setId(1);
		user.setName("Grayson");
		
		userRepo.save(user);
		
		return user;
	}
	
	
	
	
}

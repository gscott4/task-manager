package com.grayson.taskmanagerspring.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grayson.taskmanagerspring.model.Task;
import com.grayson.taskmanagerspring.model.User;
import com.grayson.taskmanagerspring.repository.TaskRepository;
import com.grayson.taskmanagerspring.repository.UserRepository;

@RestController
public class ApiController {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	TaskRepository taskRepo;
	
	@RequestMapping(value="/api/getUserName", produces="application/json")
	public Object getName(Principal principal) {
		
		User user = new User();
		user.setId(1);
		user.setName("Grayson");
		
		userRepo.save(user);
		
		return user;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/insertTask", produces="application/json")
	public Object addTask(Principal principal, @RequestParam("task") String task) {
		taskRepo.save(new Task(task, principal.getName()));
		return "{\"Message\":\"Success\"}";
	}
	
	@RequestMapping(value="/getTasks", produces="application/json")
	public List<Task> getTasks(Principal principal) {
		return taskRepo.getTasksByHolderName(principal.getName());
	}
}

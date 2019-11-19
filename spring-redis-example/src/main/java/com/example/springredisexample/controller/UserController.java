package com.example.springredisexample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springredisexample.model.User;
import com.example.springredisexample.repo.UserRepo;

@RestController
@RequestMapping("/rest/user")
public class UserController {
	private UserRepo repo;
	public UserController(UserRepo repo) {
		this.repo = repo;
	}
	@GetMapping("/add")
	public Object add(@PathVariable("id") final String id,@PathVariable("name") final String name) {
		repo.save(new User(id,name));
		return 1;
		
	}

}

package com.example.springredisexample.repo;

import java.util.List;
import java.util.Map;

import com.example.springredisexample.model.User;

public interface UserRepo {
	void save(User user);
	Map<String, User> findAll();
	void update(User user);
	void delete(String id);
	User findById(String id);

}

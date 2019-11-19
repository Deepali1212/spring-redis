package com.example.springredisexample.queries;

import java.util.List;
import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.springredisexample.model.User;
import com.example.springredisexample.repo.UserRepo;

@Repository
public class UserQueries implements UserRepo {
	private RedisTemplate<String,User> redisTemplate;
	private HashOperations hashOperations;
	public UserQueries(RedisTemplate<String,User> redisTemplate) {
		this.redisTemplate = redisTemplate;
		hashOperations = redisTemplate.opsForHash();
	}
	@Override
	public void save(User user) {
		hashOperations.put("USER", user.getId(), user);
	}
	@Override
	public Map<String,User> findAll(){
		return hashOperations.entries("USER");
	}
	@Override
	public User findById(String id) {
		return (User) hashOperations.get("USER", id);

	}
	@Override
	public void update(User user) {
		hashOperations.put("USER", user.getId(), user);

		
	}
	@Override
	public void delete(String id) {
		hashOperations.delete("USER", id);

		
	}

}

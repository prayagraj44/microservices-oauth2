package com.prayag.service;

import java.util.List;
import java.util.Optional;

import com.prayag.entity.User;


public interface UserDataService {
	
	public List<User> retrieveAllUsers();
	
	public Optional<User> retrieveUserById(Integer id);
	
	public User createUser(User user);
	
	public void deleteUser(Integer id);	

}

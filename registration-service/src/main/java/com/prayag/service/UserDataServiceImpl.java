package com.prayag.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prayag.entity.User;
import com.prayag.repo.UserRegistrationRepo;


@Service
public class UserDataServiceImpl implements UserDataService {
	
	@Autowired 
	UserRegistrationRepo userRepo;

	@Override
	public List<User> retrieveAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public  Optional<User> retrieveUserById(Integer id) {
		return userRepo.findById(id);
	}

	@Override
	public User createUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public void deleteUser(Integer id) {
		  userRepo.deleteById(id);
	}

	public void(String emailAddress){
		
	}

}

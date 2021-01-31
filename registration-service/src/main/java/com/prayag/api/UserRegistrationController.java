package com.prayag.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prayag.entity.User;
import com.prayag.service.UserDataService;

@RestController
@RequestMapping("api/")
public class UserRegistrationController {

	@Autowired
	UserDataService userdataService;

	@GetMapping("/users")
	@PreAuthorize("#oauth2.hasScope('read')")
	public ResponseEntity<List<User>> retrieveAllUsers() {
		if (userdataService.retrieveAllUsers().isEmpty())
			createDummyUser();
		System.out.println("getting all users " + userdataService.retrieveAllUsers());
		List<User> userList = userdataService.retrieveAllUsers();
		ResponseEntity<List<User>> response = null;
		if (userList != null) {
			response = new ResponseEntity<>(userList, HttpStatus.OK);
		}

		return response;
	}

	@GetMapping("/user/{id}")
	public User retrieveUser(@PathVariable Integer id) {

		Optional<User> user = userdataService.retrieveUserById(id);

		if (!user.isPresent()) {
			throw new RuntimeException("User does not exsist");
		}
		return user.get();
	}

	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		return userdataService.createUser(user);
	}

	@DeleteMapping("/users/id")
	public void deleteUser(@PathVariable Integer id) {
		userdataService.deleteUser(id);
	}

	private boolean createDummyUser() {

		System.out.println("--->No user present creating one for demo");
		userdataService.createUser(
				new User("prayagraj", "prayagraj44@gmail.com", "kolarRoad Bhopal MP", "s3://pics/prayag-pic.jpg"));
		return true;

	}

}

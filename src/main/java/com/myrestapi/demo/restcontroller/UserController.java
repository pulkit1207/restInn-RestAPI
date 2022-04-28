package com.myrestapi.demo.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myrestapi.demo.entity.UserModel;
import com.myrestapi.demo.service.UserService;

@CrossOrigin(origins = "https://restinn-stays.netlify.app")
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	// Getting All Users
	@GetMapping("/users")
	public ResponseEntity<List<UserModel>> getUsers() {
		return new ResponseEntity<List<UserModel>>(userService.getUsers(), HttpStatus.OK);
	}

	// Getting user by id
	@GetMapping("/users/{userId}")
	public ResponseEntity<UserModel> getAUser(@PathVariable String userId) {
		if (null != userService.getAUser(userId)) {
			return new ResponseEntity<UserModel>(userService.getAUser(userId), HttpStatus.OK);
		} else {
			return new ResponseEntity<UserModel>(new UserModel(), HttpStatus.NOT_FOUND);
		}
	}

	// Creating a User
	@PostMapping("/users")
	public ResponseEntity<UserModel> createUser(@RequestBody UserModel user) {
		return new ResponseEntity<UserModel>(userService.addUser(user), HttpStatus.CREATED);
	}

	// Get User by email
	@GetMapping("/users/email/{email}")
	public ResponseEntity<UserModel> getAUserByEmail(@PathVariable String email) {
		return new ResponseEntity<UserModel>(userService.getAUserByEmailId(email), HttpStatus.OK);
	}

}

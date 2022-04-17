package com.myrestapi.demo.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myrestapi.demo.entity.UserModel;
import com.myrestapi.demo.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public ResponseEntity<List<UserModel>> getUsers() {
		return new ResponseEntity<List<UserModel>>(userService.getUsers(), HttpStatus.OK);
	}

	@GetMapping("/users/{userId}")
	public ResponseEntity<UserModel> getAUser(@PathVariable String userId) {
		if (null != userService.getAUser(userId)) {
			return new ResponseEntity<UserModel>(userService.getAUser(userId), HttpStatus.OK);
		} else {
			return new ResponseEntity<UserModel>(new UserModel(), HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/users")
	public ResponseEntity<UserModel> createUser(@RequestBody UserModel user) {
		return new ResponseEntity<UserModel>(userService.addUser(user), HttpStatus.CREATED);
	}

}
package com.myrestapi.demo.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myrestapi.demo.entity.UserModel;

@CrossOrigin(origins = "https://restinn-stays.netlify.app")
@RestController
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/auth")
	public ResponseEntity login(@RequestBody UserModel user) {

		try {
			authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
			return new ResponseEntity("Logged in sucessfully", HttpStatus.OK);

		} catch (BadCredentialsException ex) {
			return new ResponseEntity("Email and/or password were not entered correctly", HttpStatus.UNAUTHORIZED);
		}

	}
}

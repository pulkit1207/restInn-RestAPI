package com.myrestapi.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.myrestapi.demo.entity.UserModel;
import com.myrestapi.demo.repository.UserDao;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public List<UserModel> getUsers() {
		return userDao.findAll();
	}

	public UserModel getAUser(String id) {
		Optional<UserModel> user = userDao.findById(id);
		if (user.isPresent()) {
			return user.get();
		} else {
			return null;
		}
	}

	public UserModel addUser(UserModel user) {
		String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		UserModel insertedUser = userDao.insert(user);
		return insertedUser;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserModel foundUser = userDao.findByEmail(email);
		String userEmail = foundUser.getEmail();
		String password = foundUser.getPassword();
		return new User(userEmail, password, new ArrayList<>());
	}

	public UserModel getAUserByEmailId(String email) {
		return userDao.findByEmail(email);
	}

}

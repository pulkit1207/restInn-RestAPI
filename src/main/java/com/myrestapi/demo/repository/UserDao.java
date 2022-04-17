package com.myrestapi.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.myrestapi.demo.entity.UserModel;

@Repository
public interface UserDao extends MongoRepository<UserModel, String> {

	UserModel findByEmail(String email);

}

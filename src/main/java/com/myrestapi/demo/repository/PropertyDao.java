package com.myrestapi.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.myrestapi.demo.entity.Property;

@Repository
public interface PropertyDao extends MongoRepository<Property, String> {

	List<Property> findByBestSeller(Boolean bestSeller);
	
	List<Property> findByTitleOrType(String title, String type);

	List<Property> findByType(String type);
	
	List<Property> findByFeaturedIsTrue();
}

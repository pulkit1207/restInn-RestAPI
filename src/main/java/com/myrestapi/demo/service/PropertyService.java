package com.myrestapi.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.myrestapi.demo.entity.Property;
import com.myrestapi.demo.repository.PropertyDao;

@Service
public class PropertyService {

	@Autowired
	PropertyDao propertyDao;

	public List<Property> getProperties() {
		return propertyDao.findAll();
	}

	public Property getAProperty(String propertyId) {
		Optional<Property> property = propertyDao.findById(propertyId);
		if (property.isPresent()) {
			return property.get();
		} else {
			return null;
		}
	}

	public Property createProperty(Property property) {
		return propertyDao.save(property);
	}

	public Property updateProperty(Property property) {
		return propertyDao.save(property);
	}

	public void deleteProperty(String propertyId) {
		propertyDao.deleteById(propertyId);
	}

	public List<Property> getByBestSeller(Boolean bestSeller) {
		return propertyDao.findByBestSeller(bestSeller);
	}
	
	public List<Property> getPropertiesByType(String title, String type) {
		return propertyDao.findByTitleOrType(title, type);
	}

}

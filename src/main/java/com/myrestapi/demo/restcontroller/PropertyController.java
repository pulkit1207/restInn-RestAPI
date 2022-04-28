package com.myrestapi.demo.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myrestapi.demo.entity.Property;
import com.myrestapi.demo.service.PropertyService;

@CrossOrigin(origins = "https://626ab264c2944e2bda5e587c--astonishing-pegasus-f47bd3.netlify.app")
@RestController
public class PropertyController {

	@Autowired
	private PropertyService propertyService;

	// Get all Properties
	@GetMapping("/properties")
	public List<Property> getAllProperties() {
		return propertyService.getProperties();
	}

	// Get Property By Id
	@GetMapping("/properties/{propertyId}")
	public ResponseEntity<Property> getProperty(@PathVariable String propertyId) {
		if (null != propertyService.getAProperty(propertyId)) {
			return new ResponseEntity<Property>(propertyService.getAProperty(propertyId), HttpStatus.OK);
		} else {
			return new ResponseEntity<Property>(new Property(), HttpStatus.NOT_FOUND);
		}
	}

	// Creating new Property
	@PostMapping("/properties")
	public ResponseEntity<Property> addProperty(@RequestBody Property property) {
		return new ResponseEntity<Property>(propertyService.createProperty(property), HttpStatus.CREATED);
	}

	// Update the Property
	@PutMapping("/properties/{propertyId}")
	public ResponseEntity<Property> updateProperty(@RequestBody Property property, @PathVariable String propertyId) {
		property.setId(propertyId);
		if (null != propertyService.getAProperty(propertyId)) {
			return new ResponseEntity<Property>(propertyService.createProperty(property), HttpStatus.OK);
		} else {
			return new ResponseEntity<Property>(propertyService.createProperty(property), HttpStatus.CREATED);
		}
	}

	// Deleting a Property
	@DeleteMapping("/properties/{propertyId}")
	public ResponseEntity<String> deleteProperty(@PathVariable String propertyId) {
		if (propertyService.getAProperty(propertyId) != null) {
			propertyService.deleteProperty(propertyId);
			return new ResponseEntity<String>("Product with id: " + propertyId + " deleted successfully",
					HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Property with id: " + propertyId + " doesn't exist",
					HttpStatus.NOT_FOUND);
		}
	}

	// Get Properties by Best Seller
	@GetMapping("/properties/bestseller")
	public ResponseEntity<List<Property>> getPropertiesByBestSeller(@RequestParam(required = true) Boolean bestSeller) {
		if (propertyService.getByBestSeller(bestSeller).size() > 0) {
			return new ResponseEntity<List<Property>>(propertyService.getByBestSeller(bestSeller), HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Property>>(propertyService.getByBestSeller(bestSeller),
					HttpStatus.NOT_FOUND);
		}
	}

	// Get by Title Or Type
	@GetMapping("/properties/search")
	public ResponseEntity<List<Property>> getAllByTitleOrType(@RequestParam(required = false) String title,
			@RequestParam(required = false) String type) {

		if (propertyService.getPropertiesByTitleOrType(title, type).size() > 0) {
			return new ResponseEntity<List<Property>>(propertyService.getPropertiesByTitleOrType(title, type),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Property>>(propertyService.getPropertiesByTitleOrType(title, type),
					HttpStatus.NOT_FOUND);
		}

	}

	// Get by Type
	@GetMapping("/propertyType/{type}")
	public ResponseEntity<List<Property>> getAllbyType(@PathVariable String type) {
		if (propertyService.getPropertiesByType(type).size() > 0) {
			return new ResponseEntity<List<Property>>(propertyService.getPropertiesByType(type), HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Property>>(propertyService.getPropertiesByType(type), HttpStatus.NOT_FOUND);
		}
	}

	// Get Featured posts
	@GetMapping("/properties/featured")
	public ResponseEntity<List<Property>> getByBestSeller() {
		if (propertyService.getPropertiesByFeatured().size() > 0) {
			return new ResponseEntity<List<Property>>(propertyService.getPropertiesByFeatured(), HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Property>>(propertyService.getPropertiesByFeatured(), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/properties/search/{type}")
	public ResponseEntity<List<Property>> getAllbySearch(@PathVariable String type) {
		if (propertyService.getPropertiesByType(type).size() > 0) {
			return new ResponseEntity<List<Property>>(propertyService.getPropertiesByType(type), HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Property>>(propertyService.getPropertiesByType(type), HttpStatus.NOT_FOUND);
		}
	}

}

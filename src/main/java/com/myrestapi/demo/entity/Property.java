package com.myrestapi.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Property")
public class Property {

	@Id
	private String id;
	private String title;
	private float propertyPrice;
	private String img;
	private boolean bestSeller;
	private String description;
	private String type;
	private String location;
	private String amenities;
	private String rules;
	private boolean featured;

	public Property() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Property(String id, String title, float propertyPrice, String img, boolean bestSeller, String description,
			String type, String location, String amenities, String rules, boolean featured) {
		super();
		this.id = id;
		this.title = title;
		this.propertyPrice = propertyPrice;
		this.img = img;
		this.bestSeller = bestSeller;
		this.description = description;
		this.type = type;
		this.location = location;
		this.amenities = amenities;
		this.rules = rules;
		this.featured = featured;
	}

	public float getPropertyPrice() {
		return propertyPrice;
	}

	public void setPropertyPrice(float propertyPrice) {
		this.propertyPrice = propertyPrice;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public boolean isBestSeller() {
		return bestSeller;
	}

	public void setBestSeller(boolean bestSeller) {
		this.bestSeller = bestSeller;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAmenities() {
		return amenities;
	}

	public void setAmenities(String amenities) {
		this.amenities = amenities;
	}

	public String getRules() {
		return rules;
	}

	public void setRules(String rules) {
		this.rules = rules;
	}

	public boolean isFeatured() {
		return featured;
	}

	public void setFeatured(boolean featured) {
		this.featured = featured;
	}

}

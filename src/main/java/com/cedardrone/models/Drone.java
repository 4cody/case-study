package com.cedardrone.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="drone")
public class Drone {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer dId;
	@NotEmpty
	private String make;
	@NotEmpty
	private String model;
	@NotEmpty
	private double price;
	@NotEmpty
	private double weight;
	private Integer cameraRes;
	@NotEmpty
	private Integer maxSpeed;
	@NotEmpty
	private Integer maxRange;
	@NotEmpty
	private String category;
	@NotEmpty
	private double rating;
	
	public Drone() {}
	
	public Drone(Integer dId, @NotEmpty String make, @NotEmpty String model, @NotEmpty double price,
			@NotEmpty double weight, Integer cameraRes, @NotEmpty Integer maxSpeed, @NotEmpty Integer maxRange,
			@NotEmpty String category, @NotEmpty double rating) {
		super();
		this.dId = dId;
		this.make = make;
		this.model = model;
		this.price = price;
		this.weight = weight;
		this.cameraRes = cameraRes;
		this.maxSpeed = maxSpeed;
		this.maxRange = maxRange;
		this.category = category;
		this.rating = rating;
	}



	public Integer getdId() {
		return dId;
	}
	public void setdId(Integer dId) {
		this.dId = dId;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public Integer getCameraRes() {
		return cameraRes;
	}
	public void setCameraRes(Integer cameraRes) {
		this.cameraRes = cameraRes;
	}
	public Integer getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(Integer maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	public Integer getMaxRange() {
		return maxRange;
	}
	public void setMaxRange(Integer maxRange) {
		this.maxRange = maxRange;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	
}


package com.cedardrone.models;

import javax.persistence.Column;
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
	// todo-strech : make Id a composite key of make/model
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer droneId;
	@Column(name="make", length=50, nullable=false)
	private String make;
	@Column(name="model", length=50, nullable=false)
	private String model;
	@Column(name="price", length=50, nullable=false)
	private double price;
	@Column(name="weight", length=50, nullable=false)
	private double weight;
	private Integer cameraRes;
	@Column(name="maxspeed", length=3, nullable=false)
	private Integer maxSpeed;
	@Column(name="maxrange", length=3, nullable=false)
	private Integer maxRange;
	@Column(name="category", length=50, nullable=false)
	private String category;
	@Column(name="rating", length=5, nullable=false)
	private double rating;
	
	public Drone() {}
	
	public Drone(Integer droneId, @NotEmpty String make, @NotEmpty String model, @NotEmpty double price,
			@NotEmpty double weight, Integer cameraRes, @NotEmpty Integer maxSpeed, @NotEmpty Integer maxRange,
			@NotEmpty String category, @NotEmpty double rating) {
		super();
		this.droneId = droneId;
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



	public Integer getDroneId() {
		return droneId;
	}
	public void setDroneId(Integer dId) {
		this.droneId = dId;
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

	@Override
	public String toString() {
		return "Drone [droneId=" + droneId + ", make=" + make + ", model=" + model + ", price=" + price + ", weight=" + weight
				+ ", cameraRes=" + cameraRes + ", maxSpeed=" + maxSpeed + ", maxRange=" + maxRange + ", category="
				+ category + ", rating=" + rating + "]";
	}
	
}


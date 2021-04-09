package com.cedardrone.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="drone")
public class Drone {
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
	@Column(name="cameraRes", length=5)
	private String cameraRes;
	@Column(name="maxspeed", length=3, nullable=false)
	private Integer maxSpeed;
	@Column(name="maxrange", length=3, nullable=false)
	private Integer maxRange;
	@Column(name="category", length=50, nullable=false)
	private String category;
	@Column(name="rating")
	private double rating;
	@OneToMany(targetEntity = Review.class, orphanRemoval = true, cascade = CascadeType.PERSIST)
	private List<Review> reviewList = new ArrayList<Review>();
	@Column(name="imageName")
	private String imageName;

	public Drone() {}
	

	public Drone(Integer droneId, String make, String model, double price, double weight, String cameraRes,
			Integer maxSpeed, Integer maxRange, String category, double rating, List<Review> reviewList, 
			String imageName) {
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
		this.reviewList = reviewList;
		this.imageName = imageName;
	}

	public Integer getDroneId() {
		return droneId;
	}



	public void setDroneId(Integer droneId) {
		this.droneId = droneId;
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



	public String getCameraRes() {
		return cameraRes;
	}



	public void setCameraRes(String cameraRes) {
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



	public List<Review> getReviewList() {
		return reviewList;
	}



	public void setReviewList(List<Review> reviewList) {
		this.reviewList = reviewList;
	}



	public String getImageName() {
		return imageName;
	}



	public void setImageName(String imageName) {
		this.imageName = imageName;
	}



	@Override
	public String toString() {
		return "Drone [droneId=" + droneId + ", make=" + make + ", model=" + model + ", price=" + price + ", weight=" + weight
				+ ", cameraRes=" + cameraRes + ", maxSpeed=" + maxSpeed + ", maxRange=" + maxRange + ", category="
				+ category + ", rating=" + rating + "]";
	}
	
}


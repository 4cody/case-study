package com.cedardrone.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "review")
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rId;
	@Column(name = "textBody", length = 200, nullable = false)
	private String textBody;
	@Column(name = "rating", length = 1, nullable = false)
	private Double rating;
	@ManyToOne
	@JoinColumn(name = "author", nullable = false)
	private User user;
//	@ManyToOne
//	@JoinColumn(name = "drone", nullable = false)
//	private Drone drone;

	public Review() {
	}

	public Review(Integer rId, String textBody, Double rating, User user) {
		this.rId = rId;
		this.textBody = textBody;
		this.rating = rating;
		this.user = user;
//		this.drone = drone;
	}

	public Integer getrId() {
		return rId;
	}

	public void setrId(Integer rId) {
		this.rId = rId;
	}

	public String getTextBody() {
		return textBody;
	}

	public void setTextBody(String textBody) {
		this.textBody = textBody;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

//	public Drone getDrone() {
//		return drone;
//	}
//
//	public void setDrone(Drone drone) {
//		this.drone = drone;
//	}


}

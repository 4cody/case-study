package com.cedardrone.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;

@Entity
@Table(name="user")
public class User {
	@Id
	@Email
	private String email;
	@NotEmpty
	@Size(min=2, max=25)
	private String username;
	@Column(name="password", nullable=false)
	@Size(min=4, max=20)
	private String password;
	@OneToMany(targetEntity = Review.class)
	private List<Review> reviewList;
	
	public User() {}

	public User(String email, @NotEmpty @Size(min = 2, max = 25) String username, String password, List<Review> reviewList) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.reviewList = reviewList;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Review> getReviewList() {
		return reviewList;
	}

	public void setReviewList(List<Review> reviewList) {
		this.reviewList = reviewList;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", username=" + username + ", password=" + password + "]";
	}
}
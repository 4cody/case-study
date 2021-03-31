package com.cedardrone.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="review")
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rId;
	@Size(min=10, max=200)
	private String textBody;
	@NotEmpty
	private Double rating;
	
	public Review() {}

	public Review(Integer rId, @Size(min = 10, max = 200) String textBody, @NotEmpty Double rating) {
		super();
		this.rId = rId;
		this.textBody = textBody;
		this.rating = rating;
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
	
	
}

package com.cedardrone.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cedardrone.models.Drone;
import com.cedardrone.models.Review;
import com.cedardrone.repository.ReviewRepository;

@Service
public class ReviewService {
	private ReviewRepository reviewRepository;
	
	@Autowired
	public ReviewService(ReviewRepository reviewRepository) {
		this.reviewRepository = reviewRepository;
	}
	
	public Review findByRid(Integer rId) {
		return reviewRepository.findByRId(rId);
	}

	public void saveReview(Review review) {
		reviewRepository.save(review);
	}
	
	public Boolean editReview(Review review, Integer rId) {
		
		try {
			Review r = reviewRepository.findByRId(rId);
			
			r.setRating(review.getRating());
			r.setTextBody(review.getTextBody());
			
			reviewRepository.save(r);
			
			return true;
		} catch(Exception e) {
			e.printStackTrace();
		}		

		return false;
	}
	
	public Boolean deleteReview(Integer rId) {
		try {
			Review r = reviewRepository.findByRId(rId);
			
			reviewRepository.delete(r);
			
			return true;
		} catch(Exception e) {
			e.printStackTrace();
		}		

		return false;
	}
}

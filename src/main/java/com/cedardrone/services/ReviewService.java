package com.cedardrone.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cedardrone.models.Review;
import com.cedardrone.repository.ReviewRepository;

@Service
public class ReviewService {
	private ReviewRepository reviewRepository;
	
	@Autowired
	public ReviewService(ReviewRepository reviewRepository) {
		this.reviewRepository = reviewRepository;
	}
	
	public void saveReview(Review review) {
		reviewRepository.save(review);
	}
	
//	public User findUserByUsername(String username) {
//		return com.cedardrone.repository.UserRepository.findUserByUsername(username);
//	}
}
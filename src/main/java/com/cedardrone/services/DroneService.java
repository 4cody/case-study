package com.cedardrone.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cedardrone.models.Drone;
import com.cedardrone.models.Review;
import com.cedardrone.models.User;
import com.cedardrone.repository.DroneRepository;

@Service
public class DroneService {
	private DroneRepository droneRepository;
	
	@Autowired
	public DroneService(DroneRepository droneRepository) {
		this.droneRepository = droneRepository;
	}
	
	public List<Drone> getAllDrones(){
		return (List<Drone>) droneRepository.findAll();
	}
	
	public void saveDrone(Drone drone) {
		droneRepository.save(drone);
	}
	
	public Drone findByDroneId(int droneId) {
		return droneRepository.findByDroneId(droneId);
	}
	
	public Boolean saveReview(int droneId, Review review) {
		// Get drone's list of reviews
		Drone d = droneRepository.findByDroneId(droneId);
		List<Review> droneReviews = d.getReviewList();
		
		for(Review r: droneReviews) {
			if(r.getAuthor().equals(review.getAuthor())) {
				return false;
			}
		}
		
		// Update drone's review list
		droneReviews.add(review);
		d.setReviewList(droneReviews);
		
		// Calculate and update drone's rating
		double reviewRating = review.getRating();
		double currentRating = d.getRating();
		int amountOfReviews = droneReviews.size();
		double newRating = (reviewRating + currentRating) / amountOfReviews;
		d.setRating(newRating);
		
		// Persist changes
		saveDrone(d);
		
		return true;
	}
	
//	public double updateRating(int droneId, double rating) {
//		// Get drone's current rating
//		Drone d = droneRepository.findByDroneId(droneId);
//		double r = d.getRating();
//		
//		// Get # of reviews on drone
//		int s = d.getReviewList().size();
//		
//		// Calculate new average rating and return
//		return (r+ rating / s);
//
//	}

}

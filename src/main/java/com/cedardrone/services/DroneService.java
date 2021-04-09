package com.cedardrone.services;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cedardrone.models.Drone;
import com.cedardrone.models.Review;
import com.cedardrone.models.User;
import com.cedardrone.repository.DroneRepository;
import com.cedardrone.repository.ReviewRepository;

@Service
public class DroneService {
	private DroneRepository droneRepository;
	private ReviewRepository reviewRepository;
	
	
	@Autowired
	public DroneService(DroneRepository droneRepository, ReviewRepository reviewRepository) {
		this.droneRepository = droneRepository;
		this.reviewRepository = reviewRepository;
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
	
	public boolean saveReview(int droneId, Review review) {
		// Get drone's list of reviews
		Drone d = droneRepository.findByDroneId(droneId);
		List<Review> droneReviews = d.getReviewList();
		
		// Check if user has left a review on drone
		for(Review r: droneReviews) {
			if(r.getUser().getEmail().equals(review.getUser().getEmail())) {
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
		
		// Format to 1 decimal place and set
		DecimalFormat numberFormat = new DecimalFormat("#.0");
		double formatedTotal = Double.parseDouble(numberFormat.format(newRating));
		d.setRating(formatedTotal);
		
		// Persist changes
		saveDrone(d);
		
		return true;
	}
	
	public boolean updateRating(int droneId, double newRating, int rId) {
		
		try {
			// Get drone's review list
			Drone d = droneRepository.findByDroneId(droneId);
			List<Review> droneReviews = d.getReviewList();

			double tempTotal = 0.0;
		
			// Recalculate rating average
			for(Review r: droneReviews) {
				tempTotal += r.getRating();
			}
			tempTotal = tempTotal / droneReviews.size();
			
			// Format to 1 decimal place and set
			DecimalFormat numberFormat = new DecimalFormat("#.0");
			double formatedTotal = Double.parseDouble(numberFormat.format(tempTotal));
			d.setRating(formatedTotal);
			
			// Persist changes
			saveDrone(d);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;

	}
	
	public boolean removeReview(int rId, int droneId) {
		
		try {
			Drone d = droneRepository.findByDroneId(droneId);

			Review r = reviewRepository.findByRId(rId);
			
			List<Review> newList = d.getReviewList();
			newList.remove(r);
			
			d.setReviewList(newList);
			
			droneRepository.save(d);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;

		
	}

}

package com.cedardrone.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cedardrone.models.Drone;
import com.cedardrone.models.Review;
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
	
	public void saveReview(int droneId, Review review) {
		// Get drone's list of reviews
		Drone d = droneRepository.findByDroneId(droneId);
		List<Review> droneReviews = d.getReviewList();
		
		// Update drone's review list
		droneReviews.add(review);
		d.setReviewList(droneReviews);
		
		// persist changes
		saveDrone(d);
		
	}

}

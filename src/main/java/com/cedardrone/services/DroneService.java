package com.cedardrone.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cedardrone.models.Drone;
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
	
	public void saveDrone (Drone drone) {
		droneRepository.save(drone);
	}
	
//	public User findByUsername(String username) {
//		return userRepository.findByUsername(username);
//	}

}

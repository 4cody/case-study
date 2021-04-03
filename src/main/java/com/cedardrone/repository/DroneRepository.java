package com.cedardrone.repository;

import org.springframework.data.repository.CrudRepository;

import com.cedardrone.models.Drone;

public interface DroneRepository extends CrudRepository<Drone, Integer> {
	public Drone findByDroneId(int droneId);
}

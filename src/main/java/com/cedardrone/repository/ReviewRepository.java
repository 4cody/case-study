package com.cedardrone.repository;

import org.springframework.data.repository.CrudRepository;

import com.cedardrone.models.Review;
import com.cedardrone.models.User;


public interface ReviewRepository extends CrudRepository<Review, Integer> {
	public Review findByRId(Integer rId);
}
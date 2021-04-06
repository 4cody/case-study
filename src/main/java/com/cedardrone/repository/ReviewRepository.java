package com.cedardrone.repository;

import org.springframework.data.repository.CrudRepository;

import com.cedardrone.models.Review;


public interface ReviewRepository extends CrudRepository<Review, Integer> {

}
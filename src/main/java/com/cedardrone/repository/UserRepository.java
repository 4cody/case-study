package com.cedardrone.repository;

import org.springframework.data.repository.CrudRepository;

import com.cedardrone.models.User;

public interface UserRepository extends CrudRepository<User, String> {
	public User findByUsername(String username);
}

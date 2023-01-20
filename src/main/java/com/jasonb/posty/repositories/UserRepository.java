package com.jasonb.posty.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.jasonb.posty.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	public Optional<User> findByEmail(String email);
}
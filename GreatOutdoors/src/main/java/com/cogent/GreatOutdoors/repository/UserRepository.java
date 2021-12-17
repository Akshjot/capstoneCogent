package com.cogent.GreatOutdoors.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cogent.GreatOutdoors.dto.User;

@CrossOrigin()
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findByFirstName(String name);
	public Optional<User> findByEmail(String email);
}

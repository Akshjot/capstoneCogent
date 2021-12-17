package com.cogent.GreatOutdoors.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cogent.GreatOutdoors.dto.Cart;
import com.cogent.GreatOutdoors.dto.User;

@CrossOrigin()
@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
	public List<Cart> findByUser(User user);
	public List<Cart> findAll();
	public List<Cart> findById(int id);
}

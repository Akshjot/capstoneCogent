package com.cogent.GreatOutdoors.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cogent.GreatOutdoors.dto.Product;

@CrossOrigin()
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	public List<Product> findByCategory(String category);
	public List<Product> getProductByNameContaining(String name);
}

package com.cogent.GreatOutdoors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cogent.GreatOutdoors.dto.Orders;

@CrossOrigin()
@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {

}

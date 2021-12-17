package com.cogent.GreatOutdoors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cogent.GreatOutdoors.dto.DeliveryAddress;

@CrossOrigin()
@Repository
public interface DeliveryAddressRepository extends JpaRepository<DeliveryAddress, Integer> {

}

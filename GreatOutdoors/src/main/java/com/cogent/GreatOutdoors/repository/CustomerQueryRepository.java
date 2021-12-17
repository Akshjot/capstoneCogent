package com.cogent.GreatOutdoors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cogent.GreatOutdoors.dto.CustomerQuery;

@CrossOrigin()
@Repository
public interface CustomerQueryRepository extends JpaRepository<CustomerQuery, Integer> {

}

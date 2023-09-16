package com.driver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.driver.model.Cab;
import com.driver.model.Driver;

@Repository
public interface CabRepository extends JpaRepository<Cab, Integer> {

	Cab findByDriver(Driver drivre);
	
	List<Cab> findByAvailable(boolean b);
	
}

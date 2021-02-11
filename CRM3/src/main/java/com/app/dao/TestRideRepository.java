package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.TestRide;

public interface TestRideRepository extends JpaRepository<TestRide, Integer>{
	
		TestRide findByTestRideId(Integer id);
}

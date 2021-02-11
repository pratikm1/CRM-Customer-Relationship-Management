package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer>{
	
		Vehicle findByModelName(String model);
		Vehicle findByVehicleId(Integer id);
		@Query(value = "SELECT COUNT(v) FROM Vehicle v")
		int getNumberOfVehicles();
}

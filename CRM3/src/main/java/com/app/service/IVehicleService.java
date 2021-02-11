package com.app.service;

import java.util.List;

import com.app.pojos.Vehicle;

public interface IVehicleService {

	List<Vehicle> listAllVehicles();
	Vehicle addVehicle(Vehicle newVehicle);
	String deleteVehicle(String modelname);
	Vehicle findVehicleById(int id);
	Vehicle updateVehicleData(Vehicle updatedVehicleData);
	
}

package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.VehicleRepository;
import com.app.pojos.Vehicle;


@Service
@Transactional
public class VehicleServiceImpl implements IVehicleService {
	
	@Autowired
	private VehicleRepository vehicleRepo;

	@Override
	public List<Vehicle> listAllVehicles() {
		return vehicleRepo.findAll();
	}

	@Override
	public Vehicle addVehicle(Vehicle newVehicle) {
		// TODO Auto-generated method stub
		return vehicleRepo.save(newVehicle);
	}

	@Override
	public String deleteVehicle(String modelname) {
		// TODO Auto-generated method stub
		Vehicle v = vehicleRepo.findByModelName(modelname);
		try{
			vehicleRepo.delete(v);
		}catch(Exception e) {
			System.out.println("Error in deletion "+e);
		}
		return "vehicle details deleted Successfully";
	}
	
	@Override
	public Vehicle findVehicleById(int id) {
		// TODO Auto-generated method stub
		return vehicleRepo.findByVehicleId(id);
	}
	
	
	public Vehicle updateVehicleData(Vehicle updatedVehicleData) {
		
		return vehicleRepo.save(updatedVehicleData);
	}
	
	public int getNumberOfVehicles() {
		// TODO Auto-generated method stub
		return vehicleRepo.getNumberOfVehicles();
	}
	
}

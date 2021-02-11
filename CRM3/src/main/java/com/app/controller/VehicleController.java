package com.app.controller;

import java.awt.PageAttributes.MediaType;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.pojos.Vehicle;
import com.app.service.VehicleServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/vehicles")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class VehicleController {

	@Autowired
	private VehicleServiceImpl service;

	public VehicleController() {
		System.out.println("IN VEHICLES CONTROLLER....!!!");
	}

	@GetMapping
	public ResponseEntity<?> getAllVehicle() {
		System.out.println("IN GET ALL VEHICLES " + getClass().getName());
		List<Vehicle> vehicles = service.listAllVehicles();
		if (vehicles.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else
			return new ResponseEntity<>(vehicles, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> addNewVehicle(@RequestBody Vehicle v) {
		System.out.println("In add new vehicle " + v);
		try {

			Vehicle newVehicle = service.addVehicle(v);
			System.out.println(newVehicle);
			return new ResponseEntity<>(newVehicle, HttpStatus.CREATED);

		} catch (RuntimeException e) {
			System.out.println("ERROR in adding new vehicle " + e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/{modelname}")
	public ResponseEntity<?> deleteVehicle(@PathVariable String modelname) {
		System.out.println("IN DELETE VEHICLE COTROLLER");

		try {
			service.deleteVehicle(modelname);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}

	}

//	@PutMapping("/update/{vehicleId}")
//	public ResponseEntity<?> updateVehicleDetails(@RequestBody Vehicle v, @PathVariable int vehicleId) {
//
//		Vehicle veh = service.findVehicleById(vehicleId);
//
//		System.out.println("IN UPDATE VEHICLES " + v + "         " + vehicleId);
//		if (veh != null) {
//			Vehicle existingVehicle = veh;
//			System.out.println("Old vehicle price: " + veh.getPrice());
//			existingVehicle.setVehicleNumber(v.getVehicleNumber());
//			existingVehicle.setCc(v.getCc());
//			existingVehicle.setColour(v.getColour());
//			existingVehicle.setExShowRoomPrice(v.getExShowRoomPrice());
//			existingVehicle.setRegPrice(v.getRegPrice());
//			existingVehicle.setFuelcap(v.getFuelcap());
//			existingVehicle.setMileage(v.getMileage());
//			existingVehicle.setModelName(v.getModelName());
//			existingVehicle.setPrice(0);
//			existingVehicle.setQty(v.getQty());
//			existingVehicle.setTorque(v.getTorque());
//			existingVehicle.setVehicleNumber(v.getVehicleNumber());
//
//			try {
//				service.updateVehicleData(existingVehicle);
//				return ResponseEntity.ok(existingVehicle);
//			} catch (RuntimeException e) {
//				System.out.println("err in update vehicle" + e);
//				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//			}
//
//		}
//		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	}
	
	@PutMapping("/update/{vehicleId}")
	public ResponseEntity<?> updateVehicleDetails(@RequestParam("vehicle") String vehicleStr,
			@RequestParam("imageFile") MultipartFile imageFile/* @RequestBody Vehicle v */, @PathVariable int vehicleId) throws IOException {

		Vehicle veh = service.findVehicleById(vehicleId);
		Vehicle v = new ObjectMapper().readValue(vehicleStr, Vehicle.class);
		System.out.println("IN UPDATE VEHICLES " + v + "         " + vehicleId);
		if (veh != null) {
			Vehicle existingVehicle = veh;
			System.out.println("Old vehicle price: " + veh.getPrice());
			existingVehicle.setVehicleNumber(v.getVehicleNumber());
			existingVehicle.setCc(v.getCc());
			existingVehicle.setColour(v.getColour());
			existingVehicle.setExShowRoomPrice(v.getExShowRoomPrice());
			existingVehicle.setRegPrice(v.getRegPrice());
			existingVehicle.setFuelcap(v.getFuelcap());
			existingVehicle.setMileage(v.getMileage());
			existingVehicle.setModelName(v.getModelName());
			existingVehicle.setPrice(0);
			existingVehicle.setQty(v.getQty());
			existingVehicle.setTorque(v.getTorque());
			existingVehicle.setVehicleNumber(v.getVehicleNumber());
			
			existingVehicle.setImage(imageFile.getBytes());
			existingVehicle.setType(imageFile.getContentType());

			try {
				service.updateVehicleData(existingVehicle);
				return ResponseEntity.ok(existingVehicle);
			} catch (RuntimeException e) {
				System.out.println("err in update vehicle" + e);
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/{vehicleId}")
	public ResponseEntity<?> getVehicleById(@PathVariable int vehicleId) {
		System.out.println("IN SELECT VEHICLE BY ID COTROLLER");

		try {
			Vehicle v = service.findVehicleById(vehicleId);
			return new ResponseEntity<>(v,HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
	}

//	@PostMapping("/registerWithImage")
	@RequestMapping(value = "/registerWithImage", method = RequestMethod.POST)
	public ResponseEntity<?> fileUploadWithParams(@RequestParam("vehicle") String veh,
			@RequestParam("imageFile") MultipartFile imageFile) {
		try {

			// To convert string data of employee into employee object
			Vehicle vehicle = new ObjectMapper().readValue(veh, Vehicle.class);

			// To encrypt the password using bCrypt so that it should not be exposed
			// to anyone (especially database handling guy)
//			vehicle.setPassword(bCryptPasswordEncoder.encode(employee.getPassword()));
//			vehicle.setStatus(true);
			vehicle.setImage(imageFile.getBytes());
			vehicle.setType(imageFile.getContentType());
			service.addVehicle(vehicle);
//			employeeRepository.save(employee);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@GetMapping("/vehiclescount")
	public ResponseEntity<?> getNumberOfComplaints() {
		try{
			return new ResponseEntity<>(service.getNumberOfVehicles(),HttpStatus.OK);
		}
		catch(RuntimeException e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		}
	}
}
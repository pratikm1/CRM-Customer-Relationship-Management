package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Service;
import com.app.service.ServicesServiceImpl;

@RestController
@RequestMapping("/services")
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class ServicesController {

	@Autowired
	private ServicesServiceImpl service;
	
	public ServicesController() {
		System.out.println("IN SERVICES CONTROLLER....!!!");
	}
	
	@GetMapping
	public ResponseEntity<?> getAllVehicle() {
		System.out.println("IN GET ALL SERVICES " + getClass().getName());
		List<Service> services= service.listAllServices();
		if (services.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else
			return new ResponseEntity<>(services, HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<?> addNewService(@RequestBody Service s) {
		System.out.println("In add new service " + s);
		try {
			Service newService= service.addService(s);
			System.out.println(newService);
			return new ResponseEntity<>(newService, HttpStatus.CREATED);

		} catch (RuntimeException e) {
			System.out.println("ERROR in adding new Service " + e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?>deleteService(@PathVariable int id) {
		System.out.println("IN DELETE SERVICE COTROLLER");
		try{
			return new ResponseEntity<>(service.deleteServiceById(id),HttpStatus.OK);
		}
		catch(RuntimeException e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		}

	}
	
	
}
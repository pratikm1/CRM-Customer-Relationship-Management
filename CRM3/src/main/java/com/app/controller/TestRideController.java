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

import com.app.pojos.TestRide;
import com.app.service.TestRideServiceImpl;

@RestController
@RequestMapping("/testride")
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class TestRideController {

	@Autowired
	private TestRideServiceImpl service;

	public TestRideController() {
		System.out.println("IN TEST RIDE CONTROLLER....!!!");
	}

	@GetMapping
	public ResponseEntity<?> getAllTestRides() {
		System.out.println("IN GET ALL TESTRIDES" + getClass().getName());
		List<TestRide> testRides = service.listAllTestRides();
		if (testRides.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else
			return new ResponseEntity<>(testRides, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> addNewTestRide(@RequestBody TestRide tr) {
		System.out.println("In add new test ride " + tr);
		try {

			TestRide newTestRide = service.addTestRide(tr);
			System.out.println(newTestRide);
			return new ResponseEntity<>(newTestRide, HttpStatus.CREATED);

		} catch (RuntimeException e) {
			System.out.println("ERROR in adding new Test ride Offer" + e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteTestRide(@PathVariable int id) {
		System.out.println("IN DELETE TESTRIDE COTROLLER");
		try {
			return new ResponseEntity<>(service.deleteTestRide(id), HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}

	}

}
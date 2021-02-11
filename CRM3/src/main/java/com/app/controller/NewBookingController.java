package com.app.controller;

import java.util.List;
import java.util.Optional;

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

import com.app.pojos.NewBooking;
import com.app.service.NewBookingServiceImpl;

@RestController
@RequestMapping("/newbooking")
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class NewBookingController {

	@Autowired
	private NewBookingServiceImpl service;

	public NewBookingController() {
		System.out.println("IN NEW BOOKING CONTROLLER....!!!");
	}

	@GetMapping
	public ResponseEntity<?> getAllNewBookings() {
		System.out.println("IN GET NEW BOOKING" + getClass().getName());
		List<NewBooking> newBookings = service.listAllNewBookings();
		if (newBookings.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else
			return new ResponseEntity<>(newBookings, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> addNewBooking(@RequestBody NewBooking nb) {
		System.out.println("In add new booking " + nb);
		try {

			NewBooking newBooking = service.addNewBooking(nb);
			System.out.println(newBooking);
			return new ResponseEntity<>(newBooking, HttpStatus.CREATED);

		} catch (RuntimeException e) {
			System.out.println("ERROR in adding new booking " + e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/id")
	public ResponseEntity<?> m2(@RequestBody NewBooking nb/*@RequestBody String email, @RequestBody String password*/){
//		System.out.println("In User Authentication"+u);
//		UserData user = service.getUserData(email, password);
//		UserData user = service.getUserData(u.getEmail(), u.getPassword());
		Optional<NewBooking> b = service.getBookingById(nb.getBookingId());
		if(b.isPresent())
			return new ResponseEntity<>(b,HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?>deleteNewBooking(@PathVariable int id) {
		System.out.println("IN DELETE NEW BOOKING COTROLLER");
		

		try{
			return new ResponseEntity<>(service.deleteNewBooking(id),HttpStatus.OK);
		}
		catch(RuntimeException e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		}

	}
}
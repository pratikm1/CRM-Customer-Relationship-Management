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

import com.app.pojos.Complaint;
import com.app.service.ComplaintsServiceImpl;

@RestController
@RequestMapping("/complaints")
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class ComplaintsController {

	@Autowired
	private ComplaintsServiceImpl service;

	public ComplaintsController() {
		System.out.println("IN COMPLAINTS CONTROLLER...CNSTR.!!!");
	}

	@GetMapping
	public ResponseEntity<?> getAllComplaints() {
		System.out.println("IN GET ALL VEHICLES " + getClass().getName());
		List<Complaint> complaints = service.listAllComplaints();
		if (complaints.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else
			return new ResponseEntity<>(complaints, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> addNewComplaint(@RequestBody Complaint c) {
		System.out.println("In add new complaint " + c);
		try {

			Complaint newComplaint= service.addComplaint(c);
			System.out.println(newComplaint);
			return new ResponseEntity<>(newComplaint, HttpStatus.CREATED);

		} catch (RuntimeException e) {
			System.out.println("ERROR in adding new Complaint " + e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/{compId}")
	public ResponseEntity<?>deleteComplaint(@PathVariable int compId) {
		System.out.println("IN DELETE COMPLAINTS COTROLLER");
		

		try{
			return new ResponseEntity<>(service.deleteComplaint(compId),HttpStatus.OK);
		}
		catch(RuntimeException e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		}

	}
	
	@GetMapping("/complaintscount")
	public ResponseEntity<?> getNumberOfComplaints() {
		try{
			return new ResponseEntity<>(service.getNumberOfComplaint(),HttpStatus.OK);
		}
		catch(RuntimeException e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		}
	}
	
	
}
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.UserData;
import com.app.service.UsersDataServiceImpl;

@RestController
@RequestMapping("/users")
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class UsersDataController {

	@Autowired
	private UsersDataServiceImpl service;

	public UsersDataController() {
		System.out.println("IN USERsDATA CONTROLLER....!!!");
	}

	@GetMapping
	public ResponseEntity<?> getAllVehicle() {
		System.out.println("IN GET ALL USERS " + getClass().getName());
		List<UserData> users = service.listAllUserDatas();
		if (users.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else
			return new ResponseEntity<>(users, HttpStatus.OK);
	}
//	
//	@GetMapping("/login")
//	public ResponseEntity<?> userAuthentication(@RequestBody UserData u /*String email, @RequestParam String password*/){
//		System.out.println("In User Authentication");
//		UserData user = service.getUserData(u.getEmail(), u.getPassword());
//		if(user != null)
//			return new ResponseEntity<>(user,HttpStatus.OK);
//		else
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//	
//	}
	@PostMapping("/log")
	public ResponseEntity<?> m2(@RequestBody UserData u/*@RequestBody String email, @RequestBody String password*/){
		System.out.println("In User Authentication"+u);
//		UserData user = service.getUserData(email, password);
		UserData user = service.getUserData(u.getEmail(), u.getPassword());
		if(user != null)
			return new ResponseEntity<>(user,HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	@PostMapping
	public ResponseEntity<?> addNewUserData(@RequestBody UserData u) {
		System.out.println("In add new user " + u);
		try {

			UserData newUserData = service.addUserData(u);
			System.out.println(newUserData);
			return new ResponseEntity<>(newUserData, HttpStatus.CREATED);

		} catch (RuntimeException e) {
			System.out.println("ERROR in adding new user " + e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<?>deleteUser(@PathVariable int userId) {
		System.out.println("IN DELETE USERDATA COTROLLER");
		try{
			service.deleteUserData(userId);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(RuntimeException e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/update/{userId}")
	public ResponseEntity<?> updateStudentDetails(@RequestBody UserData u, @PathVariable int userId) {
		UserData user = service.getUserDataById(userId);
		System.out.println("IN UPDATE USERS "+u+"         "+userId);
		if (user!=null) {
			UserData existingUser= user;
			existingUser.setUsername(u.getUsername());
			existingUser.setEmail(u.getEmail());
			existingUser.setCity(u.getCity());
			existingUser.setPassword(u.getPassword());
			existingUser.setPhoneNumber(u.getPhoneNumber());
			existingUser.setState(u.getState());
			existingUser.setPincode(u.getPincode());
			existingUser.setDob(u.getDob());
			existingUser.setAddress(u.getAddress());
			try {
				service.updateUserData(existingUser);
				return ResponseEntity.ok(existingUser);
			} catch (RuntimeException e) {
				System.out.println("err in update " + e);
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}
	
	@GetMapping("/userscount")
	public ResponseEntity<?> getNumberOfComplaints() {
		try{
			return new ResponseEntity<>(service.getNumberOfUsers(),HttpStatus.OK);
		}
		catch(RuntimeException e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		}
	}
	
	@GetMapping("/phonenumbers")
	public ResponseEntity<?> getNumbersOfUsers() {
		try{
			return new ResponseEntity<>(service.getPhoneNumberOfUsers(),HttpStatus.OK);
		}
		catch(RuntimeException e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		}
	}
	
}
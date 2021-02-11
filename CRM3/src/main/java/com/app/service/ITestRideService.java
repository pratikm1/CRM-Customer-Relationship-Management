package com.app.service;

import java.util.List;

import com.app.pojos.TestRide;

public interface ITestRideService {

	List<TestRide> listAllTestRides();
	TestRide addTestRide(TestRide newTestRide);
	String deleteTestRide(int id);
	
}

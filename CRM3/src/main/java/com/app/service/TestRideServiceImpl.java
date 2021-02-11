package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.TestRideRepository;
import com.app.pojos.TestRide;


@Service
@Transactional
public class TestRideServiceImpl implements ITestRideService {
	
	@Autowired
	private TestRideRepository testRideRepo;

	@Override
	public List<TestRide> listAllTestRides() {
		return testRideRepo.findAll();
	}

	@Override
	public TestRide addTestRide(TestRide newTestRide) {
		// TODO Auto-generated method stub
		return testRideRepo.save(newTestRide);
	}

	@Override
	public String deleteTestRide(int id) {
		// TODO Auto-generated method stub
		TestRide tr = testRideRepo.findByTestRideId(id);
		try{
			testRideRepo.delete(tr);
		}catch(Exception e) {
			System.out.println("Error in TestRide details deletion "+e);
		}
		return "TestRide details deleted Successfully";
	}
	
	
	
	
	
}

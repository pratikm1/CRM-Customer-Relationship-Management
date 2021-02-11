package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.NewBookingRepository;
import com.app.pojos.NewBooking;


@Service
@Transactional
public class NewBookingServiceImpl implements INewBookingService {
	
	@Autowired
	private NewBookingRepository newBookingRepo;

	@Override
	public List<NewBooking> listAllNewBookings() {
		return newBookingRepo.findAll();
	}

	@Override
	public NewBooking addNewBooking(NewBooking newBooking) {
		// TODO Auto-generated method stub
		return newBookingRepo.save(newBooking);
	}

	@Override
	public String deleteNewBooking(Integer id) {
		// TODO Auto-generated method stub
		NewBooking nb = newBookingRepo.findByBookingId(id);
		try{
			newBookingRepo.delete(nb);
		}catch(Exception e) {
			System.out.println("Error in deletion "+e);
		}
		return "Booking details deleted Successfully";
	}

	@Override
	public Optional<NewBooking> getBookingById(Integer id) {
		
		return newBookingRepo.findById(id);
	}
}

package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.NewBooking;

public interface INewBookingService {

	List<NewBooking> listAllNewBookings();
	NewBooking addNewBooking(NewBooking newBooking);
	String deleteNewBooking(Integer id);
	Optional<NewBooking> getBookingById(Integer id);
	
}

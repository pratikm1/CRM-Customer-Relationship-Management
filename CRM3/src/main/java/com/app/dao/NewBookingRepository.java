package com.app.dao;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.NewBooking;

public interface NewBookingRepository extends JpaRepository<NewBooking, Integer> {

	NewBooking findByBookingId(Integer id);

	NewBooking findByBookingDate(Date dt);

}

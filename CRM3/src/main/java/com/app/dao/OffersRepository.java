package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Offers;

public interface OffersRepository extends JpaRepository<Offers, Integer>{
	
		Offers findByOfferId(Integer id);
}

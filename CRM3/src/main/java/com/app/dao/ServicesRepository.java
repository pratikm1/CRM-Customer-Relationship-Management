package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Service;

public interface ServicesRepository extends JpaRepository<Service, Integer>{
	
		
}

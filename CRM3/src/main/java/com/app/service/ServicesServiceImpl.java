package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ServicesRepository;


@Service
@Transactional
public class ServicesServiceImpl implements IServicesService{
	
	@Autowired
	private ServicesRepository serviceRepo;

	@Override
	public List<com.app.pojos.Service> listAllServices() {
		return serviceRepo.findAll();
	}

	@Override
	public com.app.pojos.Service addService(com.app.pojos.Service s) {
		return serviceRepo.save(s);
	}

	@Override
	public String deleteServiceById(int id) {
		// TODO Auto-generated method stub
		serviceRepo.deleteById(id);
		return "Service Deleted Successfully";
	}

	
}

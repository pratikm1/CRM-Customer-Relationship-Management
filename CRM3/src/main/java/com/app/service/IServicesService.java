package com.app.service;

import java.util.List;

import com.app.pojos.Service;

public interface IServicesService {

	List<Service> listAllServices();
	Service addService(Service s);
	String deleteServiceById(int id);
	
}

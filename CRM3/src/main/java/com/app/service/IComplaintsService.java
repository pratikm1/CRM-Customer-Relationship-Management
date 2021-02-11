package com.app.service;

import java.util.List;

import com.app.pojos.Complaint;

public interface IComplaintsService {

	List<Complaint> listAllComplaints();
	Complaint addComplaint(Complaint newVehicle);
	String deleteComplaint(int complaintId);
	
}

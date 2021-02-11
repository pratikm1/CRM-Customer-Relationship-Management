package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.Complaint;

public interface ComplaintsRepository extends JpaRepository<Complaint, Integer>{
	
		Complaint findByComplaintId(Integer id);
		@Query(value = "SELECT COUNT(c) from Complaint c")
		int getNumberOfComplaints();
}

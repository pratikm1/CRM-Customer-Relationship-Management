package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ComplaintsRepository;
import com.app.pojos.Complaint;


@Service
@Transactional
public class ComplaintsServiceImpl implements IComplaintsService {
	
	@Autowired
	private ComplaintsRepository complaintRepo;

	@Override
	public List<Complaint> listAllComplaints() {
		return complaintRepo.findAll();
	}

	@Override
	public Complaint addComplaint(Complaint newComplaint) {
		// TODO Auto-generated method stub
		return complaintRepo.save(newComplaint);
	}

	@Override
	public String deleteComplaint(int compId) {
		// TODO Auto-generated method stub
		Complaint c = complaintRepo.findByComplaintId(compId);
		try{
			complaintRepo.delete(c);
		}catch(Exception e) {
			System.out.println("Error in complaint deletion "+e);
		}
		return "complaint deleted/resolved Successfully";
	}
	public int getNumberOfComplaint() {
		// TODO Auto-generated method stub
		return complaintRepo.getNumberOfComplaints();
	}
	
}

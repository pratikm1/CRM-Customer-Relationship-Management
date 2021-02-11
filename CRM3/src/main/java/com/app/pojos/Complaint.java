package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "complaint")
public class Complaint {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "complaint_id")
	private Integer complaintId;
	@Column(length = 320)
	private String comapliantTitle;
	@Column(length = 320)
	private String complaintDesc;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserData customerComplaint; //select your vehcile ---- old services

	public Complaint() {
	}

	public Complaint(Integer complaintId, String comapliantTitle, String complaintDesc) {
		super();
		this.complaintId = complaintId;
		this.comapliantTitle = comapliantTitle;
		this.complaintDesc = complaintDesc;
	}

	public Integer getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(Integer complaintId) {
		this.complaintId = complaintId;
	}

	public String getComapliantTitle() {
		return comapliantTitle;
	}

	public void setComapliantTitle(String comapliantTitle) {
		this.comapliantTitle = comapliantTitle;
	}

	public String getComplaintDesc() {
		return complaintDesc;
	}

	public void setComplaintDesc(String complaintDesc) {
		this.complaintDesc = complaintDesc;
	}

//	public UserData getCustomerComplaint() {
//		return customerComplaint;
//	}

	public void setCustomerComplaint(UserData customerComplaint) {
		this.customerComplaint = customerComplaint;
	}

	@Override
	public String toString() {
		return "Complaint [complaintId=" + complaintId + ", comapliantTitle=" + comapliantTitle + ", complaintDesc="
				+ complaintDesc + "]";
	}
	
	
	
}

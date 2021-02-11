package com.app.pojos;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "services")
public class Service {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "jobCard_no")
	private Integer jobCardNo;
//	@Column
//	private Date lastServiceDate;
	@Column
	private Date currBookingDate;
//	@Column
//	private Date nextServiceDate;
	
//	//doubt--------------------
//	@ElementCollection
//	private Map<String, Double> serviceType; //string : service type name , Double: price
	
	
	//private Invoice invoice;
	
//	private Vehicle customerVehicle;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserData customer;

	@OneToMany(cascade = CascadeType.ALL)
	private List<AvailableServices> avlServices;
	
	public Service() {
	}

	public Service(Integer jobCardNo, Date currBookingDate /*Date lastServiceDate,  Date nextServiceDate Map<String, Double> serviceType*/) {
		super();
		this.jobCardNo = jobCardNo;
//		this.lastServiceDate = lastServiceDate;
		this.currBookingDate = currBookingDate;
//		this.nextServiceDate = nextServiceDate;
//		this.serviceType = serviceType;
	}

	public Integer getJobCardNo() {
		return jobCardNo;
	}

	public void setJobCardNo(Integer jobCardNo) {
		this.jobCardNo = jobCardNo;
	}

//	public Date getLastServiceDate() {
//		return lastServiceDate;
//	}
//
//	public void setLastServiceDate(Date lastServiceDate) {
//		this.lastServiceDate = lastServiceDate;
//	}

	public Date getCurrBookingDate() {
		return currBookingDate;
	}

	public void setCurrBookingDate(Date currBookingDate) {
		this.currBookingDate = currBookingDate;
	}

//	public Date getNextServiceDate() {
//		return nextServiceDate;
//	}
//
//	public void setNextServiceDate(Date nextServiceDate) {
//		this.nextServiceDate = nextServiceDate;
//	}

//	public Map<String, Double> getServiceType() {
//		return serviceType;
//	}
//
//	public void setServiceType(Map<String, Double> serviceType) {
//		this.serviceType = serviceType;
//	}

//	public UserData getCustomer() {
//		return customer;
//	}

	public void setCustomer(UserData customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Service [jobCardNo=" + jobCardNo + ", currBookingDate=" + currBookingDate + "]";
	}

	public List<AvailableServices> getAvlServices() {
		return avlServices;
	}

	public void setAvlServices(List<AvailableServices> avlServices) {
		this.avlServices = avlServices;
	}
	
	
	//---------------
	
	

}

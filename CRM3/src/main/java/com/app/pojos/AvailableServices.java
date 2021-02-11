package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AvailableServices")
public class AvailableServices {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer serviceId;
	@Column(unique = true)
	private String serviceName;
	@Column
	private String serviceDesc;
	@Column
	private Double servicePrice;
	
//	@ManyToOne
//	private Service jobcard;
	
	public AvailableServices() {
	}


	public AvailableServices(Integer serviceId, String serviceName, String serviceDesc, Double servicePrice) {
		super();
		this.serviceId = serviceId;
		this.serviceName = serviceName;
		this.serviceDesc = serviceDesc;
		this.servicePrice = servicePrice;
	}


	public Integer getServiceId() {
		return serviceId;
	}


	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}


//	public String getServiceName() {
//		return serviceName;
//	}
//
//
//	public void setServiceName(String serviceName) {
//		this.serviceName = serviceName;
//	}


	public String getServiceDesc() {
		return serviceDesc;
	}


	public void setServiceDesc(String serviceDesc) {
		this.serviceDesc = serviceDesc;
	}


	public Double getServicePrice() {
		return servicePrice;
	}


	public void setServicePrice(Double servicePrice) {
		this.servicePrice = servicePrice;
	}


	@Override
	public String toString() {
		return "AvailableServices [serviceId=" + serviceId + ", serviceName=" + serviceName + ", serviceDesc="
				+ serviceDesc + ", servicePrice=" + servicePrice + "]";
	}


//	public Service getJobcard() {
//		return jobcard;
//	}
//
//
//	public void setJobcard(Service jobcard) {
//		this.jobcard = jobcard;
//	}
	
	
	

	
	
}

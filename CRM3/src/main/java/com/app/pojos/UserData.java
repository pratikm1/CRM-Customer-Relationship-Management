package com.app.pojos;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "userdata")
public class UserData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	@Column(length = 320,nullable = false)
	private String username;
	@Column(length = 320, unique = true,nullable = false)
	private String email;
	@Column(length = 320,nullable = false)
	private String password;
	
//Contact Details: 	
	@Column(length = 320,nullable = false)
	private String address;
	@Column(length = 50,nullable = false)
	private String city;
	@Column(length = 50,nullable = false)
	private String state;
	@Column(length = 6,nullable = false)
	private String pincode;
	@Column(length = 10,unique = true,nullable = false)
	private String phoneNumber;
	@Column
	private Date dob;
	
//	@OneToOne(mappedBy = "UserDatafromContDet",cascade = CascadeType.ALL)
//	private ContactDetails conDet;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private UserRole role;
	
	@OneToMany(mappedBy = "customerNewBooking",cascade = CascadeType.ALL)
	private List<NewBooking> booking = new ArrayList<>();
	
	@OneToMany(mappedBy = "testRideUser",cascade = CascadeType.ALL)
	private List<TestRide> testRides = new ArrayList<>();
	
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
	private List<Service> services = new ArrayList<>();
	
	@OneToMany(mappedBy = "customerComplaint",cascade = CascadeType.ALL)
	private List<Complaint> complaints = new ArrayList<>();
	public UserData() {
		
	}
	public UserData(String username, String email, String password, String address, String city, String state,
			String pincode, String phoneNumber, Date dob, UserRole role) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.phoneNumber = phoneNumber;
		this.dob = dob;
		this.role = role;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public ContactDetails getConDet() {
//		return conDet;
//	}
//
//	public void setConDet(ContactDetails conDet) {
//		this.conDet = conDet;
//	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

//	@Override
//	public String toString() {
//		return "UserData [userId=" + userId + ", username=" + username + ", email=" + email + ", password=" + password
//				+ ", role=" + role + "]";
//	}
	
	public List<NewBooking> getBooking() {
		return booking;
	}

	@Override
	public String toString() {
		return "UserData [userId=" + userId + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", address=" + address + ", city=" + city + ", state=" + state + ", pincode=" + pincode
				+ ", phoneNumber=" + phoneNumber + ", dob=" + dob + ", role=" + role + "]";
	}

	public void setBooking(List<NewBooking> booking) {
		this.booking = booking;
	}

	public List<TestRide> getTestRides() {
		return testRides;
	}

	public void setTestRides(List<TestRide> testRides) {
		this.testRides = testRides;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	public List<Complaint> getComplaints() {
		return complaints;
	}

	public void setComplaints(List<Complaint> complaints) {
		this.complaints = complaints;
	}


}

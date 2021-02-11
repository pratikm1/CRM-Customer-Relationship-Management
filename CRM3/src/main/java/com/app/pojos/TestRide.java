package com.app.pojos;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "testrides")
public class TestRide {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "testRide_id")
	private Integer testRideId;
	
	@OneToOne
	@JoinColumn(name = "vehicle_id")
	private Vehicle testRideVehicle;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserData testRideUser;
	
	
	@Column
	private Date testRideDate;
	
//	private Time testRideTimeSlot; //ask for logic of time-slot

	public TestRide() {
	}

	public TestRide(Integer testRideId, Date testRideDate) {
		super();
		this.testRideId = testRideId;
		this.testRideDate = testRideDate;
	}

	public Integer getTestRideId() {
		return testRideId;
	}

	public void setTestRideId(Integer testRideId) {
		this.testRideId = testRideId;
	}

	public Vehicle getTestRideVehicle() {
		return testRideVehicle;
	}

	public void setTestRideVehicle(Vehicle testRideVehicle) {
		this.testRideVehicle = testRideVehicle;
	}

//	public UserData getTestRideUser() {
//		return testRideUser;
//	}

	public void setTestRideUser(UserData testRideUser) {
		this.testRideUser = testRideUser;
	}

	public Date getTestRideDate() {
		return testRideDate;
	}

	public void setTestRideDate(Date testRideDate) {
		this.testRideDate = testRideDate;
	}

	@Override
	public String toString() {
		return "TestRide [testRideId=" + testRideId + ", testRideDate=" + testRideDate + "]";
	}
	
}

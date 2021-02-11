package com.app.pojos;

import java.sql.Date;

import javax.persistence.CascadeType;
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
@Table(name = "new_bookings")
public class NewBooking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "booking_id")
	private Integer bookingId;
	
	@OneToOne
	@JoinColumn(name = "vehicle_id")
	private Vehicle bookedVehicleDetails; //one customer can book many vehicles
	
	@Column(nullable = false)
	private Date bookingDate;
	
	@OneToOne
	@JoinColumn(name = "offer_id")
	private Offers AvailableOffers;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserData customerNewBooking;
	public NewBooking() {
	}
	public NewBooking(Integer bookingId, Date bookingDate, Offers availableOffers) {
		super();
		this.bookingId = bookingId;
		this.bookingDate = bookingDate;
		AvailableOffers = availableOffers;
	}
	public Integer getBookingId() {
		return bookingId;
	}
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	
	  public Vehicle getBookedVehicleDetails() { return bookedVehicleDetails; }
	  public void setBookedVehicleDetails(Vehicle bookedVehicleDetails) {
	  this.bookedVehicleDetails = bookedVehicleDetails; }
	 
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public Offers getAvailableOffers() {
		return AvailableOffers;
	}
	public void setAvailableOffers(Offers availableOffers) {
		AvailableOffers = availableOffers;
	}
//	public UserData getCustomerNewBooking() {
//		return customerNewBooking;
//	}
	public void setCustomerNewBooking(UserData customerNewBooking) {
		this.customerNewBooking = customerNewBooking;
	}
	@Override
	public String toString() {
		return "NewBooking [bookingId=" + bookingId + ", bookingDate=" + bookingDate + ", AvailableOffers="
				+ AvailableOffers + "]";
	}
	
	
}

package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vehicles_list")
public class Vehicle {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vehicle_id")
	private Integer vehicleId;
	@Column(length = 320,nullable = false)
	private String modelName; //vehicle of interest
	@Column(length = 20, nullable = true)
	private String vehicleNumber; //if vehicle is new then it will be NULL else vehicle no will be provided by the customer
	@Column
	private int qty;
	
	@Column
	private double regPrice;
	private double exShowRoomPrice; 
	
	@Column
	private double price; //Should be equal to on-road price = regPrice + exShowRoomPrice
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private Color colour;
	@Column
	private double mileage;
	@Column
	private double cc;
	@Column
	private double fuelcap;
	@Column
	private double torque; //torque in rpm
	
	@Lob
	@Column(length = 1000)
	private byte[] image;
	
	@Column(name = "type")
	private String type;
	
//	@OneToOne()
//	private NewBooking vehicleBooking;

	public Vehicle() {
	}

	public Vehicle(Integer vehicleId, String modelName, String vehicleNumber, int qty, double price, Color colour,
			double mileage, double cc, double fuelcap, double torque, double regPrice, double exShowRoomPrice,
			byte[] image) {
		super();
		this.vehicleId = vehicleId;
		this.modelName = modelName;
		this.vehicleNumber = vehicleNumber;
		this.qty = qty;
		this.price = price;
		this.colour = colour;
		this.mileage = mileage;
		this.cc = cc;
		this.fuelcap = fuelcap;
		this.torque = torque;
		this.regPrice = regPrice;
		this.exShowRoomPrice = exShowRoomPrice;
		this.image = image;
	}

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = this.regPrice + this.exShowRoomPrice;
	}

	public Color getColour() {
		return colour;
	}

	public void setColour(Color colour) {
		this.colour = colour;
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	public double getCc() {
		return cc;
	}

	public void setCc(double cc) {
		this.cc = cc;
	}

	public double getFuelcap() {
		return fuelcap;
	}

	public void setFuelcap(double fuelcap) {
		this.fuelcap = fuelcap;
	}

	public double getTorque() {
		return torque;
	}

	public void setTorque(double torque) {
		this.torque = torque;
	}

	public double getRegPrice() {
		return regPrice;
	}

	public void setRegPrice(double regPrice) {
		this.regPrice = regPrice;
	}

	public double getExShowRoomPrice() {
		return exShowRoomPrice;
	}

	public void setExShowRoomPrice(double exShowRoomPrice) {
		this.exShowRoomPrice = exShowRoomPrice;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
	

//	public NewBooking getVehicleBooking() {
//		return vehicleBooking;
//	}

//	public void setVehicleBooking(NewBooking vehicleBooking) {
//		this.vehicleBooking = vehicleBooking;
//	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", modelName=" + modelName + ", vehicleNumber=" + vehicleNumber
				+ ", qty=" + qty + ", price=" + price + ", colour=" + colour + ", mileage=" + mileage + ", cc=" + cc
				+ ", fuelcap=" + fuelcap + ", torque=" + torque + ", regPrice=" + regPrice + ", exShowRoomPrice="
				+ exShowRoomPrice + "]";
	}
	
}

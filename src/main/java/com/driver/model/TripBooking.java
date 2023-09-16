package com.driver.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class TripBooking{
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tripbookingId;
	
	private String fromLocation;
	
	private String toLocation;
	
	private int distanceInKm;
	
	@Enumerated(EnumType.STRING)
	TripStatus status;
	
	@ManyToOne
	@JoinColumn
	Customer customer;
	
	public TripBooking() {
		super();
	}

	public TripBooking(int bookingId, String fromLocation, String toLocation, int distanceInKm, TripStatus status,
			Customer customer, Driver driver, int bill) {
		super();
		this.tripbookingId = bookingId;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.distanceInKm = distanceInKm;
		this.status = status;
		this.customer = customer;
		this.driver = driver;
		this.bill = bill;
	}

	public int getTripBookingId() {
		return tripbookingId;
	}

	public void setTRripBookingId(int bookingId) {
		this.tripbookingId = bookingId;
	}

	public String getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	public String getToLocation() {
		return toLocation;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	public int getDistanceInKm() {
		return distanceInKm;
	}

	public void setDistanceInKm(int distanceInKm) {
		this.distanceInKm = distanceInKm;
	}

	public TripStatus getStatus() {
		return status;
	}

	public void setStatus(TripStatus status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public int getBill() {
		return bill;
	}

	public void setBill(int bill) {
		this.bill = bill;
	}
	
	@ManyToOne
	@JoinColumn
	Driver driver;
	
	private int bill;
	
	
}
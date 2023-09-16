package com.driver.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;



@Entity
public class Cab{
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	
	private int perKmRate;
	
	private boolean  available;
	
	@OneToOne
    @JoinColumn
	Driver driver;

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public int getId() {
		return Id;
	}

	public void setId(int adminId) {
		this.Id = adminId;
	}

	public int getPerKmRate() {
		return perKmRate;
	}

	public void setPerKmRate(int perKmRate) {
		this.perKmRate = perKmRate;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public Cab(int adminId, int perKmRate, boolean available) {
		super();
		this.Id = adminId;
		this.perKmRate = perKmRate;
		this.available = available;
	}

	public Cab() {
		super();
	}
	
	
}
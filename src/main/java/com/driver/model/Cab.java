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
	private int adminId;
	
	private int perKmRate;
	
	private boolean  avaible;
	
	@OneToOne
    @JoinColumn
	Driver driver;

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public int getPerKmRate() {
		return perKmRate;
	}

	public void setPerKmRate(int perKmRate) {
		this.perKmRate = perKmRate;
	}

	public boolean isAvaible() {
		return avaible;
	}

	public void setAvaible(boolean avaible) {
		this.avaible = avaible;
	}

	public Cab(int adminId, int perKmRate, boolean avaible) {
		super();
		this.adminId = adminId;
		this.perKmRate = perKmRate;
		this.avaible = avaible;
	}

	public Cab() {
		super();
	}
	
	
}
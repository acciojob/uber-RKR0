package com.driver.services.impl;

import com.driver.model.Cab;
import com.driver.repository.CabRepository;
import com.driver.services.DriverService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.driver.model.Driver;
import com.driver.repository.DriverRepository;

@Service
public class DriverServiceImpl implements DriverService {

	@Autowired
	DriverRepository driverRepository3;

	@Autowired
	CabRepository cabRepository3;

	@Override
	public void register(String mobile, String password){
		//Save a driver in the database having given details and a cab with ratePerKm as 10 and availability as True by default.
			Driver d = new Driver();
			d.setMobile(mobile);
			d.setPassword(password);
			
			Cab cab = new Cab();
			
			cab.setAvailable(true);
			cab.setPerKmRate(10);
			
			d.setCab(cab);
			cab.setDriver(d);
			
			driverRepository3.save(d);
	}

	@Override
	public void removeDriver(int driverId){
		// Delete driver without using deleteById function
		driverRepository3.deleteById(driverId);

	}

	@Override
	public void updateStatus(int driverId){
		//Set the status of respective car to unavailable
		Optional<Driver> d = driverRepository3.findById(driverId);
		if(d.isEmpty())
			return;
		cabRepository3.findById(null);
		
	}
}

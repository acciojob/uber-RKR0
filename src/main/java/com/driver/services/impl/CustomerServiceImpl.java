package com.driver.services.impl;

import com.driver.model.TripBooking;
import com.driver.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.driver.model.Cab;
import com.driver.model.Customer;
import com.driver.model.Driver;
import com.driver.repository.CabRepository;
import com.driver.repository.CustomerRepository;
import com.driver.repository.DriverRepository;
import com.driver.repository.TripBookingRepository;
import com.driver.model.TripStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository2;

	@Autowired
	DriverRepository driverRepository2;
	
	@Autowired
	CabRepository cabRepository2;

	@Autowired
	TripBookingRepository tripBookingRepository2;

	@Override
	public void register(Customer customer) {
		//Save the customer in database
		customerRepository2.save(customer);
	}

	@Override
	public void deleteCustomer(Integer customerId) {
		// Delete customer without using deleteById function
		customerRepository2.deleteById(customerId);
	}

	@Override
	public TripBooking bookTrip(int customerId, String fromLocation, String toLocation, int distanceInKm) throws Exception{
		//Book the driver with lowest driverId who is free (cab available variable is Boolean.TRUE). If no driver is available, throw "No cab available!" exception
		//Avoid using SQL query
		TripBooking trip = new TripBooking();
		Optional<Customer> cus=customerRepository2.findById(customerId);
		if(cus.isEmpty())
			return null;
		trip.setToLocation(toLocation);
		trip.setFromLocation(fromLocation);
		trip.setDistanceInKm(distanceInKm);
		trip.setStatus(TripStatus.CONFIRMED);
		
		List<Cab> c = cabRepository2.findByAvailable(true);
		if(c.isEmpty())
			return null;
		Cab cab = c.get(0);
		cab.setAvailable(false);
		cabRepository2.save(cab);
		
		trip.setCustomer(cus.get());
		trip.setDriver(cab.getDriver());
		
		trip.setBill(distanceInKm*cab.getPerKmRate());
		
		TripBooking saved = tripBookingRepository2.save(trip);
		
		cus.get().getTripBookingList().add(saved);
		cab.getDriver().getTripBookingList().add(saved);
		
		return saved;
	}

	@Override
	public void cancelTrip(Integer tripId){
		//Cancel the trip having given trip Id and update TripBooking attributes accordingly
		Optional<TripBooking> trip=tripBookingRepository2.findById(tripId);
		if(trip.isEmpty())
			return;
		TripBooking tt = trip.get();
		tt.setStatus(TripStatus.CANCELED);
		Cab c = cabRepository2.findByDriver(tt.getDriver());
		c.setAvailable(true);
		cabRepository2.save(c);
		tripBookingRepository2.save(tt);
	}
	

	@Override
	public void completeTrip(Integer tripId){
		//Complete the trip having given trip Id and update TripBooking attributes accordingly
		Optional<TripBooking> trip=tripBookingRepository2.findById(tripId);
		if(trip.isEmpty())
			return;
		TripBooking tt = trip.get();
		tt.setStatus(TripStatus.COMPLETED);
		Cab c = cabRepository2.findByDriver(tt.getDriver());
		c.setAvailable(true);
		cabRepository2.save(c);
		tripBookingRepository2.save(tt);
	}
}

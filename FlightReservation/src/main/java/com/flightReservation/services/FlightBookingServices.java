package com.flightReservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightReservation.repository.FlightBookingRepository;

@Service
public class FlightBookingServices {
	
	@Autowired 
	private FlightBookingRepository bookingRepository;
	

}

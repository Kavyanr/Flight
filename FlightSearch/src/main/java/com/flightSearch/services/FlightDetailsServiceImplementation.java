package com.flightSearch.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightSearch.model.FlightDetails;
import com.flightSearch.repository.FlightDetailsRepository;

@Service
public class FlightDetailsServiceImplementation implements FlightDetailsServices {

	
	@Autowired 
	private FlightDetailsRepository flightRepository;

	@Override
	public FlightDetails create(FlightDetails flightDetails) {
		// TODO Auto-generated method stub
		return flightRepository.insert(flightDetails);
	}

	@Override
	public Optional<FlightDetails> getFlight(int flightId) {
		// TODO Auto-generated method stub
		return flightRepository.findById(flightId);
	}

	@Override
	public List<FlightDetails> getAllFlights() {
		// TODO Auto-generated method stub
		return flightRepository.findAll();
	}

	@Override
	public FlightDetails UpdateDetails(int flightId, FlightDetails flightDetails) {
		// TODO Auto-generated method stub
		Optional<FlightDetails> findData = flightRepository.findById(flightId);
		FlightDetails flightData = findData.get();
		flightData.setAirLine(flightDetails.getAirLine());
		flightData.setFromPlace(flightDetails.getFromPlace());
		flightData.setToPlace(flightDetails.getToPlace());
		flightData.setDepartureTime(flightDetails.getDepartureTime());
		flightData.setArrivalTime(flightDetails.getArrivalTime());
		
		return flightRepository.save(flightData);
	}

	@Override
	public void deleteFlight(int flightId) {
		try {
			flightRepository.deleteById(flightId);
		}
		catch (NoSuchElementException e) {
		e.printStackTrace();
		}
	}

	@Override
	public List<FlightDetails> retrieveFlights(String fromPlace, String toPlace) {
		// TODO Auto-generated method stub
		return flightRepository.findByData(fromPlace, toPlace);
	}

	
	
	
	
}
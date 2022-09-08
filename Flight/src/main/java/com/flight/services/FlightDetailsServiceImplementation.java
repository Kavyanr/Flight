package com.flight.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.model.FlightDetails;
import com.flight.repository.FlightDetailsRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@Service
public class FlightDetailsServiceImplementation implements FlightDetailsServices {

	
	@Autowired 
	private FlightDetailsRepository flightRepository;

	@Override
	public Mono<FlightDetails> create(FlightDetails flightDetails) {
		// TODO Auto-generated method stub
		return flightRepository.insert(flightDetails);
	}

	@Override
	public Optional<Mono<FlightDetails>> getFlight(int flightId) {
		return Optional.ofNullable((flightRepository.findById(flightId)));
		//return Mono<FlightDetails> data = flightRepository.findById(flightId).switchIfEmpty(Mono.empty());
	//	FlightDetails flightList = new FlightDetails();
//		  if(flightList.isBlock_flight() == false){
//		   	    return Mono.data;}
//		
	}
	
	@Override
	public Flux<FlightDetails> retrieveFlights(String fromPlace, String toPlace) {
		// TODO Auto-generated method stub
		return flightRepository.findByData(fromPlace, toPlace);
	}

	@Override
	public Flux<FlightDetails> getAllFlights() {
		return flightRepository.findAll().switchIfEmpty(Flux.empty());
	}

	@Override
	public Mono<FlightDetails> UpdateDetails(int flightId, FlightDetails flightDetails) {
		// TODO Auto-generated method stub
		Mono<FlightDetails> findData = flightRepository.findById(flightId).switchIfEmpty(Mono.empty());
		FlightDetails flightData = new FlightDetails();
		flightData.setFlightId(flightDetails.getFlightId());
		flightData.setAirLine(flightDetails.getAirLine());
		flightData.setFromPlace(flightDetails.getFromPlace());
		flightData.setToPlace(flightDetails.getToPlace());
		flightData.setDepartureTime(flightDetails.getDepartureTime());
		flightData.setArrivalTime(flightDetails.getArrivalTime());
		flightData.setBlock_flight(flightDetails.isBlock_flight());
		flightData.setMeal(flightDetails.getMeal());
		return flightRepository.save(flightData);
	}

	@Override
	public Mono<Void> deleteFlight(int flightId) {
		return flightRepository.deleteById(flightId);
	}

	

	
	@Override
	public String blockFlight(int flightId,FlightDetails flightDetails ) {
		Mono<FlightDetails> findData = flightRepository.findById(flightId).switchIfEmpty(Mono.empty());
		FlightDetails flightData = new FlightDetails();
		
			flightData.setFlightId(flightDetails.getFlightId());
			flightData.setAirLine(flightDetails.getAirLine());
			flightData.setFromPlace(flightDetails.getFromPlace());
			flightData.setToPlace(flightDetails.getToPlace());
			flightData.setDepartureTime(flightDetails.getDepartureTime());
			flightData.setArrivalTime(flightDetails.getArrivalTime());
			flightData.setBlock_flight(true);
			flightData.setMeal(flightDetails.getMeal());
		   flightRepository.save(flightData);
		  // flightRepository.deleteById(flightId);
		   return "Flight is blocked";
		
		} 

	@Override
	public String unblockFlight(int flightId,FlightDetails flightDetails ) {
		Mono<FlightDetails> findData = flightRepository.findById(flightId).switchIfEmpty(Mono.empty());
		FlightDetails flightData = new FlightDetails();
		
			flightData.setFlightId(flightDetails.getFlightId());
			flightData.setAirLine(flightDetails.getAirLine());
			flightData.setFromPlace(flightDetails.getFromPlace());
			flightData.setToPlace(flightDetails.getToPlace());
			flightData.setDepartureTime(flightDetails.getDepartureTime());
			flightData.setArrivalTime(flightDetails.getArrivalTime());
			flightData.setBlock_flight(false);
			flightData.setMeal(flightDetails.getMeal());
		   flightRepository.save(flightData);
		  // flightRepository.deleteById(flightId);
		   return "Flight is unblocked";
		}
		
	
	
	
}

package com.flight.services;

import java.util.List;
import java.util.Optional;

import com.flight.model.FlightDetails;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface FlightDetailsServices {
 
	public Mono<FlightDetails> create(FlightDetails flightDetails );
	public Optional<Mono<FlightDetails>> getFlight(int flightId);
	public Flux<FlightDetails> getAllFlights();
	public Flux<FlightDetails> retrieveFlights(String fromPlace, String toPlace);
	public Mono<FlightDetails> UpdateDetails(int flightId,FlightDetails flightDetails);
	public Mono<Void> deleteFlight(int flightId);
	public String blockFlight(int flightId,FlightDetails flightDetails);
	public String unblockFlight(int flightId,FlightDetails flightDetails);

	
}

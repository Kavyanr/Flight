package com.flight.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flight.model.FlightDetails;
import com.flight.services.FlightDetailsServices;





@RestController
@RequestMapping("/api/v1.0/yatra")
public class FlightDetailsController {

	@Autowired
	private FlightDetailsServices flightServices;
	
	@PostMapping(value = "/airlines")
	public FlightDetails AddFlights(@RequestBody FlightDetails flightDetails)
	{
		return flightServices.create(flightDetails);
	
	}
	
	@GetMapping(value = "/flight/search/{flightId}")
	public Optional<FlightDetails> SearchFlight(@PathVariable("flightId") int flightId)
    {
		return flightServices.getFlight(flightId);
		
	}
	
	@GetMapping(value = "/getAllFlight")
	public List<FlightDetails> GetAllFlight() 
	{
		return flightServices.getAllFlights();
	}
	
	@PutMapping(value = "/flight/update/{flightId}")
	public FlightDetails update(@PathVariable int flightId, @RequestBody FlightDetails flightDetails) 
	{
		return flightServices.UpdateDetails(flightId, flightDetails);
	}
	
	@DeleteMapping(value = "/flight/delete/{flightId}")
	public void deleteFlight(@PathVariable int flightId) {
		flightServices.deleteFlight(flightId);
	}
	
	@GetMapping(value = "/flight/search/{fromPlace}/{toPlace}")
	public List<FlightDetails> FindFlights(@PathVariable String fromPlace,@PathVariable String toPlace){
		return flightServices.retrieveFlights(fromPlace, toPlace);
	}
	
}
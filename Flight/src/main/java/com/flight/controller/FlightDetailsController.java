package com.flight.controller;

import java.util.List;
import java.util.Optional;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
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

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;





@RestController
@RequestMapping("/api/v1.0/yatra")
public class FlightDetailsController {
	
	@Autowired
    private KafkaTemplate<String, FlightDetails> kafkaTemplate;
	private static final String TOPIC = "kafka-topic";
    
	@Autowired
	private FlightDetailsServices flightServices;
	
	@PostMapping(value = "/airlines")
	public Mono<FlightDetails> AddFlights(@RequestBody FlightDetails flightDetails)
	{
		kafkaTemplate.send(TOPIC, flightDetails);
		return flightServices.create(flightDetails);
	 }
	
	@GetMapping(value = "/flight/search/{flightId}")
	public Optional<Mono<FlightDetails>> SearchFlight(@PathVariable("flightId") int flightId)
    {
		return flightServices.getFlight(flightId);
		
	}
	
	@GetMapping(value = "/getAllFlight")
	public Flux<FlightDetails> GetAllFlight() 
	{
		return flightServices.getAllFlights();
	}
	
	@PutMapping(value = "/flight/update/{flightId}")
	public Mono<FlightDetails> update(@PathVariable int flightId, @RequestBody FlightDetails flightDetails) 
	{
		kafkaTemplate.send(TOPIC, flightDetails);
		return flightServices.UpdateDetails(flightId, flightDetails);
	}
	
	@DeleteMapping(value = "/flight/delete/{flightId}")
	public Mono<Void> deleteFlight(@PathVariable int flightId) {
		
		return flightServices.deleteFlight(flightId);
	}
	
	@GetMapping(value = "/flight/search/{fromPlace}/{toPlace}")
	public Flux<FlightDetails> FindFlights(@PathVariable String fromPlace,@PathVariable String toPlace){
		return flightServices.retrieveFlights(fromPlace, toPlace);
	}
	
	@PutMapping(value = "/flight/block/{flightId}")
	public String blockFlightById(@PathVariable int flightId, @RequestBody FlightDetails flightDetails) 
	{  
		kafkaTemplate.send(TOPIC, flightDetails);
		return flightServices.blockFlight(flightId, flightDetails);    	
	}
	
	@PutMapping(value = "/flight/unblock/{flightId}")
	public String unblockFlightById(@PathVariable int flightId, @RequestBody FlightDetails flightDetails) 
	{  
		kafkaTemplate.send(TOPIC, flightDetails);
		return flightServices.unblockFlight(flightId, flightDetails);    	
	}
	
}
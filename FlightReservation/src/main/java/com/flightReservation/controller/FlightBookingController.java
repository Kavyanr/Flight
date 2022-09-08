package com.flightReservation.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flightReservation.model.BookingDetails;
import com.flightReservation.model.Passenger;
import com.flightReservation.repository.FlightBookingRepository;
import com.flightReservation.services.EmailService;
import com.flightReservation.services.FlightBookingServices;

@RestController
@RequestMapping("/api/v1.0/flight")
@CrossOrigin("http://localhost:4200")
public class FlightBookingController {
	
	@Autowired
    private KafkaTemplate<String, BookingDetails> kafkaTemplate;
	private static final String TOPIC = "kafka";
	
	@Autowired 
	private FlightBookingServices bookingServices;
	
	
	
	@PostMapping("/booking/{flightId}")
	public String BookTicket(@RequestBody BookingDetails booking, @PathVariable("flightId") int flightId) {
		kafkaTemplate.send(TOPIC, booking);
		return bookingServices.createBooking(booking);		
	}
	
	
	@GetMapping("/ticket/{bookingId}")
	public Optional<BookingDetails> getTickets(@PathVariable("bookingId") long bookingId){
		return bookingServices.getTicketsById(bookingId);
		
		
	}
	
	@GetMapping("/ticket/")
	public List<BookingDetails> retrieveTicketByEmail(@RequestParam("mailId") String mailId){
		return bookingServices.getTicketsByEmail(mailId);
		
		
	}
	
	@DeleteMapping("/cancel/{bookingId}")
	public BookingDetails DeleteTicket (@PathVariable("bookingId") long bookingId){
		return bookingServices.deleteTicketById(bookingId);
		
	}

}

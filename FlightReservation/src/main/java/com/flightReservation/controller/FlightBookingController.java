package com.flightReservation.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

@RestController
@RequestMapping("/api/v1.0/flight")
@CrossOrigin("http://localhost:4200")
public class FlightBookingController {
	
	@Autowired 
	private FlightBookingRepository bookingRepository;
	
	@Autowired 
	private EmailService emailService;
	
	@PostMapping("/booking/{flightId}")
	public String BookTicket(@RequestBody BookingDetails booking, @PathVariable("flightId") int flightId) {
		boolean resultData = bookingRepository.findById(booking.getBookingId()).isPresent();
		if(resultData == false) {
			booking.setTotal_amount(calculateTotalAmount(booking));
			bookingRepository.save(booking);
			String mailId = booking.getEmail();
			return emailService.sendMail(booking,mailId);
		}
		else
		return "Already booking is done";
		
	}
	
	private double calculateTotalAmount(BookingDetails booking) {
		double total_amount = 0;
		List<Passenger> listOfPassengers = booking.getPassenger();
		for(Passenger passenger : listOfPassengers)
		{
			total_amount+= passenger.getAmount();
		}
		return total_amount;
	}

	@GetMapping("/ticket/{bookingId}")
	public Optional<BookingDetails> getTickets(@PathVariable("bookingId") long bookingId){
		try {
			//log.info("Retrieve ticket: " + bookingId);
			return bookingRepository.findById(bookingId);
		}
		catch(Exception e) {
			return bookingRepository.findById(bookingId);
		}
		
	}
	
	@GetMapping("/ticket/")
	public List<BookingDetails> retrieveTicketByEmail(@RequestParam("mailId") String mailId){
		try {
			//log.info("Retrieve ticket: " + bookingId);
			return bookingRepository.findByEmail(mailId);
		}
		catch(Exception e) {
			return bookingRepository.findByEmail(mailId);
		}
		
	}
	
	@DeleteMapping("/cancel/{bookingId}")
	public BookingDetails DeleteTicket (@PathVariable("bookingId") long bookingId){
		BookingDetails dbData = bookingRepository.findById(bookingId).get();
		dbData.setCancel_booking(true);
		bookingRepository.save(dbData);
		if(dbData.isCancel_booking()==true) {
			System.out.println("Ticket cancelled");
			bookingRepository.delete(dbData);
			String mailId = dbData.getEmail();
			return emailService.cancelBooking(dbData, mailId);
		}
		return dbData;
	}

}

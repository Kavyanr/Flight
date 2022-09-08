package com.flightReservation.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightReservation.model.BookingDetails;
import com.flightReservation.model.Passenger;
import com.flightReservation.repository.FlightBookingRepository;

@Service
public class FlightBookingServices {
	
	@Autowired 
	private EmailService emailService;
	
	@Autowired 
	private FlightBookingRepository bookingRepository;

	
	public String createBooking(BookingDetails booking) {
		boolean resultData = bookingRepository.findById(booking.getBookingId()).isPresent();
		if(resultData == false) {
			booking.setTotal_amount(calculateTotalAmount(booking));
			bookingRepository.save(booking);
			String mailId = booking.getEmail();
			emailService.sendMail(booking,mailId);
			return "Booking successfull";
		}
		else
			return "Already booking is done";

		
	}

	public Optional<BookingDetails> getTicketsById(long bookingId) {
    try {
			return bookingRepository.findById(bookingId);
		}
		catch(Exception e) {
			return bookingRepository.findById(bookingId);
		}
	}

	public List<BookingDetails> getTicketsByEmail(String mailId) {
     try {
			return bookingRepository.findByEmail(mailId);
		}
		catch(Exception e) {
			return bookingRepository.findByEmail(mailId);
		}
	}
	
	public BookingDetails deleteTicketById(long bookingId) {
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

	private double calculateTotalAmount(BookingDetails booking) {
		double total_amount = 0;
		List<Passenger> listOfPassengers = booking.getPassenger();
		for(Passenger passenger : listOfPassengers)
		{
			total_amount+= passenger.getAmount();
		}
		return total_amount;
	}


}

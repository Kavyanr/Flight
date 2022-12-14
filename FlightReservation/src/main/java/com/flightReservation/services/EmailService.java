package com.flightReservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.flightReservation.model.BookingDetails;

@Service
public class EmailService {
	
	@Autowired 
	JavaMailSender javaMailSender;
	
	public String sendMail (BookingDetails booking, String mailId) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("kavya1697@gmail.com");
		message.setTo(mailId);
		message.setSubject("Booking Confirmation");
		message.setText("Booking successful with PNR number : " + booking.getBookingId() + " , Passengers : " + booking.getPassenger().size() + " , Departure details : " + booking.getDeparture_date());
		javaMailSender.send(message);
		return "Mail sent successfully";
	}
	
	public BookingDetails cancelBooking(BookingDetails booking, String mailId) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("kavya1697@gmail.com");
		message.setTo(mailId);
		message.setSubject("Ticket cancelled mail");
		message.setText("Booking cancelled for PNR number : " + booking.getBookingId());
		javaMailSender.send(message);
		return booking;
	}

}

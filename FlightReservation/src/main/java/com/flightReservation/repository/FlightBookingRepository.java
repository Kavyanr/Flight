package com.flightReservation.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.flightReservation.model.BookingDetails;

public interface FlightBookingRepository extends MongoRepository<BookingDetails, Long> {
	List<BookingDetails> findByEmail(String mailId);

}

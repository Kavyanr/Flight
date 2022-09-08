package com.flight.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.flight.model.FlightDetails;

import reactor.core.publisher.Flux;



public interface FlightDetailsRepository extends ReactiveMongoRepository<FlightDetails, Integer>{

	@Query("{'fromPlace' : :#{#fromPlace}, 'toPlace' : :#{#toPlace}}")
	Flux<FlightDetails> findByData(@Param("fromPlace") String fromPlace,@Param("toPlace") String toPlace);

	

}

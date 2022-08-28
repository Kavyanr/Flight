package com.flight.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.flight.model.FlightDetails;


@Repository
public interface FlightDetailsRepository extends MongoRepository<FlightDetails, Integer>{

	@Query("{'fromPlace' : :#{#fromPlace}, 'toPlace' : :#{#toPlace}}")
	List<FlightDetails> findByData(@Param("fromPlace") String fromPlace,@Param("toPlace") String toPlace);

	

}

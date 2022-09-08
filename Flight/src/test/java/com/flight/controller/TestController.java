package com.flight.controller;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.web.csrf.CsrfAuthenticationStrategy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.flight.model.FlightDetails;
import com.flight.repository.FlightDetailsRepository;
import com.flight.services.FlightDetailsServices;

import ch.qos.logback.core.status.Status;
import reactor.core.publisher.Mono;

//@WebFluxTest(controllers = FlightDetailsController.class,excludeAutoConfiguration = {ReactiveSecurityAutoConfiguration.class})
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@WithMockUser(username="admin",password="password")
public class TestController {
	
	@Autowired 
	private WebTestClient webTestClient;
	
	@Autowired 
	private FlightDetailsRepository flightRepo;
	
	@Autowired
	 FlightDetailsServices flightServices;
	
	

    @Test
    public void getFlightById() {
    	FlightDetails flight = new FlightDetails(701,"Indigo","Mumbai","Pune","10:30 am","3:30 pm","veg",false);
		Mono<FlightDetails> data = flightRepo.save(flight);
		data.flatMap(result -> {
			webTestClient.get().uri("/flight/search/701")
	    	.accept(MediaType.APPLICATION_JSON).exchange()
	        .expectStatus().isOk().expectHeader().contentType(MediaType.APPLICATION_JSON)
	        .expectBody()
	        .jsonPath("$.flightId").isEqualTo(flight.getFlightId());
			return null;
		});
    }
	
    
    @Test
    public void updateFlightById() throws Exception{
    	FlightDetails flight = new FlightDetails(701,"Indigo","Mumbai","Pune","10:30 am","3:30 pm","veg",false);
		Mono<FlightDetails> data = flightRepo.save(flight);
		data.flatMap(result -> {
			result.setAirLine("Space Jet");
			webTestClient.put().uri("/flight/update/701")
	    	.accept(MediaType.APPLICATION_JSON)
	    	.body(Mono.just(result), FlightDetails.class)
	    	.exchange().expectStatus().isOk().expectHeader().contentType(MediaType.APPLICATION_JSON)
	        .expectBody()
	        .jsonPath("$.airLine").isEqualTo(flight.getAirLine());
			return null;
		});
    }
	
//    @Test
//    public void deleteFlight() throws Exception{
//    	FlightDetails flight = new FlightDetails(701,"Indigo","Mumbai","Pune","10:30 am","3:30 pm","veg",false);
//    	webTestClient.delete().uri("/flight/delete/701")
//    	.accept(MediaType.APPLICATION_JSON)
//    	.exchange().expectStatus().isOk().expectHeader().contentType(MediaType.APPLICATION_JSON)
//        .expectBody();
//    }
    
    
   
}
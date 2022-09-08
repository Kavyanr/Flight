package com.flightReservation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection= "flight")
public class FlightDetails {
    @Id
	private int flightId;
	private String airline;
	private String fromPlace;
	private String toPlace;
	private String departureTime;
	private String arrivalTime;
	private String meal;
	private boolean block_flight=false;
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public String getFromPlace() {
		return fromPlace;
	}
	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}
	public String getToPlace() {
		return toPlace;
	}
	public void setToPlace(String toPlace) {
		this.toPlace = toPlace;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getMeal() {
		return meal;
	}
	public void setMeal(String meal) {
		this.meal = meal;
	}
	public boolean isBlock_flight() {
		return block_flight;
	}
	public void setBlock_flight(boolean block_flight) {
		this.block_flight = block_flight;
	}
	@Override
	public String toString() {
		return "FlightDetails [flightId=" + flightId + ", airline=" + airline + ", fromPlace=" + fromPlace
				+ ", toPlace=" + toPlace + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime
				+ ", meal=" + meal + ", block_flight=" + block_flight + "]";
	}
	public FlightDetails(int flightId, String airline, String fromPlace, String toPlace, String departureTime,
			String arrivalTime, String meal, boolean block_flight) {
		super();
		this.flightId = flightId;
		this.airline = airline;
		this.fromPlace = fromPlace;
		this.toPlace = toPlace;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.meal = meal;
		this.block_flight = block_flight;
	}

	
	
}

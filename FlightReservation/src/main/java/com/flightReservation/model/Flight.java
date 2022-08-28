package com.flightReservation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection= "flight")
public class Flight {
    @Id
	private int flightId;
	private String airline;
	private String fromPlace;
	private String toPlace;
	private String departureTime;
	private String arrivalTime;
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
	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", airline=" + airline + ", fromPlace=" + fromPlace + ", toPlace="
				+ toPlace + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + "]";
	}
	public Flight(int flightId, String airline, String fromPlace, String toPlace, String departureTime,
			String arrivalTime) {
		super();
		this.flightId = flightId;
		this.airline = airline;
		this.fromPlace = fromPlace;
		this.toPlace = toPlace;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}
	
	
}

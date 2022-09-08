package com.flight.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "flight_Details")
public class FlightDetails {
    @Id
	private int flightId;
	private String airLine;
	private String fromPlace;
	private String toPlace;
	private String departureTime;
	private String arrivalTime;
	private String Meal;
	
	private boolean block_flight = false;
	
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public String getAirLine() {
		return airLine;
	}
	public void setAirLine(String airLine) {
		this.airLine = airLine;
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
		return Meal;
	}
	public void setMeal(String meal) {
		Meal = meal;
	}
	public boolean isBlock_flight() {
		return block_flight;
	}
	public void setBlock_flight(boolean block_flight) {
		this.block_flight = block_flight;
	}
	@Override
	public String toString() {
		return "FlightDetails [flightId=" + flightId + ", airLine=" + airLine + ", fromPlace=" + fromPlace
				+ ", toPlace=" + toPlace + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime
				+ ", Meal=" + Meal + ", block_flight=" + block_flight + "]";
	}
	public FlightDetails(int flightId, String airLine, String fromPlace, String toPlace, String departureTime,
			String arrivalTime, String meal, boolean block_flight) {
		super();
		this.flightId = flightId;
		this.airLine = airLine;
		this.fromPlace = fromPlace;
		this.toPlace = toPlace;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		Meal = meal;
		this.block_flight = block_flight;
	}
	public FlightDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}

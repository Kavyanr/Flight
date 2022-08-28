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
	@Override
	public String toString() {
		return "FlightDetails [flightId=" + flightId + ", airLine=" + airLine + ", fromPlace=" + fromPlace
				+ ", toPlace=" + toPlace + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + "]";
	}
	public FlightDetails(int flightId, String airLine, String fromPlace, String toPlace, String departureTime,
			String arrivalTime) {
		super();
		this.flightId = flightId;
		this.airLine = airLine;
		this.fromPlace = fromPlace;
		this.toPlace = toPlace;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}
	
	
	
	
}
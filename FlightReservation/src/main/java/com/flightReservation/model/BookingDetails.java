package com.flightReservation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Booking")
public class BookingDetails {

	@Id
	private long bookingId;
	private String departure_date;
	private String email;
	private double total_amount;
	private boolean cancel_booking=false;
	private boolean payment_completed = false;
	@DBRef
	private FlightDetails flight;
	private List<Passenger> passenger = new ArrayList<>();
	
	
	
	public long getBookingId() {
		return bookingId;
	}
	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}
	public String getDeparture_date() {
		return departure_date;
	}
	public void setDeparture_date(String departure_date) {
		this.departure_date = departure_date;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public FlightDetails getFlight() {
		return flight;
	}
	public void setFlight(FlightDetails flight) {
		this.flight = flight;
	}
	public List<Passenger> getPassenger() {
		return passenger;
	}
	public void setPassenger(List<Passenger> passenger) {
		this.passenger = passenger;
	}
	public double getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}
	public boolean isCancel_booking() {
		return cancel_booking;
	}
	public void setCancel_booking(boolean cancel_booking) {
		this.cancel_booking = cancel_booking;
	}
	public boolean isPayment_completed() {
		return payment_completed;
	}
	public void setPayment_completed(boolean payment_completed) {
		this.payment_completed = payment_completed;
	}
	@Override
	public String toString() {
		return "BookingDetails [bookingId=" + bookingId + ", departure_date=" + departure_date + ", email=" + email
				+ ", flight=" + flight + ", passenger=" + passenger + ", total_amount=" + total_amount
				+ ", cancel_booking=" + cancel_booking + ", payment_completed=" + payment_completed
				+ ", getBookingId()=" + getBookingId() + ", getDeparture_date()=" + getDeparture_date()
				+ ", getEmail()=" + getEmail() + ", getFlight()=" + getFlight() + ", getPassenger()=" + getPassenger()
				+ ", getTotal_amount()=" + getTotal_amount() + ", isCancel_booking()=" + isCancel_booking()
				+ ", isPayment_completed()=" + isPayment_completed() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	public BookingDetails(long bookingId, String departure_date, String email, FlightDetails flight, List<Passenger> passenger,
			double total_amount, boolean cancel_booking, boolean payment_completed) {
		super();
		this.bookingId = bookingId;
		this.departure_date = departure_date;
		this.email = email;
		this.flight = flight;
		this.passenger = passenger;
		this.total_amount = total_amount;
		this.cancel_booking = cancel_booking;
		this.payment_completed = payment_completed;
	}
	public BookingDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}

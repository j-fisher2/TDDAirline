package com.ontariotechu.sofe3980U;
import java.util.ArrayList;

public class Booking {
    private String bookingNumber;
    private ArrayList<Flight> flights;
    private ArrayList<Passenger> passengers;
    private boolean isRoundTrip;
    private boolean isDirectFlight;
    private Timezone userTimezone;

    // Constructor
    public Booking(String bookingNumber, ArrayList<Flight> flights, ArrayList<Passenger> passengers, boolean isRoundTrip, boolean isDirectFlight, Timezone userTimezone) {
            this.bookingNumber = bookingNumber;
            this.flights = flights;
            this.passengers = passengers;
            this.isRoundTrip = isRoundTrip;
            this.isDirectFlight = isDirectFlight;
            this.userTimezone = userTimezone;
    }

    public String getBookingNumber() {
        return this.bookingNumber;
    }

    public ArrayList<Flight> getFlights() {
        return this.flights;
    }

    public ArrayList<Passenger> getPassengers() {
        return this.passengers;
    }

    public boolean isRoundTrip() {
        return this.isRoundTrip;
    }

    public boolean isDirectFlight() {
        return this.isDirectFlight;
    }

    public Timezone getUserTimezone() {
        return this.userTimezone;
    }

    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public void setFlights(ArrayList<Flight> flights) {
        this.flights = flights;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }

    public void setRoundTrip(boolean roundTrip) {
        this.isRoundTrip = roundTrip;
    }

    public void setDirectFlight(boolean directFlight) {
        this.isDirectFlight = directFlight;
    }

    public void setUserTimezone(Timezone userTimezone) {
        this.userTimezone = userTimezone;
    }
    public void addFlight(Flight f){
        this.flights.add(f);
    }
    public void addPassenger(Passenger p){
        this.passengers.add(p);
    }
}

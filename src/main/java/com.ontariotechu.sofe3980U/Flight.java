package com.ontariotechu.sofe3980U;

public class Flight {
    private String flightNumber;
    private Airport departureAirport;
    private Airport arrivalAirport;
    private String departureTime;
    private String arrivalTime;
    private int flightDuration;
    private Timezone departureTimezone;
    private Timezone arrivalTimezone;

    // Constructor
    public Flight(String flightNumber, Airport departureAirport, Airport arrivalAirport, 
                  String departureTime, String arrivalTime, int flightDuration, 
                  Timezone departureTimezone, Timezone arrivalTimezone) {
                    if(departureAirport==arrivalAirport){
                        throw new IllegalArgumentException("Cyclic trip");
                    }
        this.flightNumber = flightNumber;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.flightDuration = flightDuration;
        this.departureTimezone = departureTimezone;
        this.arrivalTimezone = arrivalTimezone;
    }

    // Getters
    public String getFlightNumber() {
        return this.flightNumber;
    }

    public Airport getDepartureAirport() {
        return this.departureAirport;
    }

    public Airport getArrivalAirport() {
        return this.arrivalAirport;
    }

    public String getDepartureTime() {
        return this.departureTime;
    }

    public String getArrivalTime() {
        return this.arrivalTime;
    }

    public int getFlightDuration() {
        return this.flightDuration;
    }

    public Timezone getDepartureTimezone() {
        return this.departureTimezone;
    }

    public Timezone getArrivalTimezone() {
        return this.arrivalTimezone;
    }

    // Setters
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setFlightDuration(int flightDuration) {
        this.flightDuration = flightDuration;
    }

    public void setDepartureTimezone(Timezone departureTimezone) {
        this.departureTimezone = departureTimezone;
    }

    public void setArrivalTimezone(Timezone arrivalTimezone) {
        this.arrivalTimezone = arrivalTimezone;
    }
}

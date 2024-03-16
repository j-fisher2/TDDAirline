package com.ontariotechu.sofe3980U;

public class Ticket {
    private String ticketNumber;
    private Flight flight;
    private Passenger passenger;

    public Ticket(String ticketNumber, Flight flight, Passenger passenger) {
        this.ticketNumber = ticketNumber;
        this.flight = flight;
        this.passenger = passenger;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public Flight getFlight() {
        return flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    // Setters
    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}

package com.ontariotechu.sofe3980U;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class UnitTests {

    @Test
    public void testBookingConstruction() {
        Timezone timezone = new Timezone("GMT", 0);
        ArrayList<Flight> flights = new ArrayList<>();
        ArrayList<Passenger> passengers = new ArrayList<>();
        Booking booking = new Booking("123456", flights, passengers, true, true, timezone);
        assertEquals("123456", booking.getBookingNumber());
        assertEquals(flights, booking.getFlights());
        assertEquals(passengers, booking.getPassengers());
        assertTrue(booking.isRoundTrip());
        assertTrue(booking.isDirectFlight());
    }

    @Test
    public void testTimezoneConstruction() {
        Timezone timezone = new Timezone("GMT", 0);
        assertEquals("GMT", timezone.getTimezoneName());
        assertEquals(0, timezone.getUtcOffset());
    }

    @Test
    public void testTimezoneConversion() {
        Timezone sourceTimezone = new Timezone("EST", -300);
        Timezone targetTimezone = new Timezone("PST", -480);
        assertEquals("22:00", TimeConverter.convertTime("10:00", sourceTimezone, targetTimezone));
    }

    @Test
    public void testCountryConstruction() {
        Country country = new Country("US", "United States");
        assertEquals("US", country.getCountryCode());
        assertEquals("United States", country.getCountryName());
    }

    @Test
    public void testFlightConstruction() {
        Timezone timezone = new Timezone("EST", -300);
        Timezone timezone2=new Timezone("PST",-480);
        Country country = new Country("US", "United States");
        ArrayList<Flight> flights = new ArrayList<>();
        Airport departureAirport = new Airport("JFK", new City("New York", timezone, country), flights);
        Airport arrivalAirport = new Airport("LAX", new City("Los Angeles", timezone2, country), flights);
        Flight flight = new Flight("123", departureAirport, arrivalAirport, "10:00", "13:00", 180, timezone, timezone);

        assertEquals("123", flight.getFlightNumber());
        assertEquals(departureAirport, flight.getDepartureAirport());
        assertEquals(arrivalAirport, flight.getArrivalAirport());
        assertEquals("10:00", flight.getDepartureTime());
        assertEquals("13:00", flight.getArrivalTime());
        assertEquals(180, flight.getFlightDuration());
        assertEquals(timezone, flight.getDepartureTimezone());
        assertEquals(timezone, flight.getArrivalTimezone());
    }

    @Test
    public void testUserConstruction() {
        Preferences preferences = new Preferences(true);
        User user = new User("john_doe", "password123", preferences);
        assertEquals("john_doe", user.getUsername());
        assertEquals("password123", user.getPassword());
        assertEquals(preferences, user.getPreferences());
    }

    @Test
    public void testTicketConstruction() {
        Timezone timezone = new Timezone("EST", -300);
        Country country = new Country("US", "United States");
        ArrayList<Flight> flights = new ArrayList<>();
        Airport departureAirport = new Airport("JFK", new City("New York", timezone, country), flights);
        Airport arrivalAirport = new Airport("LAX", new City("Los Angeles", timezone, country), flights);
        Flight flight = new Flight("123", departureAirport, arrivalAirport, "10:00", "13:00", 180, new Timezone("EST", -300), new Timezone("PST", -480));
        Passenger passenger = new Passenger("John Doe", 30);
        Ticket ticket = new Ticket("T123", flight, passenger);
        assertEquals("T123", ticket.getTicketNumber());
        assertEquals(flight, ticket.getFlight());
        assertEquals(passenger, ticket.getPassenger());
    }

    @Test
    public void testPassengerConstruction() {
        Passenger passenger = new Passenger("John Doe", 30);
        assertEquals("John Doe", passenger.getName());
        assertEquals(30, passenger.getAge());
    }

    @Test
    public void testPreferencesConstruction() {
        Preferences preferences = new Preferences(true);
        assertTrue(preferences.getPreference());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCyclicTrip() {
        Timezone timezone = new Timezone("EST", -300);
        Country country = new Country("US", "United States");
        Airport departureAirport = new Airport("JFK", new City("New York", timezone, country), new ArrayList<>());
        Airport arrivalAirport = departureAirport; // Setting arrival airport to the same as departure airport
        
        //should throw error
        Flight flight = new Flight("123", departureAirport, arrivalAirport, "10:00", "13:00", 180, timezone, timezone);
    }
    @Test
    public void test24HourTimeConversion(){
        String time="19:00";
        String converted_time=TimeConverter.convert24HourTime(time);
        assertEquals("7:00 pm", converted_time);
    }
    @Test
    public void test12HourTimeConversion(){
        String time="7:00 pm";
        String converted_time=TimeConverter.convert12HourTime(time);
        assertEquals("19:00",converted_time);
    }
    @Test
    public void testAirportFlightAddition(){
        ArrayList<Flight> flights=new ArrayList<>();
        ArrayList<Flight> comparison=new ArrayList<>();
        Timezone timezone = new Timezone("EST", -300); //mock timezone
        Country country= new Country("US","United States"); //mock country
        Airport departureAirport = new Airport("JFK", new City("New York", timezone, country), flights);
        Airport arrivalAirport = new Airport("LAX", new City("Los Angeles", timezone, country), flights);
        Flight flight = new Flight("123", departureAirport, arrivalAirport, "10:00", "13:00", 180, new Timezone("EST", -300), new Timezone("PST", -480));

        comparison.add(flight);
        departureAirport.addFlight(flight);

        // Convert ArrayLists to arrays for comparison
        Flight[] comparisonArray = comparison.toArray(new Flight[0]);
        Flight[] actualArray = departureAirport.getFlights().toArray(new Flight[0]);

        assertArrayEquals(comparisonArray, actualArray);

    }
    @Test
    public void testBookingFlightAddition(){
        Timezone timezone = new Timezone("GMT", 0);
        ArrayList<Flight> flights = new ArrayList<>();
        ArrayList<Passenger> passengers = new ArrayList<>();
        Booking booking = new Booking("123456", flights, passengers, true, true, timezone);

        Country country= new Country("US","United States"); //mock country
        Airport departureAirport = new Airport("JFK", new City("New York", timezone, country), flights);
        Airport arrivalAirport = new Airport("LAX", new City("Los Angeles", timezone, country), flights);
        Flight flight = new Flight("123", departureAirport, arrivalAirport, "10:00", "13:00", 180, new Timezone("EST", -300), new Timezone("PST", -480));

        flights.add(flight);
        booking.addFlight(flight);

        Flight[] comparisonArray = flights.toArray(new Flight[0]);
        Flight[] actualArray = booking.getFlights().toArray(new Flight[0]);

        assertArrayEquals(comparisonArray, actualArray);
    }
}

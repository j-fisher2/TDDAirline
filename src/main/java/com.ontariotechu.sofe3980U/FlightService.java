package com.ontariotechu.sofe3980U;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class FlightService {
    private static Map<String, Integer> flightCount = new FlightDatabase().getFlightCounts();

    // This method simulates searching for flights based on the submitted criteria
    public static List<Flight> searchFlights(String flightType, String flyingFrom, String flyingTo,
                                             String departing) {
        List<Flight> searchResults = new ArrayList<>();
        // Get all flights from the database
        List<Flight> allFlights = new FlightDatabase().getAllFlights();

        // Parse departing and returning dates
        LocalDate departingDate = LocalDate.parse(departing);

        // Iterate through all flights to filter based on input parameters
        for (Flight flight : allFlights) {
            // Filter flights based on departure and arrival airports
            if (flight.getDepartureAirport().getCity().name.equalsIgnoreCase(flyingFrom) &&
                    flight.getArrivalAirport().getCity().name.equalsIgnoreCase(flyingTo)) {
                // Check if flight count is greater than 0
                if (flightCount.containsKey(flight.getFlightNumber()) && flightCount.get(flight.getFlightNumber()) > 0) {
                    searchResults.add(flight);
                }
            }
            // For round trips, also consider return flights
            if ("roundtrip".equals(flightType)) {
                if (flight.getDepartureAirport().getCity().name.equalsIgnoreCase(flyingTo) &&
                        flight.getArrivalAirport().getCity().name.equalsIgnoreCase(flyingFrom)) {
                    // Check if flight count is greater than 0
                    if (flightCount.containsKey(flight.getFlightNumber()) && flightCount.get(flight.getFlightNumber()) > 0) {
                        searchResults.add(flight);
                    }
                }
            }
        }
        return searchResults;
    }
    public static void decrement(String flightNumber) {
        if (flightCount.containsKey(flightNumber)) {
            int count = flightCount.get(flightNumber);
            if (count > 0) {
                flightCount.put(flightNumber, count - 1);
            }
            System.out.println(flightCount.get(flightNumber));
        }
    }
}

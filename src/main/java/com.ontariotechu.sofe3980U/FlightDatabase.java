package com.ontariotechu.sofe3980U;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class FlightDatabase {
    private static List<Flight> flights = new ArrayList<>();
    private static Map<String, Integer> flightCounts = new HashMap<>();

    public FlightDatabase() {
        // Create Timezone instances
        Timezone torontoTimezone = new Timezone("EST", -5);
        Timezone losAngelesTimezone = new Timezone("PST", -8);
        Timezone londonTimezone = new Timezone("GMT", 0);

        // Create Country instances
        Country canada = new Country("CA", "Canada");
        Country usa = new Country("US", "USA");
        Country uk = new Country("UK", "United Kingdom");
        Country france = new Country("FR", "France");
        Country germany = new Country("DE", "Germany");
        Country australia = new Country("AU", "Australia");

        // Create City instances with all required arguments
        City toronto = new City("Toronto", torontoTimezone, canada);
        City losAngeles = new City("Los Angeles", losAngelesTimezone, usa);
        City london = new City("London", londonTimezone, uk);
        City paris = new City("Paris", new Timezone("CET", 1), france);
        City berlin = new City("Berlin", new Timezone("CET", 1), germany);
        City sydney = new City("Sydney", new Timezone("AEST", 10), australia);

        // Create Airport instances
        Airport yyzAirport = new Airport("YYZ", toronto, new ArrayList<>());
        Airport laxAirport = new Airport("LAX", losAngeles, new ArrayList<>());
        Airport lhrAirport = new Airport("LHR", london, new ArrayList<>());
        Airport cdgAirport = new Airport("CDG", paris, new ArrayList<>());
        Airport txlAirport = new Airport("TXL", berlin, new ArrayList<>());
        Airport sydAirport = new Airport("SYD", sydney, new ArrayList<>());

        // Create Flight instances and add them to the flights list
        Flight flight1 = new Flight("ABC123", yyzAirport, laxAirport,
                "2024-04-01 08:00:00", "2024-04-01 10:30:00", 150,
                new Timezone("EST", -5), new Timezone("PST", -8));

        Flight flight2 = new Flight("DEF456", laxAirport, yyzAirport,
                "2024-04-02 12:00:00", "2024-04-02 14:30:00", 150,
                new Timezone("PST", -8), new Timezone("EST", -5));

        Flight flight3 = new Flight("GHI789", yyzAirport, lhrAirport,
                "2024-04-03 08:00:00", "2024-04-03 16:30:00", 450,
                new Timezone("EST", -5), new Timezone("GMT", 0));

        Flight flight4 = new Flight("JKL012", laxAirport, lhrAirport,
                "2024-04-04 12:00:00", "2024-04-04 20:30:00", 450,
                new Timezone("PST", -8), new Timezone("GMT", 0));

        Flight flight5 = new Flight("MNO345", lhrAirport, yyzAirport,
                "2024-04-05 08:00:00", "2024-04-05 16:30:00", 450,
                new Timezone("GMT", 0), new Timezone("EST", -5));

        Flight flight6 = new Flight("PQR678", lhrAirport, laxAirport,
                "2024-04-06 12:00:00", "2024-04-06 20:30:00", 450,
                new Timezone("GMT", 0), new Timezone("PST", -8));

        Flight flight7 = new Flight("STU901", cdgAirport, txlAirport,
                "2024-04-07 10:00:00", "2024-04-07 12:30:00", 120,
                new Timezone("CET", 1), new Timezone("CET", 1));

        Flight flight8 = new Flight("VWX234", txlAirport, cdgAirport,
                "2024-04-08 14:00:00", "2024-04-08 16:30:00", 120,
                new Timezone("CET", 1), new Timezone("CET", 1));
        
        Flight flight11 = new Flight("VWX234", cdgAirport, txlAirport,
            "2024-04-08 18:00:00", "2024-04-08 20:30:00", 120,
            new Timezone("CET", 1), new Timezone("CET", 1));
    

        Flight flight9 = new Flight("YZA567", lhrAirport, sydAirport,
                "2024-04-09 16:00:00", "2024-04-10 10:30:00", 1020,
                new Timezone("GMT", 0), new Timezone("AEST", 10));

        Flight flight10 = new Flight("BCD890", sydAirport, lhrAirport,
                "2024-04-11 14:00:00", "2024-04-12 06:30:00", 1020,
                new Timezone("AEST", 10), new Timezone("GMT", 0));
        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);
        flights.add(flight4);
        flights.add(flight5);
        flights.add(flight6);
        flights.add(flight7);
        flights.add(flight8);
        flights.add(flight9);
        flights.add(flight10);
        flights.add(flight11);

        flightCounts.put("ABC123", 50);
        flightCounts.put("DEF456", 50);
        flightCounts.put("GHI789", 50);
        flightCounts.put("JKL012", 50);
        flightCounts.put("MNO345", 50);
        flightCounts.put("PQR678", 50);
        flightCounts.put("STU901", 50);
        flightCounts.put("VWX234", 50);
        flightCounts.put("YZA567", 50);
        flightCounts.put("BCD890", 50);
    }

    // Get all flights from the database
    public static List<Flight> getAllFlights() {
        return flights;
    }
    public static Map<String, Integer> getFlightCounts(){
        return flightCounts;
    }
}




package com.ontariotechu.sofe3980U;
import java.util.ArrayList;

public class Airport {
    private String airportCode;
    private City city;
    private ArrayList<Flight>flight_list;

    public Airport(String airportCode, City city, ArrayList<Flight>flight_list){
		this.airportCode=airportCode;
		this.city=city;
		this.flight_list=flight_list;

    }
    public ArrayList<Flight> getFlights(){
        return this.flight_list;
    }
    public String getCode(){
	    return this.airportCode;
    }
    public void setCode(String code){
	    this.airportCode=code;
    }
    public City getCity(){
	    return this.city;
    }
    public void setCity(City city){
	    this.city=city;
    }
    public void addFlight(Flight flight){
        this.flight_list.add(flight);
    }
}
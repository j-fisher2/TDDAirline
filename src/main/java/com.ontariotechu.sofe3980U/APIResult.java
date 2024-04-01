package com.ontariotechu.sofe3980U;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import com.ontariotechu.sofe3980U.Flight;
import com.ontariotechu.sofe3980U.FlightService;

import java.util.List;

@RestController
public class APIResult {
    @PostMapping("/decrement-flights")
    public void decrementFlights(@RequestBody Map<String, Object> payload) {
        // Extract selected flights from the payload
        List<String> selectedFlights = (List<String>) payload.get("selectedFlights");
        
        // Perform flight count decrement logic here
        for (String flightNumber : selectedFlights) {
            FlightService.decrement(flightNumber);
        }
        
    }
}



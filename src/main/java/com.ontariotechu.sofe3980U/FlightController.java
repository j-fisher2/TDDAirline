package com.ontariotechu.sofe3980U;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class FlightController {

	@GetMapping("/")
	public String getHome(@RequestParam(name="operand1", required=false, defaultValue="") String operand1, Model model) {
        return "hello";
	}
	@GetMapping("/search")
	public String search(Model model){
		model.addAttribute("searchResults",null);
		return "Booking";
	}
	@RequestMapping("/flight-search")
    public ModelAndView showForm() {
        return new ModelAndView("flight-search-form", "flightSearchForm", new FlightSearchForm());
    }
	@PostMapping("/search-flight")
    public String searchFlights(@RequestParam(name="flightType") String flightType,
                                @RequestParam(name="flyingFrom") String flyingFrom,
                                @RequestParam(name="flyingTo") String flyingTo,
                                @RequestParam(name="departing") String departing,
                                Model model) {
        List<Flight> searchResults = new FlightService().searchFlights(flightType, flyingFrom, flyingTo, departing);
		model.addAttribute("searchResults",searchResults);
        return "search-results";
    }
    @PostMapping("/purchase")
	public String purchaseFlight(@RequestParam("selectedFlights") String selectedFlights, Model model) {
		// Split the comma-separated string of flight numbers
		String[] selectedFlightNumbers = selectedFlights.split(",");
		// Add flight details to the model
		model.addAttribute("selectedFlights", selectedFlightNumbers);
		// Return the view name
		System.out.println(selectedFlights);
		return "passenger-form";
	}
	@PostMapping("/submitPassengerForm")
    public String submitPassengerForm(Passenger passenger, Model model) {
        model.addAttribute("passenger", passenger);
        System.out.println(passenger.getName());
        // Return the name of the result page
        return "purchase-form";
    }
	@PostMapping("/tickets")
	public String getTickets(Model model){
		return "tickets";
	}

}
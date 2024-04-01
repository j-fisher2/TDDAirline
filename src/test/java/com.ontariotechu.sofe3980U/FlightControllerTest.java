package com.ontariotechu.sofe3980U;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

public class FlightControllerTest {

    private FlightController flightController;
    private Model modelMock;

    @Before
    public void setUp() {
        flightController = new FlightController();
        modelMock = mock(Model.class);
    }

    @Test
    public void testGetHome() {
        String result = flightController.getHome("", modelMock);
        assert(result.equals("hello"));
    }

    @Test
    public void testSearch() {
        String result = flightController.search(modelMock);
        verify(modelMock).addAttribute("searchResults", null);
        assert(result.equals("Booking"));
    }

    @Test
    public void testShowForm() {
        ModelAndView modelAndView = flightController.showForm();
        assert(modelAndView.getViewName().equals("flight-search-form"));
        assert(modelAndView.getModel().get("flightSearchForm") != null);
    }

    @Test
    public void testPurchaseFlight() {
        String selectedFlights = "ABC123,DEF456,GHI789";
        String[] selectedFlightNumbers = selectedFlights.split(",");

        String result = flightController.purchaseFlight(selectedFlights, modelMock);

        verify(modelMock).addAttribute("selectedFlights", selectedFlightNumbers);
        assert(result.equals("passenger-form"));
    }

    @Test
    public void testSubmitPassengerForm() {
        Passenger passenger = new Passenger("John Doe", 30);

        String result = flightController.submitPassengerForm(passenger, modelMock);

        verify(modelMock).addAttribute("passenger", passenger);
        assert(result.equals("purchase-form"));
    }

    @Test
    public void testGetTickets() {
        String result = flightController.getTickets(modelMock);
        assert(result.equals("tickets"));
    }
}

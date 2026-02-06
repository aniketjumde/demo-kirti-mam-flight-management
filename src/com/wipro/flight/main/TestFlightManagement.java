package com.wipro.flight.main;

import com.wipro.flight.bean.Flight;
import com.wipro.flight.service.FlightService;

public class TestFlightManagement {
    
    public static void main(String[] args) {
        // Create FlightService object
        FlightService flightService = new FlightService();
        
        // Test Case 1: Create a valid flight
        System.out.println("=== Test Case 1: Create Valid Flight ===");
        Flight flight1 = new Flight();
        flight1.setFlightName("Indigo");
        flight1.setSource("Mumbai");
        flight1.setDestination("Delhi");
        flight1.setEconomySeats(50);
        flight1.setBusinessSeats(20);
        flight1.setFirstClassSeats(10);
        flight1.setFlightType("Domestic");
        
        String result1 = flightService.createFlight(flight1);
        System.out.println("Result: " + result1);
        System.out.println("Generated Flight ID: " + flight1.getFlightID());
        System.out.println();
        
        // Test Case 2: Create another valid flight
        System.out.println("=== Test Case 2: Create Another Valid Flight ===");
        Flight flight2 = new Flight();
        flight2.setFlightName("SpiceJet");
        flight2.setSource("Bangalore");
        flight2.setDestination("Hyderabad");
        flight2.setEconomySeats(60);
        flight2.setBusinessSeats(15);
        flight2.setFirstClassSeats(5);
        flight2.setFlightType("Domestic");
        
        String result2 = flightService.createFlight(flight2);
        System.out.println("Result: " + result2);
        System.out.println("Generated Flight ID: " + flight2.getFlightID());
        System.out.println();
        
        // Test Case 3: Create an international flight
        System.out.println("=== Test Case 3: Create International Flight ===");
        Flight flight3 = new Flight();
        flight3.setFlightName("Emirates");
        flight3.setSource("Dubai");
        flight3.setDestination("New York");
        flight3.setEconomySeats(80);
        flight3.setBusinessSeats(30);
        flight3.setFirstClassSeats(20);
        flight3.setFlightType("International");
        
        String result3 = flightService.createFlight(flight3);
        System.out.println("Result: " + result3);
        System.out.println("Generated Flight ID: " + flight3.getFlightID());
        System.out.println();
        
        // Test Case 4: Test with null flight object
        System.out.println("=== Test Case 4: Test with Null Flight ===");
        String result4 = flightService.createFlight(null);
        System.out.println("Result: " + result4);
        System.out.println();
        
        // Test Case 5: Test with invalid flight name (less than 2 characters)
        System.out.println("=== Test Case 5: Test with Invalid Flight Name ===");
        Flight flight5 = new Flight();
        flight5.setFlightName("A");
        flight5.setSource("Chennai");
        flight5.setDestination("Kolkata");
        flight5.setEconomySeats(45);
        flight5.setBusinessSeats(15);
        flight5.setFirstClassSeats(10);
        flight5.setFlightType("Domestic");
        
        String result5 = flightService.createFlight(flight5);
        System.out.println("Result: " + result5);
        System.out.println();
    }
}

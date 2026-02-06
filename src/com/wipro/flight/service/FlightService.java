package com.wipro.flight.service;

import com.wipro.flight.bean.Flight;
import com.wipro.flight.dao.FlightDAO;

public class FlightService {
    
    public String createFlight(Flight flight) {
        // Check if flight object is null
        if (flight == null) {
            return "FAIL";
        }
        
        FlightDAO flightDAO = new FlightDAO();
        
        // Generate flight ID
        String flightID = flightDAO.getComputedId(flight.getFlightName(), "FlightId_Seq");
        
        // Check if flight ID generation failed
        if (flightID == null || flightID.equals("FAIL") || flightID.equals("INVALID_INPUT")) {
            return "INVALID_INPUT";
        }
        
        // Set the generated flight ID
        flight.setFlightID(flightID);
        
        // Add flight to database
        String result = flightDAO.addFlight(flight);
        
        if (result.equals("SUCCESS")) {
            return "SUCCESS";
        } else {
            return "FAIL";
        }
    }
}

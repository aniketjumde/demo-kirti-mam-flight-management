package com.wipro.flight.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.wipro.flight.bean.Flight;
import com.wipro.flight.util.DBUtil;

public class FlightDAO {
    
    public String getComputedId(String name, String seqName) {
        // Check if arguments are null
        if (name == null || seqName == null) {
            return "FAIL";
        }
        
        // Check if name has less than 2 characters
        if (name.length() < 2) {
            return "INVALID_INPUT";
        }
        
        // Check if first 2 characters are alphabetic
        if (!Character.isLetter(name.charAt(0)) || !Character.isLetter(name.charAt(1))) {
            return "INVALID_INPUT";
        }
        
        // Check if sequence name is correct
        if (!seqName.equals("FlightId_Seq")) {
            return "INVALID_INPUT";
        }
        
        // Generate flight ID
        String flightID = null;
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            connection = DBUtil.getDBConnection();
            String sql = "SELECT " + seqName + ".NEXTVAL FROM DUAL";
            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();
            
            if (rs.next()) {
                int seqValue = rs.getInt(1);
                String prefix = name.substring(0, 2).toUpperCase();
                flightID = prefix + String.format("%05d", seqValue);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "FAIL";
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return flightID;
    }
    
    public String addFlight(Flight flight) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        
        try {
            connection = DBUtil.getDBConnection();
            String sql = "INSERT INTO Flight_Tbl (FlightId, FlightName, Source, Destination, " +
                         "EconomySeats, BusinessSeats, FirstClassSeats, FlightType) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, flight.getFlightID());
            pstmt.setString(2, flight.getFlightName());
            pstmt.setString(3, flight.getSource());
            pstmt.setString(4, flight.getDestination());
            pstmt.setInt(5, flight.getEconomySeats());
            pstmt.setInt(6, flight.getBusinessSeats());
            pstmt.setInt(7, flight.getFirstClassSeats());
            pstmt.setString(8, flight.getFlightType());
            
            int rowsInserted = pstmt.executeUpdate();
            
            if (rowsInserted > 0) {
                return "SUCCESS";
            } else {
                return "FAIL";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "FAIL";
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

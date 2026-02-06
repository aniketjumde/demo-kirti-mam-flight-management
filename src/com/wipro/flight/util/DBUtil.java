package com.wipro.flight.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    
    public static Connection getDBConnection() {
        Connection connection = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE", 
                "B3980612345", 
                "B3980612345"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}

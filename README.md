# Flight Management System

## Project Overview
This is a console-based Flight Management System application that allows administrators to add new flight details to the database.

## Project Structure
```
src/
├── com/
│   └── wipro/
│       └── flight/
│           ├── bean/
│           │   └── Flight.java          (Bean class with flight attributes)
│           ├── dao/
│           │   └── FlightDAO.java       (Data Access Object for database operations)
│           ├── service/
│           │   └── FlightService.java   (Service layer for business logic)
│           └── util/
│               └── DBUtil.java          (Database connection utility)
```

## Database Configuration

### User Credentials
- **Username:** B3980612345
- **Password:** B3980612345
- **Service Name:** XE
- **Port:** 1521

### Database Setup

1. **Run the SQL script** to set up the database:
   ```
   sqlplus / as sysdba @database_setup.sql
   ```

2. **Or manually execute** the following steps:

   **Step 1: Connect as SYSDBA**
   ```sql
   sqlplus / as sysdba
   ```

   **Step 2: Create User**
   ```sql
   CREATE USER B3980612345 IDENTIFIED BY B3980612345;
   GRANT connect, resource TO B3980612345;
   COMMIT;
   EXIT;
   ```

   **Step 3: Connect as New User**
   ```sql
   sqlplus B3980612345/B3980612345@XE
   ```

   **Step 4: Create Table**
   ```sql
   CREATE TABLE Flight_Tbl (
       FlightId VARCHAR2(10) PRIMARY KEY,
       FlightName VARCHAR2(20) NOT NULL,
       Source VARCHAR2(25) NOT NULL,
       Destination VARCHAR2(25) NOT NULL,
       EconomySeats NUMBER(2) NOT NULL,
       BusinessSeats NUMBER(2) NOT NULL,
       FirstClassSeats NUMBER(2) NOT NULL,
       FlightType VARCHAR2(20) NOT NULL
   );
   ```

   **Step 5: Create Sequence**
   ```sql
   CREATE SEQUENCE FlightId_Seq
   MINVALUE 10000
   MAXVALUE 99999
   INCREMENT BY 1
   START WITH 10000;
   COMMIT;
   EXIT;
   ```

## Database Schema

### Flight_Tbl Table
| Column Name     | Data Type      | Constraints  | Description                          |
|----------------|----------------|--------------|--------------------------------------|
| FlightId       | VARCHAR2(10)   | PRIMARY KEY  | Auto-generated flight ID             |
| FlightName     | VARCHAR2(20)   | NOT NULL     | Name of the flight                   |
| Source         | VARCHAR2(25)   | NOT NULL     | Starting city                        |
| Destination    | VARCHAR2(25)   | NOT NULL     | Destination city                     |
| EconomySeats   | NUMBER(2)      | NOT NULL     | Number of economy class seats        |
| BusinessSeats  | NUMBER(2)      | NOT NULL     | Number of business class seats       |
| FirstClassSeats| NUMBER(2)      | NOT NULL     | Number of first class seats          |
| FlightType     | VARCHAR2(20)   | NOT NULL     | International/Domestic               |

### FlightId_Seq Sequence
- **Start Value:** 10000
- **Increment:** 1
- **Range:** 10000-99999

## Class Details

### 1. Flight (Bean Class)
**Package:** `com.wipro.flight.bean`

**Attributes:**
- `String flightID` - Auto-generated ID (2 letters + 5 digits)
- `String flightName` - Name of the flight
- `String source` - Starting city
- `String destination` - Destination city
- `int economySeats` - Number of economy seats
- `int businessSeats` - Number of business seats
- `int firstClassSeats` - Number of first class seats
- `String flightType` - International/Domestic

### 2. DBUtil (Utility Class)
**Package:** `com.wipro.flight.util`

**Methods:**
- `public static Connection getDBConnection()` - Returns database connection

### 3. FlightDAO (Data Access Object)
**Package:** `com.wipro.flight.dao`

**Methods:**
- `public String getComputedId(String name, String seqName)`
  - Generates flight ID (2 letters from name + 5 digits from sequence)
  - Returns: "SUCCESS", "FAIL", or "INVALID_INPUT"
  
- `public String addFlight(Flight flight)`
  - Inserts flight record into database
  - Returns: "SUCCESS" or "FAIL"

### 4. FlightService (Service Layer)
**Package:** `com.wipro.flight.service`

**Methods:**
- `public String createFlight(Flight flight)`
  - Generates flight ID and adds flight to database
  - Returns: "SUCCESS", "FAIL", or "INVALID_INPUT"

## Flight ID Generation Logic

The flight ID is generated as follows:
- First 2 letters (uppercase) from the flight name
- Plus 5 digits from the sequence (FlightId_Seq)
- Example: For flight name "Indigo" → "IN10000"

## Requirements

- Java Development Kit (JDK) 8 or higher
- Oracle Database 11g or higher (XE Edition)
- Oracle JDBC Driver (ojdbc.jar)

## Setup Instructions

1. **Install Oracle Database XE** if not already installed
2. **Run the database setup script** (`database_setup.sql`)
3. **Add Oracle JDBC driver** to your project classpath
4. **Compile the Java files:**
   ```bash
   javac -d bin src/com/wipro/flight/*/*.java
   ```

## Testing

The assessment engine will test:
1. FlightId computation with valid/invalid inputs
2. addFlight method with valid/invalid values
3. createFlight method with various scenarios

## Important Notes

1. **Exact Naming:** All package names, class names, method names, and variable names must match exactly as specified
2. **No System.exit(0):** Do not use `System.exit(0)` in your code
3. **Zip Format:** When submitting, zip only the `src` folder structure
4. **File Naming:** Name your zip file as `<employee_number>.zip`

## Validation Checklist

- [ ] Database user created: B3980612345/B3980612345
- [ ] Flight_Tbl table created with all columns
- [ ] FlightId_Seq sequence created (starts at 10000)
- [ ] All packages match exactly: com.wipro.flight.{bean, dao, service, util}
- [ ] All class names match exactly
- [ ] All method signatures match exactly
- [ ] FlightID generation works correctly
- [ ] Database connection works
- [ ] Flight insertion works

## Support

For issues or questions, contact your assessment administrator.

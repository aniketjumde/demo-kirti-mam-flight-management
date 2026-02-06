-- Flight Management System Database Setup Script
-- Run this script as SYSDBA and then as the created user

-- ========================================
-- Step 1: Connect as SYSDBA and create user
-- ========================================
CONNECT / AS SYSDBA

-- Create user with username and password: B3980612345
CREATE USER B3980612345 IDENTIFIED BY B3980612345;

-- Grant necessary privileges
GRANT connect, resource TO B3980612345;

-- Commit the changes
COMMIT;

-- ========================================
-- Step 2: Connect as the new user
-- ========================================
CONNECT B3980612345/B3980612345@XE

-- ========================================
-- Step 3: Create Flight_Tbl table
-- ========================================
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

-- ========================================
-- Step 4: Create sequence for FlightId
-- ========================================
CREATE SEQUENCE FlightId_Seq
MINVALUE 10000
MAXVALUE 99999
INCREMENT BY 1
START WITH 10000;

-- Commit all changes
COMMIT;

-- Verify table and sequence creation
SELECT * FROM Flight_Tbl;
SELECT FlightId_Seq.NEXTVAL FROM DUAL;

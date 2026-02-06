# Database Setup Guide for Flight Management System

## Prerequisites
- Oracle Database XE installed and running
- Access to command prompt/terminal
- SYSDBA privileges

## Step-by-Step Database Setup

### Step 1: Open Command Prompt
Open your command prompt or terminal as administrator.

### Step 2: Connect to Oracle as SYSDBA
```bash
sqlplus / as sysdba
```

### Step 3: Create the User
Execute the following commands:

```sql
CREATE USER B3980612345 IDENTIFIED BY B3980612345;
GRANT connect, resource TO B3980612345;
COMMIT;
EXIT;
```

**Expected Output:**
- User created.
- Grant succeeded.
- Commit complete.

### Step 4: Connect as the New User
```bash
sqlplus B3980612345/B3980612345@XE
```

### Step 5: Create the Flight_Tbl Table
Copy and paste the following SQL command:

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

**Expected Output:**
- Table created.

### Step 6: Create the Sequence
Copy and paste the following SQL command:

```sql
CREATE SEQUENCE FlightId_Seq
MINVALUE 10000
MAXVALUE 99999
INCREMENT BY 1
START WITH 10000;
```

**Expected Output:**
- Sequence created.

### Step 7: Commit Changes
```sql
COMMIT;
```

**Expected Output:**
- Commit complete.

## Verification Steps

### Verify Table Structure
```sql
DESC Flight_Tbl;
```

**Expected Output:**
```
Name             Null?    Type
---------------- -------- -------------
FLIGHTID         NOT NULL VARCHAR2(10)
FLIGHTNAME       NOT NULL VARCHAR2(20)
SOURCE           NOT NULL VARCHAR2(25)
DESTINATION      NOT NULL VARCHAR2(25)
ECONOMYSEATS     NOT NULL NUMBER(2)
BUSINESSSEATS    NOT NULL NUMBER(2)
FIRSTCLASSSEATS  NOT NULL NUMBER(2)
FLIGHTTYPE       NOT NULL VARCHAR2(20)
```

### Test Sequence
```sql
SELECT FlightId_Seq.NEXTVAL FROM DUAL;
```

**Expected Output:**
```
NEXTVAL
--------
10000
```

### View All Tables
```sql
SELECT table_name FROM user_tables;
```

**Expected Output:**
```
TABLE_NAME
--------------
FLIGHT_TBL
```

### View All Sequences
```sql
SELECT sequence_name FROM user_sequences;
```

**Expected Output:**
```
SEQUENCE_NAME
--------------
FLIGHTID_SEQ
```

## Test Database Connection from Java

After setting up the database, you can test the connection by running:

```bash
cd /workspaces/demo-kirti-mam-flight-management
javac -d bin src/com/wipro/flight/util/DBUtil.java
java -cp bin:path/to/ojdbc.jar com.wipro.flight.util.DBUtil
```

## Troubleshooting

### Issue 1: User Already Exists
If you get an error "user name already exists", drop the existing user first:
```sql
DROP USER B3980612345 CASCADE;
```
Then recreate the user.

### Issue 2: Cannot Connect to Database
- Verify Oracle XE service is running
- Check if port 1521 is not blocked by firewall
- Verify service name is "XE"

### Issue 3: TNS Listener Error
Start the Oracle TNS Listener:
```bash
lsnrctl start
```

### Issue 4: Permission Denied
Make sure you're running the command prompt as administrator when connecting as SYSDBA.

## Alternative: Using SQL Script

You can also run the provided `database_setup.sql` script:

```bash
sqlplus / as sysdba @database_setup.sql
```

This will execute all commands automatically.

## Database Cleanup (If Needed)

To remove all objects and start fresh:

```sql
-- Connect as SYSDBA
sqlplus / as sysdba

-- Drop user and all objects
DROP USER B3980612345 CASCADE;
COMMIT;
EXIT;
```

Then start from Step 1 again.

## Important Notes

1. **Username and Password:** Both are `B3980612345`
2. **Service Name:** Use `XE` (not `ORCL` or other names)
3. **Port:** Default Oracle port is `1521`
4. **Case Sensitivity:** Oracle converts object names to uppercase by default
5. **Sequence Start:** FlightId_Seq starts at 10000

## Connection String Format

For JDBC connection:
```
jdbc:oracle:thin:@localhost:1521:XE
Username: B3980612345
Password: B3980612345
```

## Next Steps

After successful database setup:
1. Add Oracle JDBC driver (ojdbc.jar) to your project classpath
2. Compile all Java files
3. Run TestFlightManagement.java to test the application
4. Verify data insertion by querying the Flight_Tbl table

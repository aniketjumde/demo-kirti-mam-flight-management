# Flight Management System - Complete Walkthrough

## 📋 Table of Contents
1. [Prerequisites](#prerequisites)
2. [Database Setup](#database-setup)
3. [Project Verification](#project-verification)
4. [Testing Locally](#testing-locally)
5. [Creating Submission Zip](#creating-submission-zip)
6. [Submission Process](#submission-process)
7. [Troubleshooting](#troubleshooting)

---

## 1. Prerequisites

### Required Software
- [ ] Java Development Kit (JDK) 8 or higher installed
- [ ] Oracle Database XE installed and running
- [ ] Oracle JDBC Driver (ojdbc.jar) downloaded
- [ ] Eclipse IDE or any Java IDE (optional but recommended)

### Verify Java Installation
```bash
java -version
javac -version
```

Expected output: Java version 8 or higher

### Verify Oracle Installation
```bash
sqlplus / as sysdba
```

Expected: SQL*Plus should open successfully

---

## 2. Database Setup

### Step 2.1: Create Oracle User

Open **Command Prompt as Administrator** and execute:

```bash
sqlplus / as sysdba
```

You should see:
```
SQL*Plus: Release ...
Connected to:
Oracle Database ...

SQL>
```

### Step 2.2: Execute User Creation Commands

Copy and paste these commands one by one:

```sql
CREATE USER B3980612345 IDENTIFIED BY B3980612345;
```
✓ Expected: `User created.`

```sql
GRANT connect, resource TO B3980612345;
```
✓ Expected: `Grant succeeded.`

```sql
COMMIT;
```
✓ Expected: `Commit complete.`

```sql
EXIT;
```

### Step 2.3: Connect as New User

```bash
sqlplus B3980612345/B3980612345@XE
```

✓ Expected: `Connected to: Oracle Database ...`

### Step 2.4: Create Table

Copy and paste the following:

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

✓ Expected: `Table created.`

### Step 2.5: Verify Table Creation

```sql
DESC Flight_Tbl;
```

✓ Expected: Shows table structure with all 8 columns

### Step 2.6: Create Sequence

```sql
CREATE SEQUENCE FlightId_Seq
MINVALUE 10000
MAXVALUE 99999
INCREMENT BY 1
START WITH 10000;
```

✓ Expected: `Sequence created.`

### Step 2.7: Test Sequence

```sql
SELECT FlightId_Seq.NEXTVAL FROM DUAL;
```

✓ Expected: Returns `10000`

```sql
COMMIT;
EXIT;
```

### ✅ Database Setup Complete!

---

## 3. Project Verification

### Step 3.1: Verify Project Structure

Your project should have this structure:

```
demo-kirti-mam-flight-management/
├── src/
│   └── com/
│       └── wipro/
│           └── flight/
│               ├── bean/
│               │   └── Flight.java
│               ├── dao/
│               │   └── FlightDAO.java
│               ├── service/
│               │   └── FlightService.java
│               └── util/
│                   └── DBUtil.java
├── database_setup.sql
└── README.md
```

### Step 3.2: Verify Package Names

Open each Java file and verify the package declaration:

**Flight.java:**
```java
package com.wipro.flight.bean;
```

**FlightDAO.java:**
```java
package com.wipro.flight.dao;
```

**FlightService.java:**
```java
package com.wipro.flight.service;
```

**DBUtil.java:**
```java
package com.wipro.flight.util;
```

### Step 3.3: Verify Database Credentials

Open `DBUtil.java` and verify:

```java
connection = DriverManager.getConnection(
    "jdbc:oracle:thin:@localhost:1521:XE", 
    "B3980612345", 
    "B3980612345"
);
```

---

## 4. Testing Locally

### Step 4.1: Add JDBC Driver to Project

1. Download Oracle JDBC driver (ojdbc.jar)
2. Create a `lib` folder in your project
3. Copy `ojdbc.jar` to the `lib` folder

### Step 4.2: Configure Eclipse (If Using)

1. Right-click on project → Properties
2. Java Build Path → Libraries
3. Add External JARs → Select ojdbc.jar
4. Apply and Close

### Step 4.3: Compile the Project

**Using Eclipse:**
- Project → Clean → Select your project → Clean

**Using Command Line:**
```bash
cd /path/to/demo-kirti-mam-flight-management
javac -d bin -cp lib/ojdbc.jar src/com/wipro/flight/*/*.java
```

✓ Expected: No compilation errors

### Step 4.4: Run Test Program

**Using Eclipse:**
- Right-click on `TestFlightManagement.java`
- Run As → Java Application

**Using Command Line:**
```bash
java -cp bin:lib/ojdbc.jar com.wipro.flight.main.TestFlightManagement
```

✓ Expected Output:
```
=== Test Case 1: Create Valid Flight ===
Result: SUCCESS
Generated Flight ID: IN10000

=== Test Case 2: Create Another Valid Flight ===
Result: SUCCESS
Generated Flight ID: SP10001

...
```

### Step 4.5: Verify Database Records

```bash
sqlplus B3980612345/B3980612345@XE
```

```sql
SELECT * FROM Flight_Tbl;
```

✓ Expected: Shows the inserted flight records

```sql
EXIT;
```

---

## 5. Creating Submission Zip

### ⚠️ IMPORTANT: Only Submit the `src` Folder

### Method 1: Using Provided Script (Linux/Mac)

```bash
cd /workspaces/demo-kirti-mam-flight-management
./create_submission_zip.sh 12345
```

Replace `12345` with your actual employee number.

### Method 2: Manual Creation (Windows)

1. Navigate to your project folder
2. **Right-click on the `src` folder** (NOT the entire project)
3. Select **"Send to" → "Compressed (zipped) folder"**
4. Rename the zip file to `<employee_number>.zip`

Example: If employee number is 12345, name it `12345.zip`

### Method 3: Command Line (Windows)

```bash
cd C:\path\to\demo-kirti-mam-flight-management
tar -a -c -f 12345.zip src
```

### Method 4: Command Line (Linux/Mac)

```bash
cd /path/to/demo-kirti-mam-flight-management
zip -r 12345.zip src
```

### Step 5.1: Verify Zip Contents

**Windows:**
```bash
tar -tf 12345.zip
```

**Linux/Mac:**
```bash
unzip -l 12345.zip
```

✓ Expected: Shows `src/` at the top level, followed by the package structure

### Step 5.2: Test Extraction

1. Create a test folder
2. Extract your zip file there
3. Verify the structure is:
   ```
   test_folder/
   └── src/
       └── com/
           └── wipro/
               └── flight/
   ```

---

## 6. Submission Process

### Step 6.1: Access PBLApp

1. Open browser and go to: https://talentnext.wipro.com/PBLApp
2. Login with:
   - **Email:** ksdhande_it@jspmrscoe.edu.in
   - **PBLApp ID:** 2520062
   - **Password:** TalentNext##123

### Step 6.2: Navigate to Assessment

1. Find "Flight Management System" assessment
2. Click on it to open

### Step 6.3: Upload Zip File

1. Click **"Upload Zip File"** button
2. Select your `<employee_number>.zip` file
3. Wait for upload to complete

### Step 6.4: Compile and Test

1. Click **"Compile & Test"** button
2. Wait for the assessment engine to:
   - Compile your code
   - Run test cases
   - Generate results

### Step 6.5: Review Results

The results will show:
- ✓ **PASS** - Test case passed
- ✗ **FAIL** - Test case failed (logic error)
- ⚠ **ERROR** - Compilation or structural error

### Step 6.6: Fix Issues (If Any)

If some tests fail:
1. Note which test cases failed
2. Fix the issues in your local code
3. Test locally again
4. Create a new zip file
5. Upload and test again
6. Repeat until all tests pass

### Step 6.7: Final Submission

Once all tests pass:
1. Click **"Final Submission"** button
2. Confirm the submission
3. View your final score

---

## 7. Troubleshooting

### Issue 1: Compilation Error - Package Not Found

**Problem:** `package com.wipro.flight.xxx does not exist`

**Solution:**
- Verify package names match exactly
- Check for typos in package declarations
- Ensure all files are in correct folders

### Issue 2: Compilation Error - Cannot Find Symbol

**Problem:** `cannot find symbol: class Flight`

**Solution:**
- Verify import statements are correct
- Check class names match exactly (case-sensitive)
- Ensure all required classes exist

### Issue 3: Test Failure - getComputedId Returns Wrong Value

**Problem:** FlightId computation tests fail

**Solution:**
- Verify sequence name is **exactly** `FlightId_Seq`
- Check if first 2 characters are converted to uppercase
- Ensure 5-digit padding with leading zeros
- Verify all validation checks return correct values

### Issue 4: Test Failure - Cannot Connect to Database

**Problem:** Database connection errors

**Solution:**
- Verify Oracle service is running
- Check username/password: `B3980612345/B3980612345`
- Verify service name is `XE`
- Check port is `1521`
- Test connection using SQL*Plus first

### Issue 5: Test Failure - addFlight Returns FAIL

**Problem:** Flight insertion fails

**Solution:**
- Verify table name is `Flight_Tbl` (capital F, T, and b)
- Check all column names match exactly
- Ensure flight object has all required values
- Verify database connection works
- Check for SQLException and handle properly

### Issue 6: Upload Error - Invalid Zip Format

**Problem:** "Invalid zip file" error on upload

**Solution:**
- Ensure extension is `.zip` (not .7z, .rar, etc.)
- Recreate zip using standard zip format
- Use built-in Windows/Mac compression tools

### Issue 7: Upload Error - Structure Mismatch

**Problem:** "Cannot find required files" error

**Solution:**
- Verify zip contains `src` folder at root level
- Do NOT zip the entire project folder
- Extract and verify structure before uploading
- Ensure no extra folders (bin, lib, etc.)

### Issue 8: Local Test Works But Assessment Fails

**Problem:** Code works locally but fails on assessment

**Solution:**
- Check for hardcoded values (use parameters instead)
- Verify method return values match exactly
- Ensure no `System.exit(0)` in code
- Check for case-sensitive naming issues
- Verify all validation rules are implemented correctly

---

## ✅ Final Checklist

Before final submission, verify:

- [ ] Database user created: B3980612345/B3980612345
- [ ] Flight_Tbl table exists with all columns
- [ ] FlightId_Seq sequence exists (starts at 10000)
- [ ] All Java files compile without errors
- [ ] Local tests run successfully
- [ ] Data inserted into database correctly
- [ ] Package names match exactly
- [ ] Class names match exactly
- [ ] Method names match exactly
- [ ] Variable names match exactly (case-sensitive)
- [ ] No System.exit(0) in code
- [ ] Zip file contains only src folder
- [ ] Zip file name is <employee_number>.zip
- [ ] Zip file extension is .zip
- [ ] All test cases pass on assessment engine

---

## 📞 Support

If you encounter issues not covered here:
1. Review the error messages carefully
2. Check the DATABASE_SETUP_GUIDE.md
3. Read the PROJECT_SUMMARY.txt
4. Contact your assessment administrator

---

## 🎯 Good Luck!

Follow this guide step by step, and you should have a successful submission!

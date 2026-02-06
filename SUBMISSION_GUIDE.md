# Project Submission Guide

## Overview
This guide explains how to properly package and submit your Flight Management System project.

## What to Submit
You need to submit **ONLY the `src` folder** in a .zip format.

## Important Requirements

### 1. Zip File Format
- **Extension:** Must be `.zip` (NOT .7z, .rar, or any other format)
- **Content:** ONLY the src folder structure
- **Name:** `<your_employee_number>.zip`
  - Example: If your employee number is 12345, name it `12345.zip`

### 2. Folder Structure
The zip file should contain:
```
src/
├── com/
│   └── wipro/
│       └── flight/
│           ├── bean/
│           │   └── Flight.java
│           ├── dao/
│           │   └── FlightDAO.java
│           ├── service/
│           │   └── FlightService.java
│           └── util/
│               └── DBUtil.java
```

**DO NOT include:**
- bin folder
- .class files
- .project or .classpath files
- .settings folder
- lib folder
- database_setup.sql
- README.md
- Any test files (unless specifically requested)

## Creating the Zip File

### Method 1: Using File Explorer (Windows)

1. Navigate to your project folder
2. Open the project directory
3. Right-click on the `src` folder ONLY
4. Select "Send to" → "Compressed (zipped) folder"
5. Rename the created zip file to `<employee_number>.zip`

### Method 2: Using Terminal/Command Prompt

#### Windows (Command Prompt)
```bash
cd /path/to/your/project
tar -a -c -f 12345.zip src
```

#### Linux/Mac (Terminal)
```bash
cd /path/to/your/project
zip -r 12345.zip src
```

Replace `12345` with your actual employee number.

### Method 3: Using 7-Zip or WinRAR (Convert to .zip)

1. Right-click on `src` folder
2. Select 7-Zip → "Add to archive..."
3. In "Archive format", select "zip"
4. Name it `<employee_number>.zip`
5. Click OK

## Verification Checklist

Before submitting, verify:

- [ ] Zip file extension is `.zip` (not .7z or .rar)
- [ ] Zip file name is `<employee_number>.zip`
- [ ] Zip contains ONLY the `src` folder
- [ ] When you extract the zip, you see `src` folder immediately
- [ ] All package names are exactly: `com.wipro.flight.bean`, `com.wipro.flight.dao`, `com.wipro.flight.service`, `com.wipro.flight.util`
- [ ] All class names match exactly as specified
- [ ] All method names and signatures match exactly
- [ ] No `System.exit(0)` in your code
- [ ] Database connection uses correct credentials

## How to Verify Your Zip File

1. Extract your zip file to a temporary location
2. Check if the structure is:
   ```
   temp_folder/
   └── src/
       └── com/
           └── wipro/
               └── flight/
                   ├── bean/
                   ├── dao/
                   ├── service/
                   └── util/
   ```
3. If you see the `src` folder immediately after extraction, you're good!
4. If you see project name or other folders first, recreate the zip correctly

## Submission Process

1. Log in to PBLApp: https://talentnext.wipro.com/PBLApp
   - Email: ksdhande_it@jspmrscoe.edu.in
   - PBLApp ID: 2520062
   - Password: TalentNext##123

2. Navigate to the Flight Management System assessment

3. Click "Upload Zip File" button

4. Select your `<employee_number>.zip` file

5. Click "Compile & Test"

6. Review the test results

7. If there are failures:
   - Fix the issues in your local code
   - Create a new zip file
   - Upload and test again

8. Once all tests pass, click "Final Submission"

## Common Submission Errors

### Error 1: Wrong Zip Structure
**Problem:** Zip contains project folder instead of src folder
**Solution:** Make sure to zip ONLY the src folder

### Error 2: Wrong Extension
**Problem:** File is .7z or .rar instead of .zip
**Solution:** Use proper zip compression or convert to .zip format

### Error 3: Wrong Naming
**Problem:** File named incorrectly
**Solution:** Rename to `<employee_number>.zip` (numbers only)

### Error 4: Extra Files
**Problem:** Zip contains bin, lib, or other folders
**Solution:** Delete the zip and create a new one with ONLY src folder

### Error 5: Package Mismatch
**Problem:** Package names don't match exactly
**Solution:** Verify all package declarations match: `com.wipro.flight.xxx`

## Testing Before Submission

### Step 1: Local Compilation Test
```bash
javac -d bin src/com/wipro/flight/*/*.java
```
This should compile without errors.

### Step 2: Run Local Tests
```bash
java -cp bin:path/to/ojdbc.jar com.wipro.flight.main.TestFlightManagement
```
This should execute successfully and show results.

### Step 3: Check Database
```sql
SELECT * FROM Flight_Tbl;
```
This should show the inserted flight records.

## Final Checklist Before Submission

- [ ] All Java files compile successfully
- [ ] Database is set up correctly
- [ ] Test cases run successfully locally
- [ ] Zip file structure is correct
- [ ] Zip file name is correct
- [ ] Zip file extension is .zip
- [ ] No compilation errors
- [ ] No System.exit(0) in code
- [ ] All package/class/method names match exactly

## Assessment Scoring

The assessment engine will evaluate:
1. **Compilation:** Do all files compile correctly?
2. **Naming:** Do packages, classes, and methods match exactly?
3. **Functionality:** Do methods perform as expected?
4. **Test Cases:** Do all test cases pass?

## Support

If you encounter issues during submission:
1. Verify your zip file structure
2. Check the DATABASE_SETUP_GUIDE.md for database issues
3. Review README.md for project requirements
4. Contact your assessment administrator if problems persist

## Example Verification

After creating your zip file, run this command to verify contents:

### Windows
```bash
tar -tf 12345.zip
```

### Linux/Mac
```bash
unzip -l 12345.zip
```

Expected output should show:
```
src/
src/com/
src/com/wipro/
src/com/wipro/flight/
src/com/wipro/flight/bean/
src/com/wipro/flight/bean/Flight.java
src/com/wipro/flight/dao/
src/com/wipro/flight/dao/FlightDAO.java
... (and so on)
```

Good luck with your submission!

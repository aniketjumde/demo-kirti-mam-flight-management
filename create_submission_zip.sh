#!/bin/bash
#
# Script to create submission-ready zip file for Flight Management System
# Usage: ./create_submission_zip.sh <employee_number>
#

# Check if employee number is provided
if [ -z "$1" ]; then
    echo "Error: Employee number is required!"
    echo "Usage: ./create_submission_zip.sh <employee_number>"
    echo "Example: ./create_submission_zip.sh 12345"
    exit 1
fi

EMPLOYEE_NUMBER=$1
ZIP_FILE="${EMPLOYEE_NUMBER}.zip"
PROJECT_DIR="/workspaces/demo-kirti-mam-flight-management"

echo "======================================"
echo "Creating Submission Zip File"
echo "======================================"
echo ""
echo "Employee Number: $EMPLOYEE_NUMBER"
echo "Zip File Name: $ZIP_FILE"
echo ""

# Navigate to project directory
cd "$PROJECT_DIR" || exit 1

# Remove old zip file if exists
if [ -f "$ZIP_FILE" ]; then
    echo "Removing existing zip file..."
    rm "$ZIP_FILE"
fi

# Create zip file with only src folder
echo "Creating zip file..."
zip -r "$ZIP_FILE" src/

# Check if zip was created successfully
if [ -f "$ZIP_FILE" ]; then
    echo ""
    echo "✓ Zip file created successfully!"
    echo ""
    echo "File: $PROJECT_DIR/$ZIP_FILE"
    echo "Size: $(du -h $ZIP_FILE | cut -f1)"
    echo ""
    echo "Contents:"
    echo "----------"
    unzip -l "$ZIP_FILE" | head -20
    echo ""
    echo "======================================"
    echo "Next Steps:"
    echo "======================================"
    echo "1. Download the zip file: $ZIP_FILE"
    echo "2. Verify the contents"
    echo "3. Upload to PBLApp"
    echo "4. Click 'Compile & Test'"
    echo ""
else
    echo "✗ Error: Failed to create zip file!"
    exit 1
fi

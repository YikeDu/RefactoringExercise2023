public class NextRecord extends Record {
    public NextRecord(EmployeeDetails employeeDetails) {
        super(employeeDetails);
    }

    @Override
    protected void doRetrieveRecord() {
        // get byte start in file for next record
        currentByteStart = application.getNext(currentByteStart);
        // assign current Employee to record in file
        currentEmployee = application.readRecords(currentByteStart);
        // loop to previous next until Employee is active - ID is not 0
        while (currentEmployee.getEmployeeId() == 0) {
            // get byte start in file for next record
            currentByteStart = application.getNext(currentByteStart);
            // assign current Employee to next record in file
            currentEmployee = application.readRecords(currentByteStart);
        } // end while
        application.closeReadFile();// close file for reading
    }
}

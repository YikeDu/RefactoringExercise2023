public class PreviousRecord extends Record {
    public PreviousRecord(EmployeeDetails employeeDetails) {
        super(employeeDetails);
    }

    @Override
    protected void doRetrieveRecord() {
        // get byte start in file for previous record
        currentByteStart = application.getPrevious(currentByteStart);
        // assign current Employee to previous record in file
        currentEmployee = application.readRecords(currentByteStart);
        // loop to previous record until Employee is active - ID is not 0
        while (currentEmployee.getEmployeeId() == 0) {
            // get byte start in file for previous record
            currentByteStart = application.getPrevious(currentByteStart);
            // assign current Employee to previous record in file
            currentEmployee = application.readRecords(currentByteStart);
        } // end while
        application.closeReadFile();// close file for reading
    }
}

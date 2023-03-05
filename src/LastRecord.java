public class LastRecord extends Record {
    public LastRecord(EmployeeDetails employeeDetails) {
        super(employeeDetails);
    }

    @Override
    protected void doRetrieveRecord() {
        // get byte start in file for last record
        currentByteStart = application.getLast();
        // assign current Employee to first record in file
        currentEmployee = application.readRecords(currentByteStart);
        application.closeReadFile();// close file for reading
    }
}

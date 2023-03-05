public class FirstRecord extends Record {

    public FirstRecord(EmployeeDetails employeeDetails) {
        super(employeeDetails);
    }

    @Override
    protected void doRetrieveRecord() {
        // get byte start in file for first record
        currentByteStart = application.getFirst();
        // assign current Employee to first record in file
        currentEmployee = application.readRecords(currentByteStart);
        application.closeReadFile();// close file for reading
    }
}

public abstract class Record {
    protected EmployeeDetails employeeDetails;
    protected RandomFile application;
    protected long currentByteStart;
    protected Employee currentEmployee;

    public Record(EmployeeDetails employeeDetails) {
        this.employeeDetails = employeeDetails;
        this.application = employeeDetails.getApplication();
        this.currentByteStart = employeeDetails.getCurrentByteStart();
        this.currentEmployee = employeeDetails.currentEmployee;
    }

    protected abstract void doRetrieveRecord();

    public void retrieveRecord() {
        if (EmployeeUtils.isSomeoneToDisplay(employeeDetails)) {
            // open file for reading
            employeeDetails.getApplication().openReadFile(employeeDetails.getFile().getAbsolutePath());

            doRetrieveRecord();

            postProcessCurrentState();
        }
    }

    private void postProcessCurrentState() {
        employeeDetails.currentEmployee = currentEmployee;
        employeeDetails.setCurrentByteStart(currentByteStart);
    }
}

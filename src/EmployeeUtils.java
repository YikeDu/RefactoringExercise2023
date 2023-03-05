import javax.swing.*;
import java.io.File;

public class EmployeeUtils {
    // check if any of records in file is active - ID is not 0
    public static boolean isSomeoneToDisplay(EmployeeDetails employeeDetails) {
        boolean someoneToDisplay = false;
        RandomFile application = employeeDetails.getApplication();
        File file = employeeDetails.getFile();
        // open file for reading
        application.openReadFile(file.getAbsolutePath());
        // check if any of records in file is active - ID is not 0
        someoneToDisplay = application.isSomeoneToDisplay();
        application.closeReadFile();// close file for reading
        // if no records found clear all text fields and display message
        if (!someoneToDisplay) {
            employeeDetails.currentEmployee = null;
            employeeDetails.getIdField().setText("");
            employeeDetails.getPpsField().setText("");
            employeeDetails.getSurnameField().setText("");
            employeeDetails.getFirstNameField().setText("");
            employeeDetails.getSalaryField().setText("");
            employeeDetails.getGenderCombo().setSelectedIndex(0);
            employeeDetails.getDepartmentCombo().setSelectedIndex(0);
            employeeDetails.getFullTimeCombo().setSelectedIndex(0);
            JOptionPane.showMessageDialog(null, "No Employees registered!");
        }
        return someoneToDisplay;
    }// end isSomeoneToDisplay
}

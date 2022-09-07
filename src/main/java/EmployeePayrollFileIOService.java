import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollFileIOService {
    public static String PAYROLL_FILE = "Employee_Payroll.txt";
    public void writeData(List<EmployeePayrollData>employeePayrollDataList) {
        StringBuffer stringBuffer = new StringBuffer();
        employeePayrollDataList.forEach(employeePayrollData -> {
            String employeeDataString = employeePayrollData.toString().concat("\n");
            stringBuffer.append(employeeDataString);
        });
        try {
            Files.write(Paths.get(PAYROLL_FILE),stringBuffer.toString().getBytes());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    public void printData() {
        try {
            Files.lines(new File(PAYROLL_FILE).toPath()).forEach(System.out::println);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public long countEntries() {
        long entries = 0;
        try {
            entries = Files.lines(new File(PAYROLL_FILE).toPath()).count();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return entries;
    }
    public List<EmployeePayrollData> readData() {
        List<EmployeePayrollData> employeePayrollDataList = new ArrayList<>();
        try {
            Files.lines(new File(PAYROLL_FILE).toPath()).map(String::trim).forEach(System.out::println);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return employeePayrollDataList;
    }
}
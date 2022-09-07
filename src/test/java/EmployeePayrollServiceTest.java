import org.junit.Test;

import java.util.Arrays;

public class EmployeePayrollServiceTest {

    @Test
    public void givenEmployeesPayrollWhenWrittenToFileShouldMatchEmployeeEntries() {
        EmployeePayrollData[] payrollData = {
                new EmployeePayrollData(1, "Aman Kumar", 400000),
                new EmployeePayrollData(2, "Bhuwan Singh", 600000),
                new EmployeePayrollData(3, "Chaitanya Sahu", 500000),
                new EmployeePayrollData(4, "Deepesh Pradhan", 800000),
        };
        EmployeePayrollService employeePayrollService;
        employeePayrollService = new EmployeePayrollService(Arrays.asList(payrollData));
        employeePayrollService.writeEmployeePayrollData(EmployeePayrollService.IOService.FILE_IO);
    }
}

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EmployeeServiceTest {

    private EmployeeService service = new EmployeeService();

    @Test
    void testHighSalaryEmployeesFiltered() {

        List<Employee> employees = Arrays.asList(
                new Employee("Monesh", 60000),
                new Employee("Arun", 40000),
                new Employee("Suresh", 70000)
        );

        List<String> result = service.getHighSalaryEmployeeNames(employees);

        assertEquals(2, result.size());
        assertTrue(result.contains("Monesh"));
        assertTrue(result.contains("Suresh"));
    }

    @Test
    void testLowSalaryEmployeesExcluded() {

        List<Employee> employees = Arrays.asList(
                new Employee("Arun", 40000),
                new Employee("Karthik", 50000)
        );

        List<String> result = service.getHighSalaryEmployeeNames(employees);

        assertTrue(result.isEmpty());
    }

    @Test
    void testReturnedListContainsOnlyNames() {

        List<Employee> employees = Arrays.asList(
                new Employee("Monesh", 60000)
        );

        List<String> result = service.getHighSalaryEmployeeNames(employees);

        assertTrue(result.get(0) instanceof String);
    }

    @Test
    void testEmptyEmployeeList() {

        List<Employee> employees = Collections.emptyList();

        List<String> result = service.getHighSalaryEmployeeNames(employees);

        assertTrue(result.isEmpty());
    }

    @Test
    void testAllEmployeesMeetCondition() {

        List<Employee> employees = Arrays.asList(
                new Employee("Monesh", 80000),
                new Employee("Suresh", 90000)
        );

        List<String> result = service.getHighSalaryEmployeeNames(employees);

        assertEquals(2, result.size());
    }
}

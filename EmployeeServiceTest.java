import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EmployeeServiceTest {

    private EmployeeService service = new EmployeeService();

    // 1️⃣ Verify employees with salary > 50,000 are correctly filtered
    @Test
    void testHighSalaryEmployeesFiltered() {

        List<Employee> employees = Arrays.asList(
                new Employee("Gaurav", 60000),
                new Employee("Ravi", 40000),
                new Employee("Amit", 70000)
        );

        List<String> result = service.getHighSalaryEmployeeNames(employees);

        assertEquals(2, result.size());
        assertTrue(result.contains("Gaurav"));
        assertTrue(result.contains("Amit"));
    }

    // 2️⃣ Ensure employees with salary ≤ 50,000 are excluded
    @Test
    void testLowSalaryEmployeesExcluded() {

        List<Employee> employees = Arrays.asList(
                new Employee("Ravi", 40000),
                new Employee("Karan", 50000)
        );

        List<String> result = service.getHighSalaryEmployeeNames(employees);

        assertTrue(result.isEmpty());
    }

    // 3️⃣ Check returned list contains only names
    @Test
    void testReturnedListContainsOnlyNames() {

        List<Employee> employees = Arrays.asList(
                new Employee("Gaurav", 60000)
        );

        List<String> result = service.getHighSalaryEmployeeNames(employees);

        assertTrue(result.get(0) instanceof String);
    }

    // 4️⃣ Verify behavior when employee list is empty
    @Test
    void testEmptyEmployeeList() {

        List<Employee> employees = Collections.emptyList();

        List<String> result = service.getHighSalaryEmployeeNames(employees);

        assertTrue(result.isEmpty());
    }

    // 5️⃣ Verify when all employees meet salary condition
    @Test
    void testAllEmployeesMeetCondition() {

        List<Employee> employees = Arrays.asList(
                new Employee("Gaurav", 80000),
                new Employee("Amit", 90000)
        );

        List<String> result = service.getHighSalaryEmployeeNames(employees);

        assertEquals(2, result.size());
    }
}
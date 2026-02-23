import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class StudentGradeCalculatorTest {

    // 1️⃣ Valid positive marks should not throw exception
    @ParameterizedTest
    @ValueSource(ints = {10, 50, 75, 100})
    void testValidMarks(int marks) {

        StudentGradeCalculator calculator = new StudentGradeCalculator();

        assertDoesNotThrow(() -> calculator.addMarks(marks));
    }

    // 2️⃣ Test multiple sets of marks and expected averages
    @ParameterizedTest
    @CsvSource({
            "40, 60, 50.0",
            "80, 90, 85.0",
            "30, 70, 50.0"
    })
    void testAverageCalculation(int mark1, int mark2, double expectedAverage) {

        StudentGradeCalculator calculator = new StudentGradeCalculator();

        calculator.addMarks(mark1);
        calculator.addMarks(mark2);

        assertEquals(expectedAverage, calculator.calculateAverage());
    }

    // 3️⃣ Test PASS / FAIL results
    @ParameterizedTest
    @CsvSource({
            "30, 35, FAIL",
            "40, 50, PASS",
            "80, 90, PASS"
    })
    void testResult(int mark1, int mark2, String expectedResult) {

        StudentGradeCalculator calculator = new StudentGradeCalculator();

        calculator.addMarks(mark1);
        calculator.addMarks(mark2);

        assertEquals(expectedResult, calculator.getResult());
    }

    // 4️⃣ Negative marks should throw exception
    @ParameterizedTest
    @ValueSource(ints = {-10, -1, -50})
    void testNegativeMarks(int marks) {

        StudentGradeCalculator calculator = new StudentGradeCalculator();

        assertThrows(IllegalArgumentException.class,
                () -> calculator.addMarks(marks));
    }

    // 5️⃣ Complex test data using MethodSource
    static Stream<Object[]> provideMarks() {
        return Stream.of(
                new Object[]{new int[]{40, 60, 80}, 60.0},
                new Object[]{new int[]{50, 50, 50}, 50.0},
                new Object[]{new int[]{90, 80, 70}, 80.0}
        );
    }

    @ParameterizedTest
    @MethodSource("provideMarks")
    void testMultipleMarks(int[] marks, double expectedAverage) {

        StudentGradeCalculator calculator = new StudentGradeCalculator();

        for (int mark : marks) {
            calculator.addMarks(mark);
        }

        assertEquals(expectedAverage, calculator.calculateAverage());
    }
}
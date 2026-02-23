import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class StudentGradeCalculatorTest {

    @ParameterizedTest
    @ValueSource(ints = {15, 45, 70, 95})
    void validateMarks(int value) {
        StudentGradeCalculator calc = new StudentGradeCalculator();
        assertDoesNotThrow(() -> calc.addMarks(value));
    }

    @ParameterizedTest
    @CsvSource({
            "35, 65, 50.0",
            "70, 90, 80.0",
            "25, 75, 50.0"
    })
    void verifyAverage(int m1, int m2, double expected) {
        StudentGradeCalculator calc = new StudentGradeCalculator();

        calc.addMarks(m1);
        calc.addMarks(m2);

        assertEquals(expected, calc.calculateAverage());
    }

    @ParameterizedTest
    @CsvSource({
            "20, 30, FAIL",
            "45, 60, PASS",
            "85, 95, PASS"
    })
    void verifyResult(int m1, int m2, String result) {
        StudentGradeCalculator calc = new StudentGradeCalculator();

        calc.addMarks(m1);
        calc.addMarks(m2);

        assertEquals(result, calc.getResult());
    }

    @ParameterizedTest
    @ValueSource(ints = {-5, -15, -25})
    void validateNegativeMarks(int value) {
        StudentGradeCalculator calc = new StudentGradeCalculator();

        assertThrows(IllegalArgumentException.class,
                () -> calc.addMarks(value));
    }

    static Stream<Object[]> markProvider() {
        return Stream.of(
                new Object[]{new int[]{45, 55, 65}, 55.0},
                new Object[]{new int[]{60, 60, 60}, 60.0},
                new Object[]{new int[]{85, 75, 65}, 75.0}
        );
    }

    @ParameterizedTest
    @MethodSource("markProvider")
    void verifyMultipleMarks(int[] values, double expected) {
        StudentGradeCalculator calc = new StudentGradeCalculator();

        for (int v : values) {
            calc.addMarks(v);
        }

        assertEquals(expected, calc.calculateAverage());
    }
}

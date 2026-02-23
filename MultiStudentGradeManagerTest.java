import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MultiStudentGradeManagerTest {

    private MultiStudentGradeManager manager;

    @BeforeEach
    void setup() {
        manager = new MultiStudentGradeManager();
    }

    @Test
    void testMultipleStudentsIndependently() {
        manager.registerStudent("Monesh");
        manager.registerStudent("Karthik");

        manager.addStudentMarks("Monesh", 50);
        manager.addStudentMarks("Karthik", 80);

        assertEquals(50.0, manager.getStudentAverage("Monesh"));
        assertEquals(80.0, manager.getStudentAverage("Karthik"));
    }

    @Test
    void testAveragePerStudent() {
        manager.registerStudent("Monesh");
        manager.addStudentMarks("Monesh", 40);
        manager.addStudentMarks("Monesh", 60);

        assertEquals(50.0, manager.getStudentAverage("Monesh"));
    }

    @Test
    void testGetResult() {
        manager.registerStudent("Monesh");
        manager.addStudentMarks("Monesh", 30);
        manager.addStudentMarks("Monesh", 35);

        assertEquals("FAIL", manager.getStudentResult("Monesh"));

        manager.registerStudent("Karthik");
        manager.addStudentMarks("Karthik", 50);
        manager.addStudentMarks("Karthik", 60);

        assertEquals("PASS", manager.getStudentResult("Karthik"));
    }

    @Test
    void testStudentNotFound() {
        assertThrows(IllegalArgumentException.class, () -> {
            manager.addStudentMarks("Unknown", 50);
        });
    }

    @Test
    void testFindTopper() {
        manager.registerStudent("Monesh");
        manager.registerStudent("Karthik");
        manager.registerStudent("Suresh");

        manager.addStudentMarks("Monesh", 60);
        manager.addStudentMarks("Karthik", 85);
        manager.addStudentMarks("Suresh", 70);

        assertEquals("Karthik", manager.findTopper());
    }

    @Test
    void testNoStudents() {
        assertThrows(IllegalStateException.class, () -> {
            manager.findTopper();
        });
    }
}

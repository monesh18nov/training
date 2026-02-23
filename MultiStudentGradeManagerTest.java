import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MultiStudentGradeManagerTest {

     MultiStudentGradeManager manager;

    @BeforeEach
    void setup() {
        manager = new MultiStudentGradeManager();
    }

    @Test
    void testMultipleStudentsIndependently() {
        manager.addStudent("Amit");
        manager.addStudent("Rahul");

        manager.addMarks("Amit", 50);
        manager.addMarks("Rahul", 80);

        assertEquals(50.0, manager.calculateAverage("Amit"));
        assertEquals(80.0, manager.calculateAverage("Rahul"));
    }

    @Test
    void testAveragePerStudent() {
        manager.addStudent("Amit");
        manager.addMarks("Amit", 40);
        manager.addMarks("Amit", 60);

        assertEquals(50.0, manager.calculateAverage("Amit"));
    }

    @Test
    void testGetResult() {
        manager.addStudent("Amit");
        manager.addMarks("Amit", 30);
        manager.addMarks("Amit", 35);

        assertEquals("FAIL", manager.getResult("Amit"));

        manager.addStudent("Rahul");
        manager.addMarks("Rahul", 50);
        manager.addMarks("Rahul", 60);

        assertEquals("PASS", manager.getResult("Rahul"));
    }

    @Test
    void testStudentNotFound() {
        assertThrows(IllegalArgumentException.class, () -> {
            manager.addMarks("Unknown", 50);
        });
    }

    @Test
    void testGetTopper() {
        manager.addStudent("Amit");
        manager.addStudent("Rahul");
        manager.addStudent("Sita");

        manager.addMarks("Amit", 60);
        manager.addMarks("Rahul", 85);
        manager.addMarks("Sita", 70);

        assertEquals("Rahul", manager.getTopper());
    }

    @Test
    void testNoStudents() {
        assertThrows(IllegalStateException.class, () -> {
            manager.getTopper();
        });
    }
}
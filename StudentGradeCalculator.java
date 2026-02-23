import java.util.ArrayList;
import java.util.List;

public class StudentGradeCalculator {

    private List<Integer> marks = new ArrayList<>();

    // Add marks
    public void addMarks(int mark) {
        if (mark < 0) {
            throw new IllegalArgumentException("Marks cannot be negative");
        }
        marks.add(mark);
    }

    // Calculate average
    public double calculateAverage() {
        if (marks.isEmpty()) {
            throw new IllegalStateException("No marks added");
        }

        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }

        return (double) sum / marks.size();
    }

    // PASS if average >= 40
    public String getResult() {
        double average = calculateAverage();
        return average >= 40 ? "PASS" : "FAIL";
    }
}
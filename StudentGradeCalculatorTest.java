import java.util.ArrayList;
import java.util.List;

public class StudentGradeCalculator {

    private List<Integer> marks = new ArrayList<>();

    public void addMarks(int mark) {
        if (mark < 0) {
            throw new IllegalArgumentException("Marks cannot be negative");
        }
        marks.add(mark);
    }

    public double calculateAverage() {
        if (marks.isEmpty()) return 0.0;

        int sum = 0;
        for (int m : marks) {
            sum += m;
        }
        return (double) sum / marks.size();
    }

    public String getResult() {
        double avg = calculateAverage();
        return avg >= 40 ? "PASS" : "FAIL";
    }
}

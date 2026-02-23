import java.util.HashMap;
import java.util.Map;

public class MultiStudentGradeManager {

    private Map<String, StudentGradeCalculator> studentMap = new HashMap<>();

    public void registerStudent(String studentName) {
        if (studentMap.containsKey(studentName)) {
            throw new IllegalArgumentException("Student already exists");
        }
        studentMap.put(studentName, new StudentGradeCalculator());
    }

    public void addStudentMarks(String studentName, int score) {
        StudentGradeCalculator calc = studentMap.get(studentName);
        if (calc == null) {
            throw new IllegalArgumentException("Student not found");
        }
        calc.addMarks(score);
    }

    public double getStudentAverage(String studentName) {
        StudentGradeCalculator calc = studentMap.get(studentName);
        if (calc == null) {
            throw new IllegalArgumentException("Student not found");
        }
        return calc.calculateAverage();
    }

    public String getStudentResult(String studentName) {
        StudentGradeCalculator calc = studentMap.get(studentName);
        if (calc == null) {
            throw new IllegalArgumentException("Student not found");
        }
        return calc.getResult();
    }

    public String findTopper() {
        if (studentMap.isEmpty()) {
            throw new IllegalStateException("No students available");
        }

        String topStudent = null;
        double maxAverage = Double.MIN_VALUE;

        for (Map.Entry<String, StudentGradeCalculator> entry : studentMap.entrySet()) {
            double avg = entry.getValue().calculateAverage();
            if (avg > maxAverage) {
                maxAverage = avg;
                topStudent = entry.getKey();
            }
        }

        return topStudent;
    }
}

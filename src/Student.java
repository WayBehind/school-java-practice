import java.util.*;

public class Student {
    private String name;
    private Map<Subject, Grade> studentSubjectGrades;
    private Set<Subject> takingSubjects;

    public Student(String name, Map<Subject, Grade> studentSubjectGrades) {
        this.name = name;
        this.studentSubjectGrades = studentSubjectGrades;
        this.takingSubjects = studentSubjectGrades.keySet();
    }

    public String getName() {
        return name;
    }

    public Map<Subject, Grade> getStudentSubjectGrades() {
        return studentSubjectGrades;
    }

    public Double getAverageGrade() {
        return this.studentSubjectGrades.values().stream()
                .mapToDouble(grade -> grade.getIntValue())
                .average()
                .orElse(0.0);
    }
}

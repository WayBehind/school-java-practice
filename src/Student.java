import java.util.List;
import java.util.OptionalDouble;

public class Student {
    private String name;
    private List<Subject> takingSubjects;
    private List<Grade> studentsGrades; // MUST have grade in every subject!!!

    public Student(String name, List<Subject> takingSubjects, List<Grade> studentsGrades) {
        this.name = name;
        this.takingSubjects = takingSubjects;
        this.studentsGrades = studentsGrades;
    }

    public String getName() {
        return name;
    }

    public List<Subject> getTakingSubjects() {
        return takingSubjects;
    }

    public List<Grade> getStudentsGrades() {
        return studentsGrades;
    }

    public Double getAverageGrade() {
        return this.studentsGrades.stream()
                .mapToDouble(Grade::getGradeValue)
                .average()
                .orElse(0.0);
    }
}

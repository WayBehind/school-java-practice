import java.util.*;

public class Student {
    private String name;
    private Map<Subject, Grade> studentsGradeInSubject;
    private Set<Subject> takingSubjects;

    public Student(String name, Map<Subject, Grade> studentsGradeInSubject) {
        this.name = name;
        this.studentsGradeInSubject = studentsGradeInSubject;
        this.takingSubjects = studentsGradeInSubject.keySet();
    }

    public String getName() {
        return name;
    }

    public Map<Subject, Grade> getStudentsGradeInSubject() {
        return studentsGradeInSubject;
    }

    public Set<Subject> getTakingSubjects() {
        return takingSubjects;
    }
    
    public Double getAverageGrade() {
        return this.studentsGradeInSubject.values().stream()
                .mapToDouble(grade -> grade.getIntValue())
                .average()
                .orElse(0.0);
    }
}

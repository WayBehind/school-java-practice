import java.util.List;

public class Student {
    private List<Subject> takingSubjects;
    private Clazz memberOfClazz;
    private List<Grade> studentsGrades; // MUST have grade in every subject!!!

    public Student(List<Subject> takingSubjects, Clazz memberOfClazz, List<Grade> studentsGrades) {
        this.takingSubjects = takingSubjects;
        this.memberOfClazz = memberOfClazz;
        this.studentsGrades = studentsGrades;
    }
}

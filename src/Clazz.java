import java.util.List;

public class Clazz {
    private String clazzName;
    private Teacher primaryTeacher;
    private List<Student> studentsInClass;

    public Clazz(String clazzName, Teacher primaryTeacher, List<Student> studentsInClass) {
        this.clazzName = clazzName;
        this.primaryTeacher = setInitialPrimaryTeacher(primaryTeacher);
        this.studentsInClass = studentsInClass;
    }

    public String getClazzName() {
        return clazzName;
    }

    public List<Student> getStudentsInClass() {
        return studentsInClass;
    }

    private Teacher setInitialPrimaryTeacher(Teacher primaryTeacher) {
        primaryTeacher.setPrimaryTeacher(true);
        return primaryTeacher;
    }

    public Double getClazzAverageGrade() {
        return this.getStudentsInClass().stream()
                .mapToDouble(Student::getAverageGrade)
                .average()
                .orElse(0.0);
    }
}

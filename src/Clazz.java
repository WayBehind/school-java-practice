import java.util.List;

public class Clazz {
    private String name;
    private Teacher primaryTeacher;
    private List<Student> studentsInClazz;

    public Clazz(String name, Teacher primaryTeacher, List<Student> studentsInClazz) {
        this.name = name;
        this.primaryTeacher = primaryTeacher;
        this.studentsInClazz = studentsInClazz;
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudentsInClazz() {
        return studentsInClazz;
    }
}

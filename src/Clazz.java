import java.util.List;

public class Clazz {
    private List<Student> studentsInClazz;
    private Teacher primaryTeacher;

    public Clazz(List<Student> studentsInClazz, Teacher primaryTeacher) {
        this.studentsInClazz = studentsInClazz;
        this.primaryTeacher = primaryTeacher;
    }
}

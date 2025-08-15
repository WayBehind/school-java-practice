import java.util.ArrayList;
import java.util.List;

public class Teacher {
private String teacherName;
private List<Subject> teachingSubjects;
private boolean isPrimaryTeacher;

    public Teacher(String teacherName) {
        this.teacherName = teacherName;
        this.teachingSubjects = new ArrayList<>();
        this.isPrimaryTeacher = false;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public List<Subject> getTeachingSubjects() {
        return teachingSubjects;
    }

    public boolean isPrimaryTeacher() {
        return isPrimaryTeacher;
    }

    public void setPrimaryTeacher(boolean primaryTeacher) {
        isPrimaryTeacher = primaryTeacher;
    }

    public void addToTeachingSubjects(Subject subject) {
        if (!subject.isHasTeacher()){
            subject.setHasTeacher(true);
            this.teachingSubjects.add(subject);
        }
    }
}

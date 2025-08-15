public class Subject {
    private String subjectName;
    private boolean hasTeacher;

    public Subject(String subjectName) {
        this.subjectName = subjectName;
        this.hasTeacher = false;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public boolean isHasTeacher() {
        return hasTeacher;
    }

    public void setHasTeacher(boolean hasTeacher) {
        this.hasTeacher = hasTeacher;
    }
}

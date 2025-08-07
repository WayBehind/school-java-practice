import java.util.List;

public class Grade {
    private Double gradeValue;
    private Subject gradeInSubject;

    public Grade(int gradeValue, Subject gradeInSubject) {
        this.gradeValue = (double) gradeValue;
        this.gradeInSubject = gradeInSubject;
    }

    public Double getGradeValue() {
        return gradeValue;
    }
}

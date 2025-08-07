import java.util.List;

public class Teacher {
    private String name;
    private List<Subject> subjectsTought;

    public Teacher(String name, List<Subject> subjectsThought) {
        this.name = name;
        this.subjectsTought = subjectsThought;
    }
}

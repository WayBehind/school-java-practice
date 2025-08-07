import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Subject subEn = new Subject("English");
        Subject subSp = new Subject("Spanish");
        Subject subPe = new Subject("Physical Education");
        Subject subMa = new Subject("Math");
        Subject subPh = new Subject("Physics");
        Subject subCh = new Subject("Chemistry");

        Teacher teacher1 = new Teacher("Simmons", List.of(subEn, subSp));
        Teacher teacher2 = new Teacher("Waters", List.of(subMa, subPh));
        Teacher teacher3 = new Teacher("Hogger", List.of(subPe, subCh));

        Student student1 = new Student("Carley", List.of(subMa, subPh, subCh), List.of(
                new Grade(1, subMa),
                new Grade(1, subPh),
                new Grade(1, subCh)
        ));
        Student student2 = new Student("Joe", List.of(subEn, subSp, subPe), List.of(
                new Grade(2, subEn),
                new Grade(3, subSp),
                new Grade(2, subPe)
        ));
        Student student3 = new Student("Bob", List.of(subSp, subPe, subMa), List.of(
                new Grade(1, subSp),
                new Grade(1, subPe),
                new Grade(4, subMa)
        ));
        Student student4 = new Student("Mathew", List.of(subMa, subPh, subEn), List.of(
                new Grade(1, subMa),
                new Grade(2, subPh),
                new Grade(3, subEn)
        ));
        Student student5 = new Student("Gregor", List.of(subEn, subSp, subPh), List.of(
                new Grade(1, subEn),
                new Grade(3, subSp),
                new Grade(1, subPh)
        ));
        Student student6 = new Student("Blair", List.of(subMa, subPh, subCh), List.of(
                new Grade(2, subMa),
                new Grade(2, subPh),
                new Grade(2, subCh)
        ));

        Clazz clazz1 = new Clazz("4.A", teacher1, List.of(student1, student2, student3));
        Clazz clazz2 = new Clazz("4.B", teacher2, List.of(student4, student5, student6));

        printStudentsByAverageGrade(clazz1);
        printStudentsByAverageGrade(clazz2);

    }

    public static void printStudentsByAverageGrade(Clazz clazz) {
        System.out.println("Sorted students of class" + clazz.getName() +  " by their average grades: ");
        clazz.getStudentsInClazz().stream()
                .sorted(Comparator.comparingDouble(Student::getAverageGrade))
                .forEach(student -> System.out.println(student.getName() + " - " + student.getAverageGrade()));

    }


}
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Subject subMath = new Subject("Math");
        Subject subEng = new Subject("English");
        Subject subArt = new Subject("Art");
        Subject subSports = new Subject("Sports");

        Teacher teacher1 = new Teacher("Mr. Stevens");
        teacher1.addToTeachingSubjects(subMath);
        teacher1.addToTeachingSubjects(subSports);

        Teacher teacher2 = new Teacher("Mrs. Howard");
        teacher2.addToTeachingSubjects(subEng);
        teacher2.addToTeachingSubjects(subArt);

        Map<Subject, Grade> student1Grades = new HashMap<>();
        student1Grades.put(subMath, Grade.FOUR);
        student1Grades.put(subEng, Grade.FOUR);
        student1Grades.put(subArt, Grade.THREE);
        student1Grades.put(subSports, Grade.TWO);
        Student student1 = new Student("Daniel", student1Grades);

        Map<Subject, Grade> student2Grades = new HashMap<>();
        student2Grades.put(subMath, Grade.ONE);
        student2Grades.put(subEng, Grade.TWO);
        student2Grades.put(subArt, Grade.THREE);
        student2Grades.put(subSports, Grade.FOUR);
        Student student2 = new Student("Rachel", student2Grades);

        Map<Subject, Grade> student3Grades = new HashMap<>();
        student3Grades.put(subMath, Grade.TWO);
        student3Grades.put(subEng, Grade.THREE);
        student3Grades.put(subArt, Grade.THREE);
        student3Grades.put(subSports, Grade.ONE);
        Student student3 = new Student("Tom", student3Grades);

        Map<Subject, Grade> student4Grades = new HashMap<>();
        student4Grades.put(subMath, Grade.THREE);
        student4Grades.put(subEng, Grade.TWO);
        student4Grades.put(subArt, Grade.THREE);
        student4Grades.put(subSports, Grade.TWO);
        Student student4 = new Student("Diana", student4Grades);

        Map<Subject, Grade> student5Grades = new HashMap<>();
        student5Grades.put(subMath, Grade.ONE);
        student5Grades.put(subEng, Grade.ONE);
        student5Grades.put(subArt, Grade.ONE);
        student5Grades.put(subSports, Grade.ONE);
        Student student5 = new Student("Adam", student5Grades);

        Map<Subject, Grade> student6Grades = new HashMap<>();
        student6Grades.put(subMath, Grade.FIVE);
        student6Grades.put(subEng, Grade.FIVE);
        student6Grades.put(subArt, Grade.FIVE);
        student6Grades.put(subSports, Grade.FIVE);
        Student student6 = new Student("Silvio", student6Grades);

        List<Student> allStudents = new ArrayList<>(List.of(student1, student2, student3, student4, student5, student6));
        Clazz clazz1 = new Clazz("4.A", teacher1, List.of(student1, student2, student3));
        Clazz clazz2 = new Clazz("4.B", teacher2, List.of(student4, student5, student6));


        System.out.println("Sorted students by their average grades: ");
        printAllStudentsByGrade(allStudents);
        System.out.println("Sorted subjects by their average grades: ");
        printSubjectsByGradesOfStudents(allStudents);
        System.out.println("Sorted classes by their average grades: ");
        printClazzesByBestStudent(List.of(clazz1, clazz2));

    }

    public static void printAllStudentsByGrade(List<Student> studentList) {
        studentList.stream()
                .sorted(Comparator.comparingDouble(Student::getAverageGrade))
                .forEach(student -> System.out.println(student.getName() + " - " + student.getAverageGrade()));
    }

    public static void printSubjectsByGradesOfStudents(List<Student> studentList) {

        Map<Subject, List<Grade>> gradesBySubject = new HashMap<>();
        Map<String, Double> sortedSubjectsByGrades = new HashMap<>();

        studentList.stream()
                .flatMap(student -> student.getStudentSubjectGrades().entrySet().stream())
                .forEach(subject -> {
                    gradesBySubject.computeIfAbsent(subject.getKey(), grades -> new ArrayList<>()).add(subject.getValue());
                });
        gradesBySubject.forEach((subject, grades) -> sortedSubjectsByGrades.put(subject.getSubjectName(), grades.stream()
                .mapToDouble(Grade::getIntValue)
                .average()
                .orElse(0.0)));
        sortedSubjectsByGrades.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(stringDoubleEntry -> System.out.println(stringDoubleEntry.getKey() + " - " + stringDoubleEntry.getValue()));
    }

    public static void printClazzesByBestStudent(List<Clazz> clazzes) {
        clazzes.stream()
                .sorted(Comparator.comparing(Clazz::getClazzAverageGrade))
                .forEach(clazz -> System.out.println(clazz.getClazzName() + " - " + clazz.getClazzAverageGrade()));
    }

}
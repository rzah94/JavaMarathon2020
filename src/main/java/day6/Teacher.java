package day6;

import java.util.Random;

public class Teacher {
    private String name;
    private String subject;
    private Random random = new Random();

    public Teacher(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void evaluate(Student student) {

        int min = 2;
        int max = 5;

        int gradeNumber = random.nextInt(max - min + 1) + min;
        String grade = getGrade(gradeNumber);

        System.out.printf("Преподаватель %s оценил студента с именем %s по предмету %s на оценку %s.",
                this.name, student.getName(), this.getSubject(), grade);

    }

    private String getGrade(int grade) {
        return switch (grade) {
            case 5 -> "отлично";
            case 4 -> "хорошо";
            case 3 -> "удовлетворительно";
            case 2 -> "неудовлетворительно";
            default -> throw new IllegalArgumentException("Некорректная оценка");
        };
    }
}

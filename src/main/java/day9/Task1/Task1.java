package day9.Task1;

public class Task1 {
    public static void main(String[] args) {

        Student student = new Student("Игорь", "6Б");
        Teacher teacher = new Teacher("Иван", "Химия");

        student.printInfo();
        teacher.printInfo();

    }
}

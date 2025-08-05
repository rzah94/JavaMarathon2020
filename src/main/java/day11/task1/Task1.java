package day11.task1;

import java.math.BigDecimal;

public class Task1 {
    public static void main(String[] args) {
        Warehouse warehouse1 = new Warehouse();

        Picker picker1 = new Picker(warehouse1);
        Courier courier1 = new Courier(warehouse1);

        while (picker1.getSalary().compareTo(new BigDecimal("80").multiply(new BigDecimal("1500"))) < 0) {
            picker1.doWork();
        }
        picker1.bonus();

        BigDecimal million = new BigDecimal("1000000");
        while (warehouse1.getBalance().compareTo(million) < 0) {
            courier1.doWork();
        }
        courier1.bonus();

        // Вывод состояния склада и сотрудников 1
        System.out.println("Warehouse 1: " + warehouse1);
        System.out.println("Picker 1 Salary: " + picker1.getSalary());
        System.out.println("Courier 1 Salary: " + courier1.getSalary());

        // Создаем второй склад и сотрудников
        Warehouse warehouse2 = new Warehouse();
        Picker picker2 = new Picker(warehouse2);
        Courier courier2 = new Courier(warehouse2);

        // Однократный вызов doWork() для каждого сотрудника второго склада
        picker2.doWork();
        courier2.doWork();

        // Вывод состояния склада и сотрудников 2
        System.out.println("Warehouse 2: " + warehouse2);
        System.out.println("Picker 2 Salary: " + picker2.getSalary());
        System.out.println("Courier 2 Salary: " + courier2.getSalary());

        // Проверяем, что первый склад и сотрудники не изменились после работы второго склада
        System.out.println("\nПроверка склада 1 и сотрудников после работы склада 2:");
        System.out.println("Warehouse 1: " + warehouse1);
        System.out.println("Picker 1 Salary: " + picker1.getSalary());
        System.out.println("Courier 1 Salary: " + courier1.getSalary());

    }
}

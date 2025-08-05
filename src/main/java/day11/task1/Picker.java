package day11.task1;

import java.math.BigDecimal;

public class Picker implements Worker {
    private Warehouse warehouse;
    private BigDecimal salary = BigDecimal.ZERO;

    private final static BigDecimal SALARY_PER_WORK = new BigDecimal(80);

    public Picker(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    @Override
    public void doWork() {
        System.out.println("Выплачена зп " + SALARY_PER_WORK);
        salary = salary.add(SALARY_PER_WORK);
        warehouse.setCountOrder(warehouse.getCountOrder() + 1);
    }

    @Override
    public void bonus() {
        // При достижении 1500 заказов зарплата сборщика утраивается
        if (warehouse.getCountOrder() >= 1500) {
            salary = salary.multiply(new BigDecimal(3));
        }
    }

    @Override
    public String toString() {
        return "Picker{" +
               "warehouse=" + warehouse +
               ", salary=" + salary +
               '}';
    }
}

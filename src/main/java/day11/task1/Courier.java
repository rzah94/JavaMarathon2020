package day11.task1;

import java.math.BigDecimal;

public class Courier implements  Worker {
    private Warehouse warehouse;
    private BigDecimal salary = BigDecimal.ZERO;

    private final static BigDecimal SALARY_PER_WORK = new BigDecimal(100);

    public Courier(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    @Override
    public void doWork() {
        System.out.println("Выплачена зп " + SALARY_PER_WORK);
        salary = salary.add(new BigDecimal(100));
        warehouse.setBalance(warehouse.getBalance().add(SALARY_PER_WORK));
    }

    @Override
    public void bonus() {
        // При достижении баланса 1_000_000 зарплата курьера удваивается

        BigDecimal targetBalance = new BigDecimal(1_000_000);

        if (warehouse.getBalance().compareTo(targetBalance) >= 0) {
            salary = salary.multiply(new BigDecimal(2));
        }
    }

    @Override
    public String toString() {
        return "Courier{" +
               "warehouse=" + warehouse +
               ", salary=" + salary +
               '}';
    }
}

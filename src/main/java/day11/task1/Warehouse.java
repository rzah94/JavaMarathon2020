package day11.task1;

import java.math.BigDecimal;

public class Warehouse {
    // количество собранных заказов
    private long countOrder;
    // доход от доставленных заказов
    private BigDecimal balance = BigDecimal.ZERO;

    public long getCountOrder() {
        return countOrder;
    }

    public void setCountOrder(long countOrder) {
        this.countOrder = countOrder;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
               "countOrder=" + countOrder +
               ", balance=" + balance +
               '}';
    }
}

package day15;

public class Shoes {
    private final String name;
    private final int size;
    private final int quantity;

    public Shoes(String name, int size, int quantity) {
        this.name = name;
        this.size = size;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Shoes{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", quantity=" + quantity +
                '}';
    }
}

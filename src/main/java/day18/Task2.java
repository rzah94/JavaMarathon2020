package day18;

public class Task2 {
    public static void main(String[] args) {
        System.out.println(count7(777777237)); // 7
    }

    public static int count7(int number) {

        int sevenCount = 0;
        int currentNumber = number % 10;

        if (currentNumber == 7) {
            sevenCount++;
        }

        int nextNumber = number / 10;

        if (nextNumber == 0) {
            return sevenCount;
        }

        return sevenCount + count7(nextNumber);
    }
}

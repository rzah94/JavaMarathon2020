package day18;

public class Task1 {
    public static void main(String[] args) {
         int[] numbers = {1, 10, 1241, 50402};

        System.out.println(recursionSum(numbers, 0));
    }

    public static int recursionSum(int[] numbers, int currentIndex) {


        if (currentIndex >= numbers.length) {
            return 0;
        }

        return numbers[currentIndex] + recursionSum(numbers, currentIndex + 1);
    }
}

package FirstLesson;

import Utilities.Commons;

import java.util.Arrays;
import java.util.Scanner;

public class ExerciseTwo extends Commons {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the size of array.");
        int arraySize = checkArraySize(scanner.nextInt());
        int[] numbers = new int[arraySize];
        System.out.println("Please enter " + arraySize + " numbers to fill the array.");
        for (int i = 0; i < arraySize; i++) {
            numbers[i] = scanner.nextInt();
            System.out.println(COLOR_GREEN + (arraySize - 1 - i) + COLOR_RESET + " numbers left" + COLOR_RESET);
        }
        System.out.println("This is your array: " + Arrays.toString(numbers));
        System.out.println(COLOR_GREEN + "By IntStream summaryStatistics()" + COLOR_RESET);
        System.out.println("Maximum value of array is: " + Arrays.stream(numbers).summaryStatistics().getMax());
        System.out.println("The average number in the array is: " + Arrays.stream(numbers).summaryStatistics()
                .getAverage());
        System.out.println(COLOR_GREEN + "By Foreach" + COLOR_RESET);
        System.out.println("Maximum value of array is: " + getMaximumValueByForeach(numbers));
        System.out.println("The average number in the array is: " + getAverageValueByForeach(numbers));
    }

    public static int getMaximumValueByForeach(int[] array) {

        int maxValue = array[0];

        for (int x : array) {
            if (maxValue < x) maxValue = x;
        }
        return maxValue;
    }

    public static double getAverageValueByForeach(int[] array) {

        int sum = 0;

        for (int x : array) sum = sum + x;
        return (double) sum / array.length;
    }

    public static int checkArraySize(int arraySize) {

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            if (arraySize > 0) break;
            System.out.println(COLOR_YELLOW + "You entered a size value " + arraySize + ". The size of the array must be"
                    + " greater than 0." + COLOR_GREEN);
            arraySize = scanner.nextInt();
            if (i == 3) {
                System.out.println(COLOR_RED + "You have entered a wrong value 5 times, the program is blocked.");
                System.exit(0);
            }
        }
        return arraySize;
    }
}

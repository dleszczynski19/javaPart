package FirstLesson;

import Utilities.Commons;

import java.util.Arrays;

public class ExerciseTwo extends Commons {

    public enum StatisticsType {
        BY_STREAM, BY_FOREACH
    }

    public static void runExerciseTwo() {

        System.out.println("Please enter the size of array.");
        int arraySize = validateValue(scanner.nextLine(), ValidatorType.ARRAY_SIZE);
        int[] numbers = new int[arraySize];
        System.out.println("Please enter " + arraySize + " numbers to fill the array.");
        for (int i = 0; i < arraySize; i++) {
            numbers[i] = validateValue(scanner.nextLine(), ValidatorType.INT_TYPE);
            System.out.println(colorGreen + (arraySize - 1 - i) + colorReset + " numbers left" + colorReset);
        }
        System.out.println("This is your array: " + Arrays.toString(numbers));
        getStatistics(numbers, StatisticsType.BY_STREAM);
        getStatistics(numbers, StatisticsType.BY_FOREACH);
    }

    public static void getStatistics(int[] numbers, StatisticsType statisticsType) {

        String text;
        int maxValue;
        double average;

        switch (statisticsType) {
            case BY_STREAM:
                text = "By IntStream summaryStatistics()";
                maxValue = Arrays.stream(numbers).summaryStatistics().getMax();
                average = Arrays.stream(numbers).summaryStatistics().getAverage();
                break;
            case BY_FOREACH:
                text = "By Foreach";
                maxValue = getMaximumValueByForeach(numbers);
                average = getAverageValueByForeach(numbers);
                break;
            default:
                throw new IllegalArgumentException("Wrong value: " + statisticsType);
        }
        System.out.println(colorGreen + text + colorReset + "\nMaximum value of array is: " + maxValue +
                "\nThe average number in the array is: " + average);
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
}

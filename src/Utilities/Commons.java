package Utilities;

import java.util.Scanner;

public class Commons {

    public static final String colorReset = "\u001B[0m";
    public static final String colorGreen = "\u001B[32m";
    public static final String colorRed = "\u001B[31m";
    public static final String colorYellow = "\u001B[33m";
    public static Scanner scanner = new Scanner(System.in);

    public enum ValidatorType {
        EXERCISE_INDEX, NUMBER_RANGE, ARRAY_SIZE, INT_TYPE;
    }

    public static int validateValue(String value, ValidatorType validatorType) {

        for (int i = 0; i < 4; i++) {
            if (value.matches("[0-9]+")) {
                switch (validatorType) {
                    case ARRAY_SIZE:
                        if (Integer.parseInt(value) > 0) return Integer.parseInt(value);
                        System.out.println(colorYellow + "You entered a size value " + value + ". The size of the array must be"
                                + " greater than 0." + colorGreen);
                        break;
                    case NUMBER_RANGE:
                        if (Integer.parseInt(value) >= 0 && Integer.parseInt(value) <= 99) return Integer.parseInt(value);
                        System.out.println(colorYellow + "You entered a number " + value + " which is not in the specified" +
                                " range 0-99. Enter properly number:" + colorReset);
                        break;
                    case EXERCISE_INDEX:
                        if (value.matches("[1-2]+")) return Integer.parseInt(value);
                        System.out.println(colorYellow + "Type 1 or 2 to choose exercise" + colorReset);
                        break;
                    case INT_TYPE:
                        return Integer.parseInt(value);
                }
            } else {
                System.out.println(colorYellow + "You need to type a number!" + colorReset);
            }
            value = scanner.nextLine();
            if (i == 3) {
                System.out.println(colorRed + "You have entered a wrong value 5 times, the program is blocked.");
                System.exit(0);
            }
        }
        return Integer.parseInt(value);
    }
}
package Utilities;

import java.util.Scanner;

public class Commons {
    public static final String colorReset = "\u001B[0m";
    public static final String colorGreen = "\u001B[32m";
    public static final String colorRed = "\u001B[31m";
    public static final String colorYellow = "\u001B[33m";
    public static final String colorBlue = "\u001B[34m";
    public static final String colorPurple = "\u001B[35m";
    public static final String colorCyan = "\u001B[36m";
    public static Scanner scanner = new Scanner(System.in);

    public enum ValidatorType {
        NUMBER_RANGE, ARRAY_SIZE, INT_TYPE, PROGRAM_OPTION, EDIT_OPTION;
    }

    public static int validateValue(String value, ValidatorType validatorType) {
        String text;
        for (int i = 0; i < 4; i++) {
            if (value.matches("[0-9]+")) {
                switch (validatorType) {
                    case ARRAY_SIZE:
                        if (Integer.parseInt(value) > 0) return Integer.parseInt(value);
                        text = "You entered a size value " + value + ". The size of the array must be greater than 0.";
                        break;
                    case NUMBER_RANGE:
                        if (Integer.parseInt(value) >= 0 && Integer.parseInt(value) <= 99)
                            return Integer.parseInt(value);
                        text = "You entered a number " + value + " which is not in the specified range 0-99. "
                                + "Enter properly number:";
                        break;
                    case PROGRAM_OPTION:
                        if (value.matches("[1-6]")) return Integer.parseInt(value);
                        text = "Type between 1 and 5 to choose program.";
                        break;
                    case EDIT_OPTION:
                        if (value.matches("[1-4]")) return Integer.parseInt(value);
                        text = "Type between 1 and 4 to choose program.";
                        break;
                    case INT_TYPE:
                        return Integer.parseInt(value);
                    default:
                        text = "Wrong value!";
                }
            } else {
                text = "You need to type a positive number!";
            }
            System.out.println(colorYellow + text + colorReset);
            value = scanner.nextLine();
            blockProgram(i, 3);
        }
        return Integer.parseInt(value);
    }

    protected static void blockProgram(int tries, int triesCount) {
        if (tries == triesCount) {
            System.out.println(colorRed + "You have entered a wrong value " + (triesCount + 2) + " times, the program is blocked.");
            System.exit(0);
        }
    }
}
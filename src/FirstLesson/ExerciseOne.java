package FirstLesson;

import java.util.Random;
import java.util.Scanner;

public class ExerciseOne {

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static void main(String[] arg) {

        int numberToGuess = new Random().nextInt(100);
        Scanner scanner = new Scanner(System.in);

        System.out.println("What's is your name?");
        String name = scanner.nextLine();
        System.out.println("Hello " + name + "! Please enter a number to guess an integer in the range 0-99. " +
                "You have just 5 tries.");
        for (int i = 0; i <= 4; i++) {
            int enteredNumber = checkNumber(scanner.nextInt());
            if (enteredNumber == numberToGuess) {
                System.out.println(ANSI_GREEN + "Congratulations " + name + ", you guessed it!");
                break;
            }
            if (i == 4) {
                System.out.println("Sorry you didn't guess the number, the answer was: " + ANSI_RED + numberToGuess);
                return;
            }
            if (enteredNumber > numberToGuess) {
                System.out.println("Your number is GREATER than the one you are trying to guess");
            } else {
                System.out.println("Your number is LOWER than the one you are trying to guess");
            }
            System.out.println("You still have " + ANSI_YELLOW + (4 - i) + ANSI_RESET + " chance, please try again.");
        }
    }

    public static int checkNumber(int enteredNumber) {

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            if (enteredNumber >= 0 && enteredNumber <= 99) break;
            System.out.println(ANSI_YELLOW + "You entered a number " + enteredNumber + " which is not in the specified" +
                    " range 0-99. Enter properly number:" + ANSI_RESET);
            enteredNumber = scanner.nextInt();
            if (i == 3) {
                System.out.println(ANSI_RED + "You have entered a number out of range 5 times, the game is blocked.");
                System.exit(0);
            }
        }
        return enteredNumber;
    }
}
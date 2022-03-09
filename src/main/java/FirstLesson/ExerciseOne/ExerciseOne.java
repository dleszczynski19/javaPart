package FirstLesson.ExerciseOne;

import Utilities.Commons;

import java.util.Random;

public class ExerciseOne extends Commons {

    public void runExerciseOne() {
        int numberToGuess = new Random().nextInt(100);

        System.out.println("What's is your name?");
        String name = scanner.nextLine();
        System.out.println("Hello " + name + "! Please enter a number to guess an integer in the range 0-99. " +
                "You have just 5 tries.");
        for (int i = 0; i <= 4; i++) {
            int enteredNumber = validateValue(scanner.nextLine(), ValidatorType.NUMBER_RANGE);
            if (enteredNumber == numberToGuess) {
                System.out.println(colorGreen + "Congratulations " + name + ", you guessed it!");
                break;
            }
            if (i == 4) {
                System.out.println("Sorry you didn't guess the number, the answer was: " + colorRed + numberToGuess);
                return;
            }
            if (enteredNumber > numberToGuess) {
                System.out.println("Your number is GREATER than the one you are trying to guess");
            } else {
                System.out.println("Your number is LOWER than the one you are trying to guess");
            }
            System.out.println("You still have " + colorYellow + (4 - i) + colorReset + " chance, please try again.");
        }
    }
}
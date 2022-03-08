package FirstLesson;

import Utilities.Commons;

public class Run extends Commons {

    public static void main(String[] args) {

        ExerciseOne exerciseOne = new ExerciseOne();
        ExerciseTwo exerciseTwo = new ExerciseTwo();

        System.out.println("Type 1 to choose exercise one, and 2 for second one.");
        int exercise = validateValue(scanner.nextLine(), ValidatorType.EXERCISE_INDEX);
        switch (exercise) {
            case 1:
                exerciseOne.runExerciseOne();
                break;
            case 2:
                exerciseTwo.runExerciseTwo();
                break;
        }
    }
}

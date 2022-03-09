package ThirdLesson.ExerciseThree;

import Utilities.Commons;

public class Main extends Commons {

    public static void main(String[] args) {
        Company company = new Company();
        ProgramAction programAction = new ProgramAction();

        for (int i = 0; i < 5; i++) programAction.addEmployee(company);
        programAction.startProgram(company);
    }
}
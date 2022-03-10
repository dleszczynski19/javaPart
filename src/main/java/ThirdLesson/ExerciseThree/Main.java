package ThirdLesson.ExerciseThree;

import Utilities.Commons;

public class Main extends Commons {
    public static void main(String[] args) {
        Company company = new Company();
        ProgramAction programAction = new ProgramAction();

        programAction.addEmployee(company, 5);
        programAction.startProgram(company);
    }
}
package ThirdLesson.ExerciseThree;

import Utilities.Commons;

public class Utils extends Commons {
    public static String validateStringData(String name) {
        for (int i = 0; i < 5; i++) {
            if (name.matches("[a-zA-Z-]+")) {
                return name;
            }
            System.out.println(colorYellow + "You need to use letters, try again:" + colorReset);
            name = scanner.nextLine();
            blockProgram(i, 4);
        }
        return name;
    }

    public static double validateSalary(String value) {
        for (int i = 0; i < 4; i++) {
            try {
                return Double.parseDouble(value);
            } catch (Exception e) {
                System.out.println(colorYellow + "Wrong value of salary, try again:" + colorReset);
                value = scanner.nextLine();
            }
            blockProgram(i, 3);
        }
        return Double.parseDouble(value);
    }

    public static int validateEmployeeId(Company company, String value) {
        for (int i = 0; i < 4; i++) {
            if (value.matches("[0-9]+")) {
                int id = Integer.parseInt(value);
                if (id <= company.employeesList.size() && id > 0) return id;
                System.out.println(colorYellow + "There is no employee with this id in the database, try again:" + colorReset);
            } else System.out.println(colorYellow + "You need to type a positive number!" + colorReset);
            value = scanner.nextLine();
            blockProgram(i, 3);
        }
        return Integer.parseInt(value);
    }
}
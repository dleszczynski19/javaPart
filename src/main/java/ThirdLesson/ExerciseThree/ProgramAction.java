package ThirdLesson.ExerciseThree;

import Utilities.Commons;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;

public class ProgramAction extends Utils {
    public void addEmployee(Company company, int employeeCount) {
        for (int i = 0; i < employeeCount; i++) {
            company.setEmployeeData();
            company.employeesList.add(new Employee(company.getEmployeeName(), company.getEmployeeLastName(),
                    company.getEmployeeSalary(), company.employeesList.size() + 1));
        }
    }

    public void startProgram(Company company) {
        ProgramAction programAction = new ProgramAction();

        getProgramMenu();
        int programIndex = validateValue(scanner.nextLine(), Commons.ValidatorType.PROGRAM_OPTION);
        switch (programIndex) {
            case 1:
                System.out.println(colorGreen + "You chose sum salary of all employees." + colorReset);
                company.showSalarySum();
                break;
            case 2:
                System.out.println(colorGreen + "You chose display all employee data." + colorReset);
                company.showAllEmployee();
                break;
            case 3:
                System.out.println(colorGreen + "You chose add new employee." + colorReset);
                programAction.addEmployee(company, 1);
                break;
            case 4:
                System.out.println(colorGreen + "You chose edit employee." + colorReset);
                editEmployee(company);
                break;
            case 5:
                System.out.println(colorGreen + "You chose create json file." + colorReset);
                createJson(company);
                break;
            case 6:
                System.out.println(colorRed + "Program end.");
                System.exit(0);
        }
        startProgram(company);
    }

    public void editEmployee(Company company) {
        System.out.println("Type id of employee to edit");
        Employee employee = company.employeesList.get(validateEmployeeId(company, scanner.nextLine()) - 1);
        getEditMenu(employee);
        int programIndex = validateValue(scanner.nextLine(), ValidatorType.EDIT_OPTION);
        switch (programIndex) {
            case 1:
                System.out.println(colorGreen + "You editing name." + colorReset);
                employee.setName(validateStringData(scanner.nextLine()));
                System.out.println("You set name to: " + colorGreen + employee.getName() + colorReset);
                break;
            case 2:
                System.out.println(colorGreen + "You editing last name." + colorReset);
                employee.setLastName(validateStringData(scanner.nextLine()));
                System.out.println("You set last name to: " + colorGreen + employee.getName() + colorReset);
                break;
            case 3:
                System.out.println(colorGreen + "You editing salary." + colorReset);
                employee.setSalary(validateSalary(scanner.nextLine()));
                System.out.println("You set salary to: " + colorGreen + employee.getName() + colorReset);
                break;
            case 4:
                System.out.println(colorGreen + "You editing whole data." + colorReset);
                company.setEmployeeData();
                employee.setAllData(company.getEmployeeName(), company.getEmployeeLastName(),
                        company.getEmployeeSalary());
                System.out.println("New data for employee: " + employee);
                break;
            default:
                System.out.println("Wrong value");
        }
    }

    private void getProgramMenu() {
        System.out.println("Choose action, press:");
        System.out.println(colorPurple + "1 – Print sum of all employees salary" + colorReset);
        System.out.println(colorBlue + "2 – Display all employees data" + colorReset);
        System.out.println(colorCyan + "3 – Add new employee" + colorReset);
        System.out.println(colorYellow + "4 – Edit employee" + colorReset);
        System.out.println(colorGreen + "5 - Create json file" + colorReset);
        System.out.println(colorRed + "6 - End program" + colorReset);
    }

    private void getEditMenu(Employee employee) {
        System.out.println("You editing data for: " + employee.getName() + " " + employee.getLastName() +
                " with salary: " + employee.getSalary());
        System.out.println("Choose action, press:");
        System.out.println(colorPurple + "1 – Edit name" + colorReset);
        System.out.println(colorBlue + "2 – Edit last name" + colorReset);
        System.out.println(colorCyan + "3 – Edit salary" + colorReset);
        System.out.println(colorYellow + "4 – Edit whole employee data" + colorReset);
    }

    public void createJson(Company company) {
        JSONObject jsonObject = new JSONObject();

        writeToJson(jsonObject.put("value", new JSONArray(company.employeesList)));
    }

    public void writeToJson(JSONObject json) {
        try {
            FileWriter myWriter = new FileWriter("src/test/resources/jsonFiles/employeesData.json");
            myWriter.write(json.toString());
            myWriter.close();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
package ThirdLesson.ExerciseThree;

import java.util.ArrayList;

public class Company extends Utils {

    public ArrayList<Employee> employeesList = new ArrayList<>();
    private String employeeName;
    private String employeeLastName;
    private double employeeSalary;

    public void setEmployeeData() {
        setEmployeeName();
        setEmployeeLastName();
        setEmployeeSalary();
    }

    public void setEmployeeName() {
        System.out.println("Type employee's name:");
        employeeName = validateStringData(scanner.nextLine());
        System.out.println(colorGreen + "You typed name: " + employeeName + colorReset);
    }

    public void setEmployeeLastName() {
        System.out.println("Type employee's last name:");
        employeeLastName = validateStringData(scanner.nextLine());
        System.out.println(colorGreen + "You typed last name: " + employeeLastName + colorReset);
    }

    public void setEmployeeSalary() {
        System.out.println("Type employee's salary:");
        employeeSalary = validateSalary(scanner.nextLine());
        System.out.println(colorGreen + "You typed salary: " + employeeSalary + colorReset);
    }

    public void showAllEmployee() {
        for (int i = 0; i <= employeesList.size() - 1; i++) {
            System.out.println(employeesList.get(i).getAllData());
        }
    }

    public void showSalarySum() {
        double sum = 0;
        for (int i = 0; i <= employeesList.size() - 1; i++) {
            sum += employeesList.get(i).getSalary();
        }
        System.out.println("Sum of employees salary: " + colorGreen + sum + colorReset);
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }
}
package ThirdLesson.ExerciseThree;

import Utilities.Commons;

public class Employee extends Commons {
    private String name;
    private String lastName;
    private double salary;
    private final int employeeId;

    public Employee(String name, String lastName, double salary, int employeeId) {
        this.name = name;
        this.lastName = lastName;
        this.salary = salary;
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "Salary for employee id: " + colorCyan + employeeId + colorReset + " name: " + colorPurple + name + " "
                + lastName + colorReset + " is " + colorBlue + salary + colorReset;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setAllData(String name, String lastName, double salary) {
        this.name = name;
        this.lastName = lastName;
        this.salary = salary;
    }
}
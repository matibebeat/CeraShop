package fr.efrei.domain;

public abstract class Employee {
    protected int employeeId;
    protected String firstName;

    protected String lastName;

    public int getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
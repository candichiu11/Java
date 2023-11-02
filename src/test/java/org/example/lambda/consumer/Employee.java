package org.example.lambda.consumer;

public class Employee {

    public String name;
    public int salary;
    public String gender;

    public Employee(String name, int salary, String gender) {
        this.name = name;
        this.salary = salary;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", gender='" + gender + '\'' +
                '}';
    }
}

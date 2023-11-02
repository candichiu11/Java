package org.example.lambda.predicate;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Demo2 {

    public static void main(String[] args) {
        Employee emp = new Employee("Candi Chiu", 73000, 5);

        // example 1
        // emp object --> return name if salary > 70000 && experience >3
        Predicate<Employee> checkEmp = e -> (e.salary > 70000 && e.experience > 3);
      //  System.out.println(checkEmp.test(emp));

        // example 2
        ArrayList<Employee> employeeArrayList = new ArrayList<>();
        employeeArrayList.add(emp);
        employeeArrayList.add(new Employee("Lilun Chiu", 75000, 1));
        employeeArrayList.add(new Employee("Niomi Smart", 5000, 5));
        employeeArrayList.add(new Employee("London Love", 80000, 3));
        employeeArrayList.add(new Employee("Munich Love", 895000, 10));

        for (Employee employee : employeeArrayList) {
            if (checkEmp.test(employee)) {
                System.out.println(employee.name + " " + employee.salary);
            }
        }

    }
}

package org.example.streams.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterAndMapDemo {

    public static void main(String[] args) {
      /*  List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Candi", 1, 75000));
        employeeList.add(new Employee("Lilun", 2, 80000));
        employeeList.add(new Employee("Java", 3, 85000));
        employeeList.add(new Employee("Spring", 4, 70000));
        employeeList.add(new Employee("Security", 5, 95000)); */

        List<Employee> employeeList = Arrays.asList(
                 new Employee("Candi", 1, 75000),
                 new Employee("Lilun", 2, 80000),
                 new Employee("Java", 3, 85000),
                 new Employee("Spring", 4, 70000),
                 new Employee("Security", 5, 95000));

        // combination of filter and map

        List<Integer> employeeSalary = employeeList.stream()
                                             .filter(employee -> employee.salary > 75000) //filtering
                                             .map(employee -> employee.salary)
                                             .collect(Collectors.toList());

        System.out.println(employeeSalary);


    }
}

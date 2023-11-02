package org.example.lambda.functions;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;

public class Demo2 {
    public static void main(String[] args) {

        ArrayList<Employee> employeeArrayList = new ArrayList<>();
        employeeArrayList.add(new Employee("Candi", 73000));
        employeeArrayList.add(new Employee("Lilun", 75000));
        employeeArrayList.add(new Employee("Chiu", 80000));
        employeeArrayList.add(new Employee("Yuri", 90000));
        employeeArrayList.add(new Employee("Linda", 97500));

        Function<Employee, Integer> bonusCalulation = e -> {
            int salary = e.salary;

            if (salary >= 70000 && salary <= 80000) {
                return salary * 10/100;

            } else if (salary > 80000 && salary <= 90000) {
                return salary *20/100;

            } else {
                return salary * 25/100;
            }

        };

        Predicate<Integer> bonusGreatorThanEightK = b -> (b>8000);

        for (Employee employee : employeeArrayList) {
            int bonus = bonusCalulation.apply(employee);
            if (bonusGreatorThanEightK.test(bonus)) {
                System.out.println(employee.name + ": " + employee.salary);
                System.out.println("Bonus: " + bonus);
            }
        }

    }
}

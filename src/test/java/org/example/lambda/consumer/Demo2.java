package org.example.lambda.consumer;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Demo2 {

    public static void main(String[] args) {
        Employee employee1 = new Employee("Candi", 75000, "female");
        Employee employee2 = new Employee("Matt", 70000, "male");
        Employee employee3 = new Employee("Jim", 80000, "male");

        ArrayList<Employee> employeeArrayList = new ArrayList<>();
        employeeArrayList.add(employee1);
        employeeArrayList.add(employee2);
        employeeArrayList.add(employee3);

        Function<Employee, Integer> bonusCalulator = emp -> emp.salary * 10/100;
        Predicate<Integer> bonusGreatorThanFiveK = b -> b > 7500;
        Consumer<Employee> printEmployeeDetail = emp -> System.out.println(emp) ;

        for (Employee e : employeeArrayList) {
            int bonus = bonusCalulator.apply(e);
            System.out.println(e.name + " bonus: " + bonus);
            if (bonusGreatorThanFiveK.test(bonus)) {
                printEmployeeDetail.accept(e);
            }
        }




    }
}

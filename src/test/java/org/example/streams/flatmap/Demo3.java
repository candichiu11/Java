package org.example.streams.flatmap;

import org.example.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo3 {

    public static void main(String[] args) {

        List<Student> studentList1 = new ArrayList<>();
        studentList1.add(new Student("Candi", 1111, 'A'));
        studentList1.add(new Student("Lilun", 1112, 'B'));
        studentList1.add(new Student("Chiu", 1113, 'C'));

        List<Student> studentList2 = new ArrayList<>();
        studentList1.add(new Student("Scott", 1114, 'B'));
        studentList1.add(new Student("London", 1115, 'A'));
        studentList1.add(new Student("Chiu", 1116, 'A'));

        List<List<Student>> studentList = Arrays.asList(studentList1, studentList2);

        // before Java8 without streams
      /*  for (List<Student> list : studentList) {
            for (Student student : list) {
                System.out.println(student.name);
            }
        } */

        // Using streams - flatMap()
        List<String> namesList = studentList.stream()
                .flatMap(stuList -> stuList.stream())
                .map(student -> student.name)
                .collect(Collectors.toList());

        System.out.println(namesList);

    }
}

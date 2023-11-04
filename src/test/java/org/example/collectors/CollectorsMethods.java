package org.example.collectors;

import org.example.Student;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class CollectorsMethods {

    public static void main(String[] args) {

        // toSet()
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5, 4, 3, 2, 1);
        Set<Integer> set = numbers.stream().collect(Collectors.toSet());
        // System.out.println(set);

        // toMap()
        Student student1 = new Student("Candi", 1, 'A');
        Student student2 = new Student("Chiu", 2, 'B');
        Student student3 = new Student("Java", 3, 'A');
        List<Student> studentList = Arrays.asList(student1, student2, student3);

        Map<Integer, String> map = studentList.stream().collect(Collectors.toMap(Student::getId, Student::getName));
        System.out.println(map);

        // toConcurrentMap()
        List<String> list = Arrays.asList("Java", "is", "awesome");
        ConcurrentMap<Character, String> concurrentMap = list.stream().collect(Collectors.toConcurrentMap(value -> value.charAt(0), String::toUpperCase));
        System.out.println("concurrentMap: " + concurrentMap);

        // toCollection()
        List<String> list2 = Arrays.asList("Java", "is", "awesome");
        LinkedList<String> linkedList = list2.stream().collect(Collectors.toCollection(() -> new LinkedList<>()));
        System.out.println("linkedList: " + linkedList);
    }
}

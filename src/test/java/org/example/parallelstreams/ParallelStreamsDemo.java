package org.example.parallelstreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Student {
    String name;
    int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}

public class ParallelStreamsDemo {

    public static void main(String[] args) {
        List<Student> studentList = Arrays.asList(
                new Student("Candi", 100),
                new Student("Lilun", 99),
                new Student("Kitty", 70),
                new Student("Jim", 85),
                new Student("Camunda", 91)
        );

        // using stream - sequential
      /*  studentList.stream()
                .filter(student -> student.getScore() >= 80)
                .limit(4)
                .forEach(s -> System.out.println(s.getName() + " " + s.getScore())); */

        // parallel stream
     /*   studentList.parallelStream()
                .filter(student -> student.getScore() >= 80)
                .limit(4)
                .forEach(s -> System.out.println(s.getName() + " " + s.getScore())); */

        // convert stream() -> parallel stream
        // parallel
        studentList.stream().parallel()
                .filter(student -> student.getScore() >= 80)
                .limit(4)
                .forEach(s -> System.out.println(s.getName() + " " + s.getScore()));
    }
}

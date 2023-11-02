package org.example.streams.filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterDemo2 {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Candi", "Lilun", "Java", "Spring Boot", "Backend");
        List<String> longNames = new ArrayList<>();

//        longNames = names.stream().filter(s -> s.length()>6 && s.length()<9).collect(Collectors.toList());
//        System.out.println(longNames);

        names.stream().filter(s -> s.length()>6 && s.length()<9).forEach(System.out::println);
    }
}

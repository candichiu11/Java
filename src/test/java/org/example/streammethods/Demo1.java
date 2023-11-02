package org.example.streammethods;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// non-terminal/processing methods
// distinct(), limit()

// terminal methods
// count(), forEach()
public class Demo1 {

    public static void main(String[] args) {

        // distinct()
        List<String> vehicles = Arrays.asList("train", "tube", "car", "car", "underground", "bicycle");
//          List<String> distinctResult = vehicles.stream().distinct().collect(Collectors.toList());
//          System.out.println(distinctResult);

        vehicles.stream().distinct().forEach(System.out::println);

        // count()
        long count = vehicles.stream().distinct().count();
        System.out.println(count);

        // limit()
        vehicles.stream().limit(3).forEach(System.out::println);

    }
}

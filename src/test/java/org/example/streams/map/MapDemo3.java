package org.example.streams.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapDemo3 {

    public static void main(String[] args) {
        List<Integer> numberList = Arrays.asList(5, 15, 20, 25, 30, 35);
        List<Integer> multipliedList = new ArrayList<>();

        // without streams
       /* for (int n : numberList) {
            multipliedList.add(n * 3);
        } */

        // Using streams-map
      //  multipliedList = numberList.stream().map(number -> number * 3).collect(Collectors.toList());
       // System.out.println(multipliedList);

        // or
        numberList.stream().map(number -> number * 3).forEach(System.out::println);

    }
}

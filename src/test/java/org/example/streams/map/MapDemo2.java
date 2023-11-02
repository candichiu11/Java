package org.example.streams.map;

import java.util.Arrays;
import java.util.List;

public class MapDemo2 {

    public static void main(String[] args) {
        List<String> vehicles = Arrays.asList("flight", "car", "bike", "train", "tube", "bus");

        // before java8 without using streams
       /* for (String v : vehicles) {
            System.out.println(v.length());
        } */

        // use streams
        vehicles.stream().map(v -> v.length()).forEach( System.out::println);
    }
}

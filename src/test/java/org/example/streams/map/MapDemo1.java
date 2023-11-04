package org.example.streams.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapDemo1 {

    public static void main(String[] args) {
        List<String> vehicles = Arrays.asList("flight", "car", "bike", "train", "tube", "bus");
        List<String> vehiclesUpperCase = new ArrayList<>();

        // before java8, without stream
      /*  for (String v : vehicles) {
            vehiclesUpperCase.add(v.toUpperCase());
        } */

        // stream
        vehiclesUpperCase = vehicles.stream().map((vehicleLower) ->
                        vehicleLower.toUpperCase())
                .collect(Collectors.toList());


        System.out.println(vehiclesUpperCase);

    }
}

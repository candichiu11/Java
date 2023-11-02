package org.example.streammethods2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo4 {

    public static void main(String[] args) {
        List<String> animalsList = Arrays.asList("Dog", "Cat", "Dragon");
        List<String> birdsList = Arrays.asList("Crow", "Parrot", "Peacock");

        Stream<String> animalsStream = animalsList.stream();
        Stream<String> birdsStream = birdsList.stream();

        List<String> result = Stream.concat(animalsStream, birdsStream).collect(Collectors.toList());
        System.out.println(result);
    }
}

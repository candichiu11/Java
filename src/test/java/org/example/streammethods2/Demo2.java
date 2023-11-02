package org.example.streammethods2;

import java.util.HashSet;
import java.util.Set;

// anyMatch()
// allMatch()
// noneMatch()
public class Demo2 {

    public static void main(String[] args) {
        Set<String> fruits = new HashSet<>();

        fruits.add("Two apples");
        fruits.add("Ten mangos");
        fruits.add("Two peaches");
        fruits.add("One banana");
        fruits.add("Three oranges");

        // anyMatch()
        Boolean result = fruits.stream().anyMatch(fruit -> {
            return fruit.startsWith("Two");
        });
        System.out.println(result); // true

        // allMatch()
        result = fruits.stream().allMatch(fruit -> {
            return fruit.startsWith("Two");
        });
        System.out.println(result); // false

        // noneMatch()
        result = fruits.stream().noneMatch(fruit -> {
            return fruit.startsWith("Five");
        });
        System.out.println(result); // true
    }
}

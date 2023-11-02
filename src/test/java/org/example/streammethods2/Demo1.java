package org.example.streammethods2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// sorted()
public class Demo1 {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 3, 6, 7, 7, 1, 2, 0);
        List<Integer> sortedAsc = numbers.stream().sorted().collect(Collectors.toList());
        //   System.out.println("ascending order: " + sortedAsc); // ascending order

        List<Integer> sortedDsc = numbers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        //   System.out.println("descending order: " + sortedDsc);

        // strings
        List<String> stringList = Arrays.asList("Candi", "John", "Chiu", "London");
        List<String> sorted = stringList.stream().sorted().collect(Collectors.toList());
        List<String> reversedSorted = stringList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(reversedSorted);
    }
}

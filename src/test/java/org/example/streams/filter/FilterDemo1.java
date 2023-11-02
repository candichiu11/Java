package org.example.streams.filter;

// Collection: to represent group of data/objects as single entity
// Stream: to process data from collection we use streams concepts

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterDemo1 {

    public static void main(String[] args) {
    /*     List<Integer> arr = new ArrayList<>();

        arr.add(10);
        arr.add(15);
        arr.add(20);
        arr.add(25);
        arr.add(30); */

        List<Integer> numberList = Arrays.asList(10, 15, 20, 25, 30);
        List<Integer> evenNumberList = new ArrayList<>();

        // without streams, scan numberList array and print even number
      /*  for (int number : numberList) {
            if (number % 2 == 0) evenNumberList.add(number);
        }

        System.out.println(evenNumberList); */

        // with Streams
     /*  evenNumberList = numberList.stream().filter(n -> n%2==0).collect(Collectors.toList());
        System.out.println(evenNumberList); */
                                   // predicate          // consumer
     //   numberList.stream().filter(n -> n%2==0).forEach(n -> System.out.println(n));
        numberList.stream().filter(n -> n%2==0).forEach(System.out::println);

    }

}

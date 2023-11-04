package org.example.collectors;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorMethods2 {

    public static void main(String[] args) {

        // counting()
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        long count = list.stream().collect(Collectors.counting());
        System.out.println("count: " + count);

        // groupingBy()
        List<Integer> list2 = List.of(1, 2, 3, 4, 5, 1, 2, 3);
        Map<Integer, Long> map = list2.stream().collect(Collectors.groupingBy(value -> value, Collectors.counting()));
        System.out.println("map: " + map);

        // summarizingInt()
        List<Integer> list3 = List.of(1, 2, 3, 4, 5);
        IntSummaryStatistics data = list3.stream().collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println("data: " + data);

        // averaging
        List<Integer> list4 = List.of(1, 2, 3, 4, 5);
        Double avg = list4.stream().collect(Collectors.averagingInt(e -> e));
        System.out.println("average: " + avg);

        // minBy
        List<Integer> list5 = List.of(1, 2, 3, 4, 5, -9);
        Optional<Integer> min = list5.stream().collect(Collectors.minBy(Integer::compareTo));
        System.out.println("min: " + min.get());

        // maxBy
        Optional<Integer> max = list5.stream().collect(Collectors.maxBy(Integer::compareTo));
        System.out.println("max: " + max.get());

        // partitioningBy
        List<Integer> list6 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<Boolean, List<Integer>> partition = list6.stream().collect(Collectors.partitioningBy(value -> value > 5));
        System.out.println(partition);

        // joining
        List<Character> list7 = Arrays.asList('j', 'a', 'v', 'a');
        String join = list7.stream().map(c -> c.toString()).collect(Collectors.joining());
        System.out.println("join: " + join);
    }
}

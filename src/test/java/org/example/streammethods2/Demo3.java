package org.example.streammethods2;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

// findAny()
// findFirst()
public class Demo3 {

    public static void main(String[] args) {
        // findAny()
        // List<String> stringList = Arrays.asList("one", "two", "three", "one");
        List<String> stringList = Arrays.asList();
        Optional<String> ele = stringList.stream().findAny();
        System.out.println(ele);

        // findFirst()
        Optional<String> ele2 = stringList.stream().findFirst();
        System.out.println(ele2.get()); // NoSuchElementException because of empty list
    }
}

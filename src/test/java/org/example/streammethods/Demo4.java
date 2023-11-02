package org.example.streammethods;

import java.util.Arrays;
import java.util.List;

public class Demo4 {

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("A", "B", "C", "1", "2", "3");
        Object[] arr = stringList.stream().toArray();
        System.out.println("Length: " + arr.length);

        for (Object o : arr) {
            System.out.println(o);
        }
    }
}

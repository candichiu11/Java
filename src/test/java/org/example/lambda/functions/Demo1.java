package org.example.lambda.functions;

import java.util.function.Function;

public class Demo1 {
    public static void main(String[] args) {
             // <parameter, return type>
        Function<Integer, Integer> f = n -> n*n;
//        System.out.println(f.apply(5));
//        System.out.println(f.apply(15));
//        System.out.println(f.apply(2));

        // String length
        Function<String, Integer> getStringLen = s -> s.length();
        System.out.println(getStringLen.apply("Candi"));
        System.out.println(getStringLen.apply("London"));
        System.out.println(getStringLen.apply("Kensinton"));

    }
}

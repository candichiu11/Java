package org.example.lambda.predicate;

/*
Definition of predicate

interface Predicate<T> {
public Boolean test(T t) ;
}

 */
// Predicate...one parameter..return Boolean
// use only if you have conditional check in your program

import java.util.function.Predicate;

public class Demo1 {

    public static void main(String[] args) {

        // example 1
        Predicate<Integer> p = i -> (i > 10);
       // System.out.println(p.test(11));
      //  System.out.println(p.test(5));

        // example 2: check the length of given string is greater than 4 or not
        Predicate<String> checkLen = s -> (s.length() > 4);
      //  System.out.println("The length of Candi is greater than 4: " + checkLen.test("Candi"));

        // example 3: Print array elements whose size is greater than 4
        String[] names = {"Candi", "Lilun", "Chiu", "Camunda", "Java", "Spring Boot"};

        for (String name : names) {
            if (checkLen.test(name)) {
                System.out.println(name);
            }
        }
    }
}

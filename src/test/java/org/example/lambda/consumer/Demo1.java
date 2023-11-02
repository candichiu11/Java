package org.example.lambda.consumer;

import java.util.function.Consumer;

public class Demo1 {

    public static void main(String[] args) {
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("Hello World");
    }
}

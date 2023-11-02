package org.example.streams.filter;

import org.example.streams.Product;

import java.util.ArrayList;
import java.util.List;

public class FilterDemo4 {

    public static void main(String[] args) {
        List<Product> productsList = new ArrayList<>();
        productsList.add(new Product("MacBook Pro", 1, 2000));
        productsList.add(new Product("Airpods Pro", 2, 300));
        productsList.add(new Product("Airpods Max", 3, 670));
        productsList.add(new Product("iphone XR", 4, 500));
        productsList.add(new Product("iphone 14 Pro", 5, 1700));

        productsList.stream().filter(p -> p.price > 500) // filtering
                .forEach(p -> System.out.println(p.price)); // iterating
    }
}

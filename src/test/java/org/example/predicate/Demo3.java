package org.example.predicate;

import java.util.function.Predicate;

public class Demo3 {

   // Joining Predicate - and, or, negate
   // p1 -- checks number is even
   // p2 -- checks number is greater than 50
    public static void main(String[] args) {
        int[] nums = {5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60};

        Predicate<Integer> checkNumberEven = i -> (i % 2 == 0);
        Predicate<Integer> checkNumberGreaterThanFifty = i -> (i > 50);

        for (int num : nums) {

           // if (checkNumberEven.and(checkNumberGreaterThanFifty).test(num))  // if (checkNumberEven.test(num) && checkNumberGreaterThanFifty.test(num))
           //   if (checkNumberEven.or(checkNumberGreaterThanFifty).test(num))
             if (checkNumberEven.negate().and(checkNumberGreaterThanFifty).test(num))   {
                System.out.println(num);
            }
        }

    }
}

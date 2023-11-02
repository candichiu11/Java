package org.example.lambda.supplier;

import java.util.Date;
import java.util.function.Supplier;

/*          invoke Lambda
Predicate<T> test()
Function<T, R> apply()
Consumer<T>  accept()
Supplier<R> get()
supplier won't take any input but will return a value

 */

public class Demo1 {

    public static void main(String[] args) {
        Supplier<Date> supplier = () -> new Date();
        System.out.println(supplier.get());
    }
}

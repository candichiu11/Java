/*
package org.example;

@FunctionalInterface
interface Taxi {
    public void taxiStatus();
}



public class LambdaDemo {

    public static void main(String[] args) {
         Taxi theTaxi = () -> System.out.println("Your taxi is booked");
         theTaxi.taxiStatus();
    }
}

 */

package org.example;

@FunctionalInterface
interface Cab {
    public String bookCab(String source, String destination);
}

public class LambdaDemo {

    public static void main(String[] args) {
        Cab cab = (source, destination) -> {
            System.out.println("Cab is booked from " + source + " to " + destination);
            return "price: 50 Euros";
        };
        System.out.println(cab.bookCab("Munich North", "MUC airport"));
    }
}




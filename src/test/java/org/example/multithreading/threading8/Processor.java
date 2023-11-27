package org.example.multithreading.threading8;

import java.util.Scanner;

public class Processor {
    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("Producer thread running...");
            wait(); // wait will release lock
            System.out.println("Resumed.");
        }
    }

    public void consume() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        Thread.sleep(2000);

        synchronized (this) {
            System.out.println("Waiting for return key.");
            scanner.nextLine();
            System.out.println("Return key pressed.");
            notify(); // notify won't release lock
            Thread.sleep(5000);
        }
    }

}

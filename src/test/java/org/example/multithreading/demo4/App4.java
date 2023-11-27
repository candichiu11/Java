package org.example.multithreading.demo4;


import java.util.Scanner;

class Process extends Thread {
    // volatile keyboard prevents variable caching
    private volatile boolean running = true;
    @Override
    public void run() {
        while (running) {
            System.out.println("Hello");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void shutDown() {
        running = false;
    }
}

public class App4 {

    public static void main(String[] args) {
        Process process = new Process();
        process.start();

        System.out.println("Press return to stop...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        process.shutDown();

    }
}

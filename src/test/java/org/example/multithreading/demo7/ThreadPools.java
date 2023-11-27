package org.example.multithreading.demo7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable {
    private int id;

    public Processor(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Starting: " + id);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Completed: " + id);
    }
}

public class ThreadPools {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 1; i <= 5; i++) {
            executorService.submit(new Processor(i));
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("All tasks completed.");
    }
}

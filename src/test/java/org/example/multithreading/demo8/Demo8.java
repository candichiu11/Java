package org.example.multithreading.demo8;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Processor implements Runnable {
    private CountDownLatch latch;

    public Processor(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("Started.");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        latch.countDown();
    }
}


public class Demo8 {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 3; i++) {
            executorService.submit(new Processor(latch));
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Completed.");
        executorService.shutdown();
    }
}

package org.example.multithreading.threading7;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App {

    private static BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(10);


    public static void main(String[] args) throws InterruptedException {
         Thread t1 = new Thread(new Runnable() {
             @Override
             public void run() {
                 try {
                     producer();
                 } catch (InterruptedException e) {
                     throw new RuntimeException(e);
                 }
             }
         });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consumer();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

    public static void producer() throws InterruptedException {
        Random random = new Random();

        while (true) {
            blockingQueue.put(random.nextInt(10));
        }
    }

    public static void consumer() throws InterruptedException {
        Random random = new Random();

        while (true) {
            if (random.nextInt(10) == 1) {
                Integer value = blockingQueue.take();
                System.out.println("Value taken: " + value + " : blockingQueue size: " + blockingQueue.size());
            }
        }
    }

}

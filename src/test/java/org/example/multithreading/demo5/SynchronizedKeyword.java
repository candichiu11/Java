package org.example.multithreading.demo5;

public class SynchronizedKeyword {

    private int count = 0;

    // The synchronized keyword locks the resources to a thread so that no other thread can access it at a time
    public synchronized void increment() {
        count++;
    }

    public static void main(String[] args) {
        SynchronizedKeyword process = new SynchronizedKeyword();
        process.doWork();
    }

    public void doWork() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            // this will wait thread to finish then return
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("count: " + count);

    }
}

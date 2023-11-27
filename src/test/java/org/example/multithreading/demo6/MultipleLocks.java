package org.example.multithreading.demo6;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class MultipleLocks {

    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    Random random = new Random();

    public void stage1() {

        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            list1.add(random.nextInt(100));
        }
    }

    public void stage2() {
        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            list2.add(random.nextInt(100));
        }
    }

    public void process() {
        for (int i = 0; i < 1000; i++) {
            stage1();
            stage2();
        }
    }

    public void main() {
        System.out.println("Starting...");
        long start = System.currentTimeMillis();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                process();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                process();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long end = System.currentTimeMillis();

        System.out.println("Time taken: " + (end - start));
        System.out.println("List1 size: " + list1.size());
     //   System.out.println("List1: " + list1);
        System.out.println("List2 size: " + list2.size());
     //   System.out.println("List2: " + list2);
    }
}

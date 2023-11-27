package org.example.multithreading.threading10;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

    private int count = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private void increament() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }
    public void firstThread() throws InterruptedException {
        lock.lock();
        System.out.println("Waiting...");

        condition.await();

        System.out.println("Woken up!");

        try {
            increament();
        } finally {
            lock.unlock();
        }
    }

    public void secondThread() throws InterruptedException {
        Thread.sleep(1000);
        lock.lock();
        System.out.println("Please press return key.");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        System.out.println("Got the return key.");

        condition.signal();

        try {
            increament();
        } finally {
            lock.unlock();
        }
    }

    public void finished() {
        System.out.println("Count is: " + count);
    }
}

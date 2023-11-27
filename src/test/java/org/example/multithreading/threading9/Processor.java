package org.example.multithreading.threading9;

import java.util.LinkedList;

public class Processor {

    private LinkedList<Integer> list = new LinkedList<>();
    private final int LIMIT = 3;
    private Object lock = new Object();

    public void produce() throws InterruptedException{
        int value = 0;
        int count = 0;

        while (count++ < 10) {
            synchronized (lock) {
                while (list.size() == LIMIT) {
                    lock.wait();
                }

                list.add(value++);
                lock.notify();
            }
        }
    }


    public void consume() throws InterruptedException{
        int count = 0;

        while (count++ < 10) {
            synchronized (lock) {
                while (list.size() == 0) {
                    lock.wait();
                }

                System.out.print("List size: " + list.size());
                int value = list.removeFirst();
                System.out.println(", value is: " + value);
                lock.notify();
            }
        }
    }
}

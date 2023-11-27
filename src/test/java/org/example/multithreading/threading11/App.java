package org.example.multithreading.threading11;

public class App {

    public static void main(String[] args) {
            Runner runner = new Runner();

            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        runner.firstThread();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });

            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        runner.secondThread();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
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

        runner.finished();

    }
}

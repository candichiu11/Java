package org.example.multithreading.threading12;

import java.util.concurrent.Semaphore;

public class Connection {
    private static Connection instance = new Connection();
    private int connections = 0;

    private Semaphore semaphore = new Semaphore(10, true);
    private Connection() {

    }

    public static Connection getInstance() {
        return instance;
    }

    public void connect() throws InterruptedException {
        semaphore.acquire();
        try {
            doConnect();
        } finally {
            semaphore.release();
        }
    }

    public void doConnect() throws InterruptedException {

        synchronized (this) {
            connections++;
            System.out.println("Current connection: " + connections);
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        synchronized (this) {
            connections--;
        }
    }

}

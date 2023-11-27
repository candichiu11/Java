package org.example.multithreading.threading14;

import java.util.Random;
import java.util.concurrent.*;

public class App {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Starting...");
        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<?> future = executorService.submit(new Callable<Void>() {

            @Override
            public Void call() throws Exception {
                Random random = new Random();

                for (int i = 0; i < 1E8; i++) {

                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Interrupted");
                        break;
                    }

                    Math.sin(random.nextDouble());
                }
                return null;
            }
        });

        executorService.shutdown();

        Thread.sleep(500);

        executorService.shutdownNow();
       // future.cancel(true);

        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Finished.");
    }
}

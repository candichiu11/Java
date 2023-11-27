package org.example.multithreading.threading13;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.*;

public class App {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<?> future = executorService.submit(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                Random random = new Random();
                int duration = random.nextInt(4000);

                if (duration > 2000) {
                    throw new IOException("Sleep for too long");
                }

                System.out.println("Starting...");
                Thread.sleep(duration);
                System.out.println("Finished.");

                return null;
            }
        });

        executorService.shutdown();

        try {
            System.out.println("Result is: " + future.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            System.out.println(e.getMessage());
        }
    }
}

package com.javarush.island.babkin.servises;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static com.javarush.island.babkin.servises.ViewAnimal.doViewAnimal;

public class Runner {

    private Runner(){}

    public static void run() {

        GenerationOrganizm.getGenerationOrganizm();

        List<Runnable> task = List.of(
                () -> MoveAnimal.doMovingAnimals(),
                () -> EatAnimal.doEatAnimal(),
                () -> ReproduceAnimal.doReproduceAnimal(),
                () -> doViewAnimal(5, 5)
        );

        ExecutorService executor = Executors.newFixedThreadPool(4);

        boolean variant = true;
        while (variant) {

            for (Runnable runnable : task) {
                executor.submit(runnable);
            }
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("The map is empty! We are closing.");

        executor.shutdown();
        try {
            executor.awaitTermination(1000, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (!executor.isTerminated()) {
            System.err.println("\n" +
                    "Some tasks were not completed!");
            executor.shutdownNow();
        }
    }

}

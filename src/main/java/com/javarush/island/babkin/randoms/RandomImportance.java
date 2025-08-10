package com.javarush.island.babkin.randoms;


import java.util.concurrent.ThreadLocalRandom;

public class RandomImportance extends Thread {
    int randomEat;
    int bound;

    public RandomImportance(int randomEat) {
        bound = 100 - randomEat;
    }

    public static int getRandom(int value) {
        return ThreadLocalRandom.current().nextInt(value);
    }

    public static double getRandom(double value) {
        return ThreadLocalRandom.current().nextDouble(value);
    }



    public void setRandomEat() {
        try {
            int result = ThreadLocalRandom.current().nextInt(100);
            System.out.println("Вероятность быть съеденным - " + randomEat + "Thread " + Thread.currentThread().threadId() + " generated " + result);

            Thread.yield();

            if (result > bound) {
                System.out.println("Съели столько - " + result);
            } else {
                System.out.println("Не cъели - " + result);
            }
        } catch (Exception e) {
            System.out.println("Exception RandomeImportance");
        }
    }
    public static int getRandomQuantity(int maxSizeAnimalCell) {
        return ThreadLocalRandom.current().nextInt(maxSizeAnimalCell);
    }

}

package com.javarush.island.babkin.randoms;


import java.util.concurrent.ThreadLocalRandom;

public class RandomImportance extends Thread {

    int bound;
    private static final int PERCENT = 100;

    public RandomImportance(int randomEat) {
        bound = 100 - randomEat;
    }

    public static int getRandom(int value) {
        return ThreadLocalRandom.current().nextInt(value);
    }

    public static double getRandom(double value) {
        return ThreadLocalRandom.current().nextDouble(value);
    }

    public static int getRandomEat() {
        return ThreadLocalRandom.current().nextInt(PERCENT);
    }
    public static int getRandomQuantity(int maxSizeAnimalCell) {
        return ThreadLocalRandom.current().nextInt(maxSizeAnimalCell);
    }

}

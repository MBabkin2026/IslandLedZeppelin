package com.javarush.island.babkin.randoms;


import java.util.concurrent.ThreadLocalRandom;

public class RandomeImportance extends Thread {
    int randomEat;
    int bound;

    public RandomeImportance(int randomEat) {
        bound = 100 - randomEat;
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
}

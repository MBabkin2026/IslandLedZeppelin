package com.javarush.island.babkin.servises;

import com.javarush.island.babkin.map.MapGame;
import com.javarush.island.babkin.organisms.animals.Animal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;

public class ReproduceAnimal {
    private static final Lock mapGameLock = MapGameLock.getMapGameLock();

    private static final double PERCENTAGE = 0.30;

    public static void doReproduceAnimal() {
        mapGameLock.lock();
        try {
            Set<ExampleClass>[][] mapGame = MapGame.getMapGame();
            for (int i = 0; i < mapGame.length; i++) {
                for (int j = 0; j < mapGame[i].length; j++) {
                    Set<ExampleClass> currentSet = mapGame[i][j];

                    currentSet = mergeDuplicates(currentSet);

                    for (ExampleClass animal : currentSet) {
                        var maxSizeAnimalCell = animal.getMaxSizeAnimalCell();
                        var countAnimal = animal.getCountAnimal();
                        double percentage = PERCENTAGE;
                        if (countAnimal < maxSizeAnimalCell) {
                            int increasedNumber = (int) (maxSizeAnimalCell * (1 + percentage));
                            animal.addValue(increasedNumber);
                        }
                    }
                }
            }
        } finally {
            mapGameLock.unlock();
        }
    }

    private static Set<ExampleClass> mergeDuplicates(Set<ExampleClass> set) {
        Map<String, ExampleClass> mergedMap = new HashMap<>();

        for (ExampleClass animal : set) {
            var nameClass = animal.getClass().getSimpleName();
            var i1 = Animal.animalsClass.indexOf(nameClass);
            if (mergedMap.containsKey(nameClass)) {
                mergedMap.get(nameClass).merge(animal);
            } else {
                mergedMap.put(nameClass, animal);
            }
        }
        return new HashSet<>(mergedMap.values());
    }
}

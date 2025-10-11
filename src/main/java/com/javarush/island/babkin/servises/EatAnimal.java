package com.javarush.island.babkin.servises;

import com.javarush.island.babkin.map.MapGame;
import com.javarush.island.babkin.organisms.animals.Animal;
import com.javarush.island.babkin.randoms.RandomImportance;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class EatAnimal {
    private static final Lock mapGameLock = MapGameLock.getMapGameLock();

    public static void doEatAnimal() {
        mapGameLock.lock();
        try {
            Set<ExampleClass>[][] mapGame = MapGame.getMapGame();
            for (int i = 0; i < mapGame.length; i++) {
                for (int j = 0; j < mapGame[i].length; j++) {
                    Set<ExampleClass> currentSet = mapGame[i][j];
                    List<ExampleClass> toProcess = new ArrayList<>(currentSet);

                    for (int index = 0; index < toProcess.size(); index++) {
                        ExampleClass animal1 = toProcess.get(index);

                        for (Iterator<ExampleClass> iterator = currentSet.iterator(); iterator.hasNext(); ) {
                            ExampleClass animal2 = iterator.next();

                            if (animal1 == animal2) {
                                continue;
                            }

                            var nameClass1 = animal1.getClass().getSimpleName();
                            var i1 = Animal.animalsClass.indexOf(nameClass1);

                            var nameClass2 = animal2.getClass().getSimpleName();
                            var i2 = Animal.animalsClass.indexOf(nameClass2);

                            if (i1 == -1 || i2 == -1) {
                                continue;
                            }

                            var mapEat = Animal.probabilityEat;

                            var wiegthEating1 = animal1.getWiegthEating();
                            var packweight2 = animal2.getPackweight();

                            boolean valuesRandom = extracted(mapEat, i1, i2);
                            if (valuesRandom) {
                                var v = packweight2 - wiegthEating1;
                                animal2.setPackweight(v);
                            }

                            var packweightRepeat2 = animal2.getPackweight();
                            if (packweightRepeat2 <= 0) {
                                iterator.remove();
                            }
                        }
                    }
                }
            }
        } finally {
            mapGameLock.unlock();
        }
    }

    private static boolean extracted(int[][] mapEat, int i1, int i2) {
        if (i1 >= 0 && i1 < mapEat.length && i2 >= 0 && i2 < mapEat[i1].length) {
            int value1 = mapEat[i1][i2];
            int randomValue = RandomImportance.getRandomEat();
            return value1 > randomValue;
        } else {
            return false;
        }
    }


}

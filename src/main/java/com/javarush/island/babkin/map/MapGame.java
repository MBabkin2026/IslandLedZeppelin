package com.javarush.island.babkin.map;

import com.javarush.island.babkin.servises.ExampleClass;

import java.util.HashSet;
import java.util.Set;

public class MapGame {

    private static Set<ExampleClass>[][] mapGame = new HashSet[3][3];

    static {
        for (int i = 0; i < mapGame.length; i++) {
            for (int j = 0; j < mapGame[i].length; j++) {
                mapGame[i][j] = new HashSet<>();
            }
        }
    }

    public static Set<ExampleClass>[][] getMapGame() {
        return mapGame;
    }
}

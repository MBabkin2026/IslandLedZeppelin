package com.javarush.island.babkin.map;

import com.javarush.island.babkin.servises.ExampleClass;

import java.util.HashSet;
import java.util.Set;

public class MapGame {

    private static final int COUNTROWS = 3;
    private static final int COUNTCOLUMNS = 3;

    private static Set<ExampleClass>[][] mapGame = new HashSet[COUNTROWS][COUNTCOLUMNS];

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

    public static int getCOUNTROWS() {
        return COUNTROWS;
    }

    public static int getCOUNTCOLUMNS() {
        return COUNTCOLUMNS;
    }
}

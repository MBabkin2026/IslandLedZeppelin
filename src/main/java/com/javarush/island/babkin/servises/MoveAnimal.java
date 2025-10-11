package com.javarush.island.babkin.servises;

import com.javarush.island.babkin.map.MapGame;
import com.javarush.island.babkin.randoms.RandomImportance;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

public class MoveAnimal {

    private static final ReentrantLock lock = new ReentrantLock();

    private static int countrows = MapGame.getCOUNTROWS();
    private static int countcolumns = MapGame.getCOUNTCOLUMNS();

    public static int[][] maketMapIndex = new int[countrows][countcolumns];

    private MoveAnimal(){}

    public static void doMovingAnimals() {
        var mapGame = MapGame.getMapGame();
        for (int i = 0; i < mapGame.length; i++) {
            for (int j = 0; j < mapGame[i].length; j++) {
                Set<ExampleClass> currentSet = mapGame[i][j];
                HashSet<ExampleClass> toProcess = new HashSet<>(currentSet);
                for (ExampleClass animal : toProcess) {
                    int maxSpeedCell = animal.getMaxSpeedCell();
                    int[] coords = findObjectCoordinates(animal, mapGame);
                    if (coords != null) {
                        int currentRow = coords[0];
                        int currentCol = coords[1];

                        setIndex(currentRow, currentCol);
                        countStep(maxSpeedCell);
                        int targetIndexRow = findRowIndex();
                        int targetIndexColumn = findColumnIndex(targetIndexRow);


                        int targetRow = targetIndexRow;
                        int targetCol = targetIndexColumn;


                        if (currentRow >= 0 && currentCol >= 0 && targetRow >= 0 && targetCol >= 0 &&
                                currentRow < mapGame.length && currentCol < mapGame[0].length &&
                                targetRow < mapGame.length && targetCol < mapGame[0].length) {

                            Set<ExampleClass> sourceSet = mapGame[currentRow][currentCol];
                            Set<ExampleClass> targetSet = mapGame[targetRow][targetCol];

                            if (sourceSet.contains(animal)) {
                                sourceSet.remove(animal);
                                targetSet.add(animal);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void setIndex(int cellindexRow, int cellColumn) {
        int indexRow = cellindexRow;
        int indexColumn = cellColumn;

        maketMapIndex[indexRow][indexColumn] = 1;
    }

    public static void countStep(int maxSpeedCell){

        for(int i = 0; i < maketMapIndex.length; i++) {
            for(int j = 0; j < maketMapIndex[i].length; j++) {
                if (maketMapIndex[i][j] == 1) {
                    for(int step = 0; step < maxSpeedCell; step++){
                        isMove(i,j);
                    }
                }
            }
        }
    }



    public static void isMove(int row, int column) {


        lock.lock();
        try {
            int value = RandomImportance.getRandom(4);
            int maxRow = maketMapIndex.length - 1;
            int maxCol = maketMapIndex[0].length - 1;

            if (value == 0 && row > 0) { // вверх
                maketMapIndex[row - 1][column] = maketMapIndex[row][column];
                maketMapIndex[row][column] = 0;
            } else if (value == 1 && row < maxRow) { // вниз
                maketMapIndex[row + 1][column] = maketMapIndex[row][column];
                maketMapIndex[row][column] = 0;
            } else if (value == 2 && column > 0) { // влево
                maketMapIndex[row][column - 1] = maketMapIndex[row][column];
                maketMapIndex[row][column] = 0;
            } else if (value == 3 && column < maxCol) { // вправо
                maketMapIndex[row][column + 1] = maketMapIndex[row][column];
                maketMapIndex[row][column] = 0;
            }
        } finally {
            lock.unlock();
        }
    }

    public static int findRowIndex() {
        for (int i = 0; i < maketMapIndex.length; i++) {
            for (int j = 0; j < maketMapIndex[i].length; j++) {
                if (maketMapIndex[i][j] == 1) {
                    return i; //
                }
            }
        }
        return 0;
    }

    public static int findColumnIndex(int rowIndex) {
        if (rowIndex < 0 || rowIndex >= maketMapIndex.length) {
            return -1;
        }
        for (int j = 0; j < maketMapIndex[rowIndex].length; j++) {
            if (maketMapIndex[rowIndex][j] == 1) {
                return j;
            }
        }
        return 0;
    }

    public static int[] findObjectCoordinates(ExampleClass target, Set<ExampleClass>[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j].contains(target)) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

}

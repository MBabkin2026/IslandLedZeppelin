package com.javarush.island.babkin.servises;

import com.javarush.island.babkin.map.MapGame;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.javarush.island.babkin.map.MapGame.*;


public class ViewAnimal {

    private static final Lock mapGameLock = MapGameLock.getMapGameLock();
    private static final int LIMIT = 5;

    private static final StringBuilder SB_UP = new StringBuilder();
    private static final StringBuilder SB_CENTER = new StringBuilder();
    private static final StringBuilder SB_DOWN = new StringBuilder();
    private static final String SIMBOL_WHITE_SPASE = " ".repeat(10);


    private static final String SIMBOL_UP = SB_UP.append("╦").append(SIMBOL_WHITE_SPASE).toString();
    private static final String SIMBOL_UP_LEFT = "╔";
    private static final String SIMBOL_UP_RIGHT = "╗";


    private static final String SIMBOL_CENTER = SB_CENTER.append("╬").append(SIMBOL_WHITE_SPASE).toString();
    private static final String SIMBOL_LEFT = "╠";
    private static final String SIMBOL_RIGHT = "╣";


    private static final String SIMBOL_DOWN = SB_DOWN.append("╩").append(SIMBOL_WHITE_SPASE).toString();
    private static final String SIMBOL_DOWN_LEFT = "╚";
    private static final String SIMBOL_DOWN_RIGHT = "╝";

    private ViewAnimal(){}


    public static void doViewAnimal(int viewRow, int viewColumn) {
        mapGameLock.lock();
        try {
            Set<ExampleClass>[][] mapGame = getMapGame();
            int row = viewRow;
            int column = viewColumn;
            int limitAnimalviewInCell = 5;
            String noAnimalSymbol = "  ";

            for (int i = 0; i < row; i++) {
                System.out.println(i == 0
                        ? getUpBorder(row, limitAnimalviewInCell)
                        : getCenterBorder(row, limitAnimalviewInCell));
                System.out.print("║");

                for (int j = 0; j < column; j++) {
                    Set<ExampleClass> exampl = mapGame[i][j];
                    StringBuilder cellContent = new StringBuilder();

                    long limit = limitAnimalviewInCell;
                    int animalCount = 0;

                    for (ExampleClass animal : exampl) {
                        if (limit-- == 0) break;
                        if (animal.getMaxSizeAnimalCell() > 0 && animal.getCountAnimal() >= 0) {
                            double percentageOfMax = (double) animal.getCountAnimal() / animal.getMaxSizeAnimalCell() * 100.0;
                            cellContent.append(Color.getPercentAnimal(percentageOfMax))
                                    .append(animal.getShortName())
                                    .append(Color.RESET);
                            animalCount++;
                        }
                    }

                    int symbolsToAdd = limitAnimalviewInCell - animalCount;
                    if (animalCount == 0) {
                        cellContent.append(noAnimalSymbol.repeat(limitAnimalviewInCell));
                    } else {
                        cellContent.append(noAnimalSymbol.repeat(Math.max(0, symbolsToAdd)));
                    }

                    System.out.print(cellContent);
                    System.out.print("║");
                }
                System.out.println();
            }
            System.out.println(getDownBorder(row, limitAnimalviewInCell));
            System.out.flush();

            System.out.printf("Scale: %s %s %s %s %s %s %s %s %s %s %n", Color.CYAN + 10, Color.BLUE + 20, Color.GREEN + 30, Color.YELLOW + 40, Color.RED + 50 + Color.RESET,
                    Color.FILL_CYAN + 60, Color.FILL_BLUE + 70, Color.FILL_GREEN + 80, Color.FILL_YELLOW + 90, Color.FILL_RED + 100 + Color.RESET);

            System.out.println(processAndPrintAnimals(mapGame, mapGameLock, LIMIT));

        } finally {
            mapGameLock.unlock();
        }

    }

    public static String processAndPrintAnimals(Set<ExampleClass>[][] mapGame, Lock mapGameLock, int LIMIT){
        StringBuilder result = new StringBuilder();

        mapGameLock.lock();
        try {
            List<ExampleClass> allAnimals = Arrays.stream(mapGame)
                    .flatMap(Arrays::stream)
                    .filter(Objects::nonNull)
                    .flatMap(cell -> {
                        if (cell instanceof Set) {
                            return ((Set<ExampleClass>) cell).stream();
                        } else {
                            return Stream.of((ExampleClass) cell);
                        }
                    })
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());

            allAnimals.sort(Comparator.comparingInt(ExampleClass::getCountAnimal).reversed());

            allAnimals.stream()
                    .filter(animal -> animal.getMaxSizeAnimalCell() > 0 && animal.getCountAnimal() >= 0)
                    .limit(LIMIT) //Ограничение по количеству
                    .forEach(animal -> {
                        double percentageOfMax = (double) animal.getCountAnimal() / animal.getMaxSizeAnimalCell() * 100.0;
                        result.append(String.format("%s %s%s: %d %s, ",
                                animal.getIcons(),
                                Color.getPercentAnimal(percentageOfMax),
                                animal.getShortName(),
                                animal.getCountAnimal(),
                                Color.RESET
                        ));
                    });

            if (result.length() > 0) {
                result.delete(result.length() - 2, result.length());
            }
            return result.toString();

        } finally  {
            mapGameLock.unlock();
        }
    }



    public static StringBuilder getUpBorder(int count, int countSpace) {
        return new StringBuilder().append(SIMBOL_UP_LEFT)
                .append(getSimbolWhiteSpace(countSpace))
                .append(SIMBOL_UP.repeat(count - 1))
                .append(SIMBOL_UP_RIGHT);
    }

    public static StringBuilder getCenterBorder(int count, int countSpace) {
        return new StringBuilder().append(SIMBOL_LEFT)
                .append(getSimbolWhiteSpace(countSpace))
                .append(SIMBOL_CENTER.repeat(count - 1))
                .append(SIMBOL_RIGHT);
    }

    public static StringBuilder getDownBorder(int count, int countSpace) {
        return new StringBuilder().append(SIMBOL_DOWN_LEFT)
                .append(getSimbolWhiteSpace(countSpace))
                .append(SIMBOL_DOWN.repeat(count - 1))
                .append(SIMBOL_DOWN_RIGHT);
    }

    public static String getSimbolWhiteSpace(int countSpace) {
        return " ".repeat(countSpace * 2);
    }

}

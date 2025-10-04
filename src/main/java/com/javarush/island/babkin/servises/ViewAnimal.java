package com.javarush.island.babkin.servises;

import com.javarush.island.babkin.map.MapGame;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static com.javarush.island.babkin.map.MapGame.*;

public class ViewAnimal {

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


    public static void doViewAnimal(int viewRow, int viewColumn) {
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

        Set<ExampleClass> animalsInFirstCell = mapGame[0][0];
        List<ExampleClass> animalList = new ArrayList<>(animalsInFirstCell);
        animalList.sort(Comparator.comparingInt(ExampleClass::getCountAnimal).reversed());

        animalsInFirstCell.stream()
                .sorted(Comparator.comparingInt(ExampleClass::getCountAnimal).reversed())
                .filter(animal -> animal.getMaxSizeAnimalCell() > 0 && animal.getCountAnimal() >= 0)
                .limit(LIMIT)// Фильтруем элементы
                .forEach(animal -> {
                    double percentageOfMax = (double) animal.getCountAnimal() / animal.getMaxSizeAnimalCell() * 100.0;
                    System.out.printf("%s %s%s: %d %s, ",
                            animal.getIcons(),
                            Color.getPercentAnimal(percentageOfMax),
                            animal.getShortName(),
                            animal.getCountAnimal(),
                            Color.RESET
                    );
                });
        System.out.println();


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

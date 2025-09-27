package com.javarush.island.babkin.map;

public class CellData {

    public int row;
    public int col;
    public int totalAnimals;

    public CellData(int row, int col, int totalAnimals) {
        this.row = row;
        this.col = col;
        this.totalAnimals = totalAnimals;
    }

    public int getTotalAnimals() {
        return totalAnimals;
    }

}

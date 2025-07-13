package com.javarush.island.babkin.servises;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor

public class ExampleClass implements Cloneable {
    private int countAnimal;
    private double packweight;
    private double foodAllPack;

    private double wiegthOneAnimal;
    private int maxSizeAnimalCell;
    private int maxSpeedCell;
    private double wiegthEating;

    public ExampleClass(double wiegthOneAnimal, int maxSizeAnimalCell, int maxSpeedCell, double wiegthEating, int countAnimal, double packweight, double foodAllPack) {
        this.wiegthOneAnimal = wiegthOneAnimal;
        this.maxSizeAnimalCell = maxSizeAnimalCell;
        this.maxSpeedCell = maxSpeedCell;
        this.wiegthEating = wiegthEating;
    }

    public double getWiegthOneAnimal() {
        return wiegthOneAnimal;
    }

//    private int getMaxSizeAnimalCell() {
//        return maxSizeAnimalCell;
//    }
//
//    private int getMaxSpeedCell() {
//        return maxSpeedCell;
//    }
//
//    private double getWiegthEating() {
//        return wiegthEating;
//    }
//
//    private int getCountAnimal() {
//        return countAnimal;
//    }
//
//    private double getPackweight() {
//        return packweight;
//    }
//
//    private double getFoodAllPack() {
//        return foodAllPack;
//    }

    @Override
    protected ExampleClass clone() throws CloneNotSupportedException {
        return (ExampleClass) super.clone();
    }

}

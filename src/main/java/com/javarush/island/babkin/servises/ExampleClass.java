package com.javarush.island.babkin.servises;

import com.javarush.island.babkin.organisms.animals.AnnotationAnimals;
import com.javarush.island.babkin.randoms.RandomImportance;
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
    private String icons;
    private String shortName;

    public ExampleClass(double wiegthOneAnimal, int maxSizeAnimalCell, int maxSpeedCell, double wiegthEating, String icons, String shortName, int countAnimal, double packweight, double foodAllPack) {
        this.wiegthOneAnimal = wiegthOneAnimal;
        this.maxSizeAnimalCell = maxSizeAnimalCell;
        this.maxSpeedCell = maxSpeedCell;
        this.wiegthEating = wiegthEating;
        this.countAnimal = countAnimal;
        this.packweight = packweight;
        this.foodAllPack = foodAllPack;
        this.icons = icons;
        this.shortName = shortName;
    }

    public static ExampleClass initClass(Class animalClass) {
        double wiegthOneAnimal;
        int maxSizeAnimalCell;
        int maxSpeedCell;
        double wiegthEating;
        String icons;
        String shortName;

        int countAnimal;
        double packWeight;
        double foodAllPack;

        if (!animalClass.isAnnotationPresent(AnnotationAnimals.class)) {
            throw new RuntimeException("animalClass param is not AnnotationAnimals");
        }


        AnnotationAnimals initialAnimal = (AnnotationAnimals) animalClass.getAnnotation(AnnotationAnimals.class);
        wiegthOneAnimal = initialAnimal.wiegthOneAnimal();
        maxSizeAnimalCell = initialAnimal.maxSizeAnimalCell();
        maxSpeedCell = initialAnimal.maxSpeedCell();
        wiegthEating = initialAnimal.wiegthEating();
        icons = initialAnimal.icon();
        shortName = initialAnimal.shortName();

        countAnimal = RandomImportance.getRandomQuantity(maxSizeAnimalCell);
        packWeight = countAnimal * wiegthOneAnimal;
        foodAllPack = countAnimal * wiegthEating;

        return new ExampleClass(wiegthOneAnimal, maxSizeAnimalCell, maxSpeedCell, wiegthEating, icons, shortName, countAnimal, packWeight, foodAllPack);
    }

    public double getWiegthOneAnimal() {
        return wiegthOneAnimal;
    }

    public int getMaxSizeAnimalCell() {
        return maxSizeAnimalCell;
    }

    public int getMaxSpeedCell() {
        return maxSpeedCell;
    }

    public double getWiegthEating() {
        return wiegthEating;
    }

    public String getIcons() {
        return icons;
    }

    public String getShortName() {
        return shortName;
    }

    public int getCountAnimal() {
        return countAnimal;
    }

    public double getPackweight() {
        return packweight;
    }

    public double getFoodAllPack() {
        return foodAllPack;
    }

    public void setPackweight(double packweight) {
        this.packweight = packweight;
    }

    @Override
    public ExampleClass clone() throws CloneNotSupportedException {
        return (ExampleClass) super.clone();
    }

    public void merge(ExampleClass other) {
        this.countAnimal += other.countAnimal;
        this.packweight += other.packweight;
        this.foodAllPack += other.foodAllPack;
    }

    public void addValue(int valueToAdd){
        this.countAnimal += valueToAdd;
        this.packweight += valueToAdd * wiegthOneAnimal;
        this.foodAllPack += valueToAdd * wiegthEating;
    }

}

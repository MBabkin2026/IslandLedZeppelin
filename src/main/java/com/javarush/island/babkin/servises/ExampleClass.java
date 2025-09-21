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

    public ExampleClass(double wiegthOneAnimal, int maxSizeAnimalCell, int maxSpeedCell, double wiegthEating, int countAnimal, double packweight, double foodAllPack) {
        this.wiegthOneAnimal = wiegthOneAnimal;
        this.maxSizeAnimalCell = maxSizeAnimalCell;
        this.maxSpeedCell = maxSpeedCell;
        this.wiegthEating = wiegthEating;
        this.countAnimal = countAnimal;
        this.packweight = packweight;
        this.foodAllPack = foodAllPack;

    }

    public static ExampleClass initClass(Class animalClass) {
        double wiegthOneAnimal;
        int maxSizeAnimalCell;
        int maxSpeedCell;
        double wiegthEating;

        int countAnimal;
        double packWeight;
        double foodAllPack;

        if (!animalClass.isAnnotationPresent(AnnotationAnimals.class)) {
            throw new RuntimeException("animalClass param is not AnnotationAnimals");
        }

        //   Вес одного животного, кг 2
//   Максимальное количество животных этого вида на одной клетке 150
//   Скорость перемещения, не более чем, клеток за ход 2
//   Сколько килограммов пищи нужно животному для полного насыщения

        //при инициал рандомно животных распологаем жл Максимальное количество
//        int countAnimal = RandomeImportance.getRandomQuantity(initialAnimal.maxSizeAnimalCell());
//         вес всей стаи double packWeight = wiegthOneAnimal * countAnimal;
//        сколько кг всей стаи нужно для утоления голода
//        double foodAllPack = countAnimal * initialAnimal.wiegthEating();


        AnnotationAnimals initialAnimal = (AnnotationAnimals) animalClass.getAnnotation(AnnotationAnimals.class);
        wiegthOneAnimal = initialAnimal.wiegthOneAnimal();
        maxSizeAnimalCell = initialAnimal.maxSizeAnimalCell();
        maxSpeedCell = initialAnimal.maxSpeedCell();
        wiegthEating = initialAnimal.wiegthEating();

        countAnimal = RandomImportance.getRandomQuantity(maxSizeAnimalCell);
        packWeight = countAnimal * wiegthOneAnimal;
        foodAllPack = countAnimal * wiegthEating;

        return new ExampleClass(wiegthOneAnimal, maxSizeAnimalCell, maxSpeedCell, wiegthEating, countAnimal, packWeight, foodAllPack);
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

}

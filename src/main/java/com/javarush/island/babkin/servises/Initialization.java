package com.javarush.island.babkin.servises;

import com.javarush.island.babkin.main;
import com.javarush.island.babkin.organisms.animals.AnnotationAnimals;
import com.javarush.island.babkin.randoms.RandomeImportance;

public class Initialization {

    private int countAnimal;
    private double packweight;
    private double foodAllPack;

//        public Initialization(int countAnimal, double packweight, double foodAllPack){
//            this.countAnimal =
//        }


    private double wiegthOneAnimal;

    private static AnnotationAnimals initialAnimal;

//        public int getCountAnimal() {
//            countAnimal = RandomeImportance.getRandomQuantity(new ExampleClas().getMaxSizeAnimalCell());
//        }

//        public double getPackweight() {
//            packweight = getWiegthOneAnimal() * getCountAnimal();
//        }
//
//        public double getFoodAllPack() {
//            foodAllPack = getCountAnimal() * initialAnimal.wiegthEating();
//        }

    public static AnnotationAnimals getAnnotationAnimals() {
        return initialAnimal;
    }

//        public static double getWiegthOneAnimal() {
//            return getAnnotationAnimals().wiegthOneAnimal();
//        }


    //        AnnotationAnimals initialAnimal = (AnnotationAnimals) animalClass.getAnnotation(AnnotationAnimals.class);


    public static class ExampleClass {
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
    }


    public static main.Initialization.ExampleClass initClass(Class animalClass) {
        double wiegthOneAnimal;
        int maxSizeAnimalCell;
        int maxSpeedCell;
        double wiegthEating;

        int countAnimal;
        double packweight;
        double foodAllPack;



        if (!animalClass.isAnnotationPresent(AnnotationAnimals.class)) {
            throw new RuntimeException("animalClass param is not AnnotationAnimals");
        }


        AnnotationAnimals initialAnimal = (AnnotationAnimals) animalClass.getAnnotation(AnnotationAnimals.class);
        wiegthOneAnimal = initialAnimal.wiegthOneAnimal();
        maxSizeAnimalCell = initialAnimal.maxSizeAnimalCell();
        maxSpeedCell = initialAnimal.maxSpeedCell();
        wiegthEating = initialAnimal.wiegthEating();

        countAnimal = RandomeImportance.getRandomQuantity(maxSizeAnimalCell);
        packweight = wiegthEating * countAnimal;
        foodAllPack = countAnimal * wiegthEating;


        return new main.Initialization.ExampleClass(wiegthOneAnimal, maxSizeAnimalCell, maxSpeedCell, wiegthEating, countAnimal, packweight, foodAllPack);
    }
}


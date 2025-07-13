package com.javarush.island.babkin.servises;

import com.javarush.island.babkin.organisms.animals.AnnotationAnimals;
import com.javarush.island.babkin.randoms.RandomeImportance;
//import java.lang.Object;

public class Initialization {

//    Class clazz;
//    ExampleClass exampleClass;
    ExampleClass cloneExampleClass;


    public Initialization(Class clazz) throws CloneNotSupportedException {
        var exampleClass = Initialization.initClass(clazz);
        ExampleClass cloneExampleClass = exampleClass.clone();
    }

    public ExampleClass getCloneExampleClass() {
        return cloneExampleClass;
    }

    //    public static ExampleClass getPrototype(exampleClass) {
//        try {
//            return getClone();
//        } catch (CloneNotSupportedException e) {
//            throw new RuntimeException(e);
//        }
//        Product product = new Product("Macbook Pro", 3000);
//        Product copyOfProduct = (Product) product.clone();
//    }

//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }

//    public static ExampleClass getClone() throws CloneNotSupportedException {
//        return (ExampleClass) exampleClass.clone();
//    }


//    private int countAnimal;
//    private double packweight;
//    private double foodAllPack;

//        public Initialization(int countAnimal, double packweight, double foodAllPack){
//            this.countAnimal =
//        }


//    private double wiegthOneAnimal;
//
//    private static AnnotationAnimals initialAnimal;

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

//    public static AnnotationAnimals getAnnotationAnimals() {
//        return initialAnimal;
//    }

//        public static double getWiegthOneAnimal() {
//            return getAnnotationAnimals().wiegthOneAnimal();
//        }


    //        AnnotationAnimals initialAnimal = (AnnotationAnimals) animalClass.getAnnotation(AnnotationAnimals.class);





    public static ExampleClass initClass(Class animalClass) {
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


        return new ExampleClass(wiegthOneAnimal, maxSizeAnimalCell, maxSpeedCell, wiegthEating, countAnimal, packweight, foodAllPack);
    }
}


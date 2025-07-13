package com.javarush.island.babkin;


import com.javarush.island.babkin.organisms.animals.Animal;
import com.javarush.island.babkin.organisms.animals.AnnotationAnimals;
import com.javarush.island.babkin.organisms.animals.Rabbit;
import com.javarush.island.babkin.organisms.animals.Wolf;
import com.javarush.island.babkin.organisms.plants.Grass;
import com.javarush.island.babkin.randoms.RandomeImportance;


import java.util.*;

public class main {
    public static void main(String[] args) {
        int bound = 3;

//		for(int i = 0; i < 100; i++) {
        int value = 1 + new Random().nextInt(bound);
        System.out.println(value);
//		}

        Grass grass = new Grass();
        grass.setBirthGrass();
        double countGrass = grass.getCountGrass();

        System.out.println("Main countGrass" + countGrass);

        Rabbit rabbit = new Rabbit(value, countGrass);


        double remainGrass = rabbit.eat();
        grass.setCountGrass(remainGrass);

        double countGrass2 = grass.getCountGrass();

        System.out.println(remainGrass + "remainGrass");
        System.out.println(countGrass2 + "countGrass2");

        // TODO

        init(Rabbit.class);
        System.out.println(init(Rabbit.class) + " -  init(Rabbit.class)");
        init(Wolf.class);
        System.out.println(init(Wolf.class) + " -  init(Wolf.class)");

        //   Вес одного животного, кг 2
//   Максимальное количество животных этого вида на одной клетке 150
//   Скорость перемещения, не более чем, клеток за ход 2
//   Сколько килограммов пищи нужно животному для полного насыщения

        //при инициал рандомно животных распологаем жл Максимальное количество
//        int countAnimal = RandomeImportance.getRandomQuantity(initialAnimal.maxSizeAnimalCell());
        // вес всей стаи double packweight = wiegthOneAnimal * countAnimal;
//        сколько кг всей стаи нужно для утоления голода
//        double foodAllPack = countAnimal * initialAnimal.wiegthEating();


//        animalInitialization


        //проверка инициализации животных в массив и выбора еее оттуд по классу и аннотации

        List<? super Animal> animals = new ArrayList<>();
        animals.add(new Rabbit());
        animals.add(new Wolf());

        System.out.println(animals.getFirst().getClass() + " -  animals.getFirst().getClass()");

        System.out.println(animals.get(1).getClass() + " -  animals.get(1).getClass()");

        init(animals.get(1).getClass());

        Map<String, ? super Animal> mapAnim = new HashMap<>();
        mapAnim.put("Wolf", new Wolf());
        mapAnim.put("Rabbit", new Rabbit());

        System.out.println(mapAnim.get("Wolf").getClass());

        System.out.println();

        for (int i = 0; i < Animal.animalsClass.size(); i++) {
            if ("Wolf".equals(Animal.animalsClass.get(i))) {
                System.out.println(Animal.animalsClass.get(i) + i);
            }
        }

        System.out.println(Animal.animalsClass.get(0));
        //проверка инициализации животных в массив и выбора еее оттуд по классу и аннотации

    }

    //Создаю клсасс инициализации для объектов

    public static class Initialization {
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


    public static boolean init(Class animalClass) {
        if (!animalClass.isAnnotationPresent(AnnotationAnimals.class)) {
            throw new RuntimeException("animalClass param is not AnnotationAnimals");
        }


        AnnotationAnimals initialAnimal = (AnnotationAnimals) animalClass.getAnnotation(AnnotationAnimals.class);
        System.out.println(initialAnimal.wiegthOneAnimal());
        System.out.println(initialAnimal.maxSizeAnimalCell());
        System.out.println(initialAnimal.maxSpeedCell());
        System.out.println(initialAnimal.wiegthEating());

        return true;
    }


}

package com.javarush.island.babkin.organisms.animals;

import com.javarush.island.babkin.interfaces.Eatable;
import com.javarush.island.babkin.interfaces.Moveable;
import com.javarush.island.babkin.interfaces.Reproducible;
import com.javarush.island.babkin.organisms.animals.herbivores.*;
import com.javarush.island.babkin.organisms.animals.predators.*;
import com.javarush.island.babkin.organisms.plants.Grass;

import java.util.*;

public class Animal implements Eatable, Moveable, Reproducible {

    private double wiegthOneAnimal;
    private int maxSizeAnimalCell;
    private int maxSpeedCell;
    private double wiegthEating;
    private int countAnimal;
    private double packweight;
    private double foodAllPack;

    public static Map<String, Class> mapAnimals;

    static {
        mapAnimals = new HashMap<>();
        setMapAnimals();
    }

    @Override
    public void move() {

    }

    @Override
    public double eat() {
        return 0.0d;
    }

    @Override
    public void reproduce() {

    }

    public static List<String> animalsClass = new ArrayList<String>(
            List.of("Wolf", "Boa", "Fox", "Bear", "Eagle",
                    "Horse", "Deer", "Rabbit", "Mouse", "Goat", "Sheep", "Wildboar", "Buffalo", "Duck", "Caterpillar",
                    "Grass"));

    public static int[][] probabilityEat = {
            {0, 0, 0, 0, 0, 10, 15, 60, 80, 60, 70, 15, 10, 40, 0, 0},
            {0, 0, 15, 0, 0, 0, 0, 20, 40, 0, 0, 0, 0, 10, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 70, 90, 0, 0, 0, 0, 60, 40, 0},
            {0, 80, 0, 0, 0, 40, 80, 80, 90, 70, 70, 50, 20, 10, 0, 0},
            {0, 0, 10, 0, 0, 0, 0, 90, 90, 0, 0, 0, 0, 80, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 90, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 50, 0, 0, 0, 0, 0, 90, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 90, 100},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100}
    };

    private static void setMapAnimals() {

        mapAnimals.put("Wolf", Wolf.class);
        mapAnimals.put("Boa", Boa.class);
        mapAnimals.put("Fox", Fox.class);
        mapAnimals.put("Bear", Bear.class);
        mapAnimals.put("Eagle", Eagle.class);

        mapAnimals.put("Horse", Horse.class);
        mapAnimals.put("Deer", Deer.class);
        mapAnimals.put("Rabbit", Rabbit.class);
        mapAnimals.put("Mouse", Mouse.class);
        mapAnimals.put("Goat", Goat.class);
        mapAnimals.put("Sheep", Sheep.class);
        mapAnimals.put("Wildboar", Wildboar.class);
        mapAnimals.put("Buffalo", Buffalo.class);
        mapAnimals.put("Duck", Duck.class);
        mapAnimals.put("Caterpillar", Caterpillar.class);

        mapAnimals.put("Grass", Grass.class);
    }


}

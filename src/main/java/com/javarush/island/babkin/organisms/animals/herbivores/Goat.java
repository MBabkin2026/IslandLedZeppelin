package com.javarush.island.babkin.organisms.animals.herbivores;

import com.javarush.island.babkin.organisms.animals.AnnotationAnimals;
import com.javarush.island.babkin.organisms.animals.Herbivore;


@AnnotationAnimals(wiegthOneAnimal = 60.d, maxSizeAnimalCell = 140, maxSpeedCell = 3, wiegthEating = 10.d)
public class Goat extends Herbivore implements Cloneable {
    @Override
    public double eat() {
        return 0;
    }

    @Override
    public Goat clone() throws CloneNotSupportedException {
        return (Goat) super.clone();
    }

}
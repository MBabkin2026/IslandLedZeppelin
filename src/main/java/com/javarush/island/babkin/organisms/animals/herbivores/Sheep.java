package com.javarush.island.babkin.organisms.animals.herbivores;

import com.javarush.island.babkin.organisms.animals.AnnotationAnimals;
import com.javarush.island.babkin.organisms.animals.Herbivore;


@AnnotationAnimals(wiegthOneAnimal = 70.d, maxSizeAnimalCell = 140, maxSpeedCell = 3, wiegthEating = 15.d, icon = "\uD83D\uDC11")
public class Sheep extends Herbivore implements Cloneable {
    @Override
    public double eat() {
        return 0;
    }

    @Override
    public Sheep clone() throws CloneNotSupportedException {
        return (Sheep) super.clone();
    }

}
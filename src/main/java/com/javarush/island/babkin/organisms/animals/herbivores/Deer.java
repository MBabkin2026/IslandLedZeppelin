package com.javarush.island.babkin.organisms.animals.herbivores;

import com.javarush.island.babkin.organisms.animals.AnnotationAnimals;
import com.javarush.island.babkin.organisms.animals.Herbivore;


@AnnotationAnimals(wiegthOneAnimal = 400.d, maxSizeAnimalCell = 20, maxSpeedCell = 4, wiegthEating = 60.d, icon = "\uD83E\uDD8C", shortName = "Dr")
public class Deer extends Herbivore implements Cloneable {
    @Override
    public double eat() {
        return 0;
    }

    @Override
    public Deer clone() throws CloneNotSupportedException {
        return (Deer) super.clone();
    }

}




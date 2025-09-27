package com.javarush.island.babkin.organisms.animals.predators;

import com.javarush.island.babkin.organisms.animals.AnnotationAnimals;
import com.javarush.island.babkin.organisms.animals.Predator;


@AnnotationAnimals(wiegthOneAnimal = 500.d, maxSizeAnimalCell = 5, maxSpeedCell = 2, wiegthEating = 80.d, icon = "\uD83D\uDC3B", shortName = "Br")
public class Bear extends Predator implements Cloneable {
    @Override
    public double eat() {
        return 0;
    }

    @Override
    public Bear clone() throws CloneNotSupportedException {
        return (Bear) super.clone();
    }
}

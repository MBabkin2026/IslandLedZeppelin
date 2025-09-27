package com.javarush.island.babkin.organisms.animals.predators;

import com.javarush.island.babkin.organisms.animals.AnnotationAnimals;
import com.javarush.island.babkin.organisms.animals.Predator;


@AnnotationAnimals(wiegthOneAnimal = 500.d, maxSizeAnimalCell = 5, maxSpeedCell = 2, wiegthEating = 80.d, icon = "\uD83E\uDD85", shortName = "Eg")
public class Eagle extends Predator implements Cloneable {
    @Override
    public double eat() {
        return 0;
    }

    @Override
    public Eagle clone() throws CloneNotSupportedException {
        return (Eagle) super.clone();
    }
}

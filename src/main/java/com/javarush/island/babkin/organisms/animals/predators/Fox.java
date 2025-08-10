package com.javarush.island.babkin.organisms.animals.predators;

import com.javarush.island.babkin.organisms.animals.AnnotationAnimals;
import com.javarush.island.babkin.organisms.animals.Predator;

@AnnotationAnimals(wiegthOneAnimal = 8.d, maxSizeAnimalCell = 30, maxSpeedCell = 2, wiegthEating = 2.d)
public class Fox extends Predator implements Cloneable {
    @Override
    public double eat() {
        return 0;
    }

    @Override
    public Fox clone() throws CloneNotSupportedException {
        return (Fox) super.clone();
    }
}

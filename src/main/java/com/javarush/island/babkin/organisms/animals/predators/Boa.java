package com.javarush.island.babkin.organisms.animals.predators;

import com.javarush.island.babkin.organisms.animals.AnnotationAnimals;
import com.javarush.island.babkin.organisms.animals.Predator;

@AnnotationAnimals(wiegthOneAnimal = 15.d, maxSizeAnimalCell = 30, maxSpeedCell = 3, wiegthEating = 3.d)
public class Boa extends Predator implements Cloneable {
    @Override
    public double eat() {
        return 0;
    }

    @Override
    public Wolf clone() throws CloneNotSupportedException {
        return (Wolf) super.clone();
    }
}

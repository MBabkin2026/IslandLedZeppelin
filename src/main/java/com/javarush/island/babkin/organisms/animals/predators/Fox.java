package com.javarush.island.babkin.organisms.animals.predators;

import com.javarush.island.babkin.organisms.animals.AnnotationAnimals;
import com.javarush.island.babkin.organisms.animals.Predator;

@AnnotationAnimals(wiegthOneAnimal = 8.d, maxSizeAnimalCell = 30, maxSpeedCell = 2, wiegthEating = 2.d, icon = "\uD83E\uDD8A", shortName = "Fx")
public class Fox extends Predator implements Cloneable {

    @Override
    public Fox clone() throws CloneNotSupportedException {
        return (Fox) super.clone();
    }
}

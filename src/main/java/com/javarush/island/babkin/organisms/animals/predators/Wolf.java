package com.javarush.island.babkin.organisms.animals.predators;

import com.javarush.island.babkin.organisms.animals.AnnotationAnimals;
import com.javarush.island.babkin.organisms.animals.Predator;

@AnnotationAnimals(wiegthOneAnimal = 50.d, maxSizeAnimalCell = 30, maxSpeedCell = 3, wiegthEating = 8.d, icon = "\uD83D\uDC3A", shortName = "Wf")
public class Wolf extends Predator implements Cloneable {

    @Override
    public Wolf clone() throws CloneNotSupportedException {
        return (Wolf) super.clone();
    }
}

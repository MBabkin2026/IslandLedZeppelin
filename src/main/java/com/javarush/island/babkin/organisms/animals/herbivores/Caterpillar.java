package com.javarush.island.babkin.organisms.animals.herbivores;

import com.javarush.island.babkin.organisms.animals.AnnotationAnimals;
import com.javarush.island.babkin.organisms.animals.Herbivore;

@AnnotationAnimals(wiegthOneAnimal = 0.001d, maxSizeAnimalCell = 1000, maxSpeedCell = 0, wiegthEating = 0.d, icon = "\uD83D\uDC1B", shortName = "Cr")
public class Caterpillar extends Herbivore implements Cloneable {
    @Override
    public double eat() {
        return 0;
    }

    @Override
    public Caterpillar clone() throws CloneNotSupportedException {
        return (Caterpillar) super.clone();
    }

}
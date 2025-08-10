package com.javarush.island.babkin.organisms.animals.herbivores;

import com.javarush.island.babkin.organisms.animals.AnnotationAnimals;
import com.javarush.island.babkin.organisms.animals.Herbivore;

@AnnotationAnimals(wiegthOneAnimal = 1.d, maxSizeAnimalCell = 200, maxSpeedCell = 4, wiegthEating = 0.15d)
public class Duck extends Herbivore implements Cloneable {
    @Override
    public double eat() {
        return 0;
    }

    @Override
    public Duck clone() throws CloneNotSupportedException {
        return (Duck) super.clone();
    }

}
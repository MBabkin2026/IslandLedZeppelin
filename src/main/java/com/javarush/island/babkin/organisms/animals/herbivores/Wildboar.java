package com.javarush.island.babkin.organisms.animals.herbivores;

import com.javarush.island.babkin.organisms.animals.AnnotationAnimals;
import com.javarush.island.babkin.organisms.animals.Herbivore;

@AnnotationAnimals(wiegthOneAnimal = 400.d, maxSizeAnimalCell = 50, maxSpeedCell = 2, wiegthEating = 50.d, icon = "\uD83D\uDC17", shortName = "Wr")
public class Wildboar extends Herbivore implements Cloneable {
    @Override
    public double eat() {
        return 0;
    }

    @Override
    public Wildboar clone() throws CloneNotSupportedException {
        return (Wildboar) super.clone();
    }

}
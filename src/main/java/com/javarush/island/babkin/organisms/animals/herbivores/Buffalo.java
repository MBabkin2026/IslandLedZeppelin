package com.javarush.island.babkin.organisms.animals.herbivores;

import com.javarush.island.babkin.organisms.animals.AnnotationAnimals;
import com.javarush.island.babkin.organisms.animals.Herbivore;

@AnnotationAnimals(wiegthOneAnimal = 700.d, maxSizeAnimalCell = 10, maxSpeedCell = 3, wiegthEating = 100.d, icon = "\uD83D\uDC02", shortName = "Bf")
public class Buffalo extends Herbivore implements Cloneable {

    @Override
    public Buffalo clone() throws CloneNotSupportedException {
        return (Buffalo) super.clone();
    }

}

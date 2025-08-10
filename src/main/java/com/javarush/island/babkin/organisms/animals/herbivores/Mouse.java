package com.javarush.island.babkin.organisms.animals.herbivores;

import com.javarush.island.babkin.organisms.animals.AnnotationAnimals;
import com.javarush.island.babkin.organisms.animals.Herbivore;


@AnnotationAnimals(wiegthOneAnimal = 0.05d, maxSizeAnimalCell = 500, maxSpeedCell = 1, wiegthEating = 0.01d)
public class Mouse extends Herbivore implements Cloneable {
    @Override
    public double eat() {
        return 0;
    }

    @Override
    public Mouse clone() throws CloneNotSupportedException {
        return (Mouse) super.clone();
    }

}
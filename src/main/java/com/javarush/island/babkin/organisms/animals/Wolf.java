package com.javarush.island.babkin.organisms.animals;

@AnnotationAnimals(wiegthOneAnimal = 50.d, maxSizeAnimalCell = 30, maxSpeedCell = 3, wiegthEating = 8.d)
public class Wolf extends Predator {
    @Override
    public double eat() {
        return 0;
    }
}

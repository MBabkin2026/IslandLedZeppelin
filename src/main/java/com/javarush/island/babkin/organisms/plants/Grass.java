package com.javarush.island.babkin.organisms.plants;

import com.javarush.island.babkin.organisms.animals.AnnotationAnimals;

@AnnotationAnimals(wiegthOneAnimal = 1.d, maxSizeAnimalCell = 200, maxSpeedCell = 0, wiegthEating = 0.d)
public class Grass {
    private double countGrass;

    public Grass(){
    }

    public void setBirthGrass() {
        this.countGrass = 200;
    }

    public double getCountGrass() {
        return countGrass;
    }

    public void setCountGrass(double countGrass) {
        this.countGrass = countGrass;
    }
}

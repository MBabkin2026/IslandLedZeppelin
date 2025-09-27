package com.javarush.island.babkin.organisms.plants;

import com.javarush.island.babkin.organisms.animals.AnnotationAnimals;

import java.util.Objects;

@AnnotationAnimals(wiegthOneAnimal = 1.d, maxSizeAnimalCell = 200, maxSpeedCell = 0, wiegthEating = 0.d, icon = "\uD83C\uDF3F")
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Grass grass = (Grass) o;
        return Double.compare(countGrass, grass.countGrass) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(countGrass);
    }
}

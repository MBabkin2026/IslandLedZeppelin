package com.javarush.island.babkin.organisms.plants;

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

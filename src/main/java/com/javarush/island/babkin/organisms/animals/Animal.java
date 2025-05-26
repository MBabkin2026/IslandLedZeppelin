package com.javarush.island.babkin.organisms.animals;

import com.javarush.island.babkin.interfaces.Eatable;
import com.javarush.island.babkin.interfaces.Moveable;
import com.javarush.island.babkin.interfaces.Reproducible;

abstract public class Animal implements Eatable, Moveable, Reproducible {

    @Override
    public void move() {

    }

    @Override
    public abstract double eat();

    @Override
    public void reproduce() {

    }
}

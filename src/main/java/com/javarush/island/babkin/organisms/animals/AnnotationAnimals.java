package com.javarush.island.babkin.organisms.animals;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)

public @interface AnnotationAnimals {
    double wiegthOneAnimal();

    int maxSizeAnimalCell();

    int maxSpeedCell();

    double wiegthEating();
}


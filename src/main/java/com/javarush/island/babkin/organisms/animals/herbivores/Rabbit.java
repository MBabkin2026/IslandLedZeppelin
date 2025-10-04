package com.javarush.island.babkin.organisms.animals.herbivores;


import com.javarush.island.babkin.organisms.animals.AnnotationAnimals;
import com.javarush.island.babkin.organisms.animals.Herbivore;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AnnotationAnimals(wiegthOneAnimal = 2.d, maxSizeAnimalCell = 150, maxSpeedCell = 2, wiegthEating = 0.45, icon = "\uD83D\uDC07", shortName = "Rb")
public class Rabbit extends Herbivore implements Cloneable {

    @Override
    public Rabbit clone() throws CloneNotSupportedException {
        return (Rabbit) super.clone();
    }
}

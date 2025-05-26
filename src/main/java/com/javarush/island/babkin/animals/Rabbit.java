package com.javarush.island.babkin.animals;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rabbit extends Herbivore {

    private String bame;
    private int year;


    public Rabbit() {
    }

    public Rabbit(String bame, int year) {
        this.bame = bame;
        this.year = year;
    }




}

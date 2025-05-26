package com.javarush.island.babkin;


import com.javarush.island.babkin.organisms.animals.Rabbit;
import com.javarush.island.babkin.organisms.plants.Grass;

import java.util.Random;

public class main {
    public static void main(String[] args) {

        int bound = 3;

//	 	for(int i = 0; i < 100; i++) {
        int value = 1 + new Random().nextInt(bound);
        System.out.println(value);
//	 	}

        Grass grass = new Grass();
        grass.setBirthGrass();
        double countGrass = grass.getCountGrass();

        System.out.println("Main countGrass" + countGrass);

        Rabbit rabbit = new Rabbit(value, countGrass);


        double remainGrass = rabbit.eat();
        grass.setCountGrass(remainGrass);

        double countGrass2 = grass.getCountGrass();

        System.out.println(remainGrass);
        System.out.println(countGrass2);



    }



}

package com.javarush.island.babkin;


import com.javarush.island.babkin.organisms.animals.Rabbit;

public class main {
    public static void main(String[] args) {

        Rabbit rabbit = new Rabbit("rabbbit",13);
        String name = rabbit.getBame();
        System.out.println(name);

    }



}

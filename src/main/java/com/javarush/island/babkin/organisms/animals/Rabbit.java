package com.javarush.island.babkin.organisms.animals;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AnnotationAnimals(wiegthOneAnimal = 2.d, maxSizeAnimalCell = 150, maxSpeedCell = 2, wiegthEating = 0.45)
public class Rabbit extends Herbivore {

    private String bame;
    private int year;


    public Rabbit() {
    }

    public Rabbit(String bame, int year) {
        this.bame = bame;
        this.year = year;
    }


//    Grass grass = new Grass();
//    int countGrass = grass.getCountGrass();

    int countRabbit;
    double lmititEatGrass = 0.45;
    double sumEatGrass;
    //    double remainGrass;
    double countGrass;

//   Вес одного животного, кг 2
//   Максимальное количество животных этого вида на одной клетке 150
//   Скорость перемещения, не более чем, клеток за ход 2
//   Сколько килограммов пищи нужно животному для полного насыщения


    public Rabbit(int countRabbit, double countGrass) {
        this.countRabbit = countRabbit;
        this.countGrass = countGrass;

        sumEatGrass = countRabbit * lmititEatGrass;
//        double remainGrass = countGrass - sumEatGrass;
        System.out.println(" countRabbit " + countRabbit);
        System.out.println(" countGrass " + countGrass);


    }


//    public void setRemainGrass(double val){
//        this.remainGrass = remainGrass;
//    }

//    public double getRemainGrass(){
//        return this.remainGrass;
//    }

    public double eat() {
        double remainGrass = countGrass - sumEatGrass;
//        setRemainGrass(remainGrass);
//        System.out.println("Кушает травку - " + countRabbit + " " + countGrass + " " + sumEatGrass);
        System.out.printf("Кушает травку - %s, %s, %s%n", countRabbit, countGrass, sumEatGrass);
//        System.out.println("Съеденно травки - " + sumEatGrass + "осталось травки - " + remainGrass);
        System.out.printf("Съеденно травки - %s, осталось травки %s%n", sumEatGrass, remainGrass);
        return remainGrass;
    }


}

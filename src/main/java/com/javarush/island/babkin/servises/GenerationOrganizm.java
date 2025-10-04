package com.javarush.island.babkin.servises;

import com.javarush.island.babkin.map.MapGame;
import com.javarush.island.babkin.organisms.animals.Animal;
import com.javarush.island.babkin.randoms.RandomImportance;
//import lombok.var;

import java.util.*;

public class GenerationOrganizm {


    public static Set<ExampleClass>[][] getGenerationOrganizm() {

        var mapGame = MapGame.getMapGame();
        var animalsClass = Animal.animalsClass;


        for(int i = 0; i<mapGame.length;i++) {
            for (int j = 0; j < mapGame[i].length; j++) {
                var randomQuantity = RandomImportance.getRandomQuantity(animalsClass.size());
                Set<ExampleClass> setRandomAnimal = new HashSet<>();
                for (int x = 0; x < randomQuantity; x++) {
                    var randomClass = RandomImportance.getRandomQuantity(animalsClass.size());
                    var nameAnimal = animalsClass.get(randomClass);
                    var classExample = Animal.mapAnimals.get(nameAnimal);
                    if (classExample != null) {
                        setRandomAnimal.add(ExampleClass.initClass(classExample));
                    } else {
                        System.out.println("Error: Class for " + nameAnimal + " not found!");
                    }

                }
                mapGame[i][j] = setRandomAnimal;

            }
        }
        return mapGame;
    }

}

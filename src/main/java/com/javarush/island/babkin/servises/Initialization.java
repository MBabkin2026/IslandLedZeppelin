package com.javarush.island.babkin.servises;

import com.javarush.island.babkin.organisms.animals.Animal;
import com.javarush.island.babkin.organisms.animals.herbivores.*;
import com.javarush.island.babkin.organisms.animals.predators.*;
import com.javarush.island.babkin.organisms.plants.Grass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Initialization extends Animal implements Cloneable {

    public static Map<String, Object> mapCopyAnimals = new HashMap<>();

    private Initialization(){}

    public static Map<String,? super Animal> getMapCopyAnimals() {
        return mapCopyAnimals;
    }

    public static int getCountCopyAnimals(){
        return mapCopyAnimals.size();
    }

    public static List<String> animalsClass = new ArrayList<String>(
            List.of("Wolf", "Boa", "Fox", "Bear", "Eagle",
                    "Horse", "Deer", "Rabbit", "Mouse", "Goat", "Sheep", "Wildboar", "Buffalo", "Duck", "Caterpillar",
                    "Grass"));



    public static void defaultFillingMapCopyAnimals(){
        mapCopyAnimals.put("Wolf", new Wolf());
        mapCopyAnimals.put("Boa", new Boa());
        mapCopyAnimals.put("Fox", new Fox());
        mapCopyAnimals.put("Bear", new Bear());
        mapCopyAnimals.put("Eagle", new Eagle());

        mapCopyAnimals.put("Horse", new Horse());
        mapCopyAnimals.put("Deer", new Deer());
        mapCopyAnimals.put("Rabbit", new Rabbit());
        mapCopyAnimals.put("Mouse", new Mouse());
        mapCopyAnimals.put("Goat", new Goat());
        mapCopyAnimals.put("Sheep", new Sheep());
        mapCopyAnimals.put("Wildboar", new Wildboar());
        mapCopyAnimals.put("Buffalo", new Buffalo());
        mapCopyAnimals.put("Duck", new Duck());
        mapCopyAnimals.put("Caterpillar", new Caterpillar());

        mapCopyAnimals.put("Grass", new Grass());
    }


    public void putMapCopyAnimals(String str, Class<?> clazz) {

        try {

            Object obj = clazz.getDeclaredConstructor().newInstance();


            if (!(obj instanceof Cloneable)) {
                throw new IllegalArgumentException("Class " + clazz.getName() + " does not implement Cloneable.");
            }

            Object clonedObj = cloneObject(obj);

            mapCopyAnimals.put(str, clonedObj);

        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Class " + clazz.getName() + " does not have a public no-argument constructor.", e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Cannot access the constructor of class " + clazz.getName() + ".", e);
        } catch (java.lang.reflect.InvocationTargetException e) {
            throw new RuntimeException("Exception during constructor execution for class " + clazz.getName() + ".", e);
        } catch (InstantiationException e) {
            throw new RuntimeException("Cannot instantiate class " + clazz.getName() + ".  Is it abstract?", e);
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("CloneNotSupportedException during clone() execution for class " + clazz.getName() + ".", e);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e.getMessage(), e); // Перебрасываем IllegalArgumentException
        }
    }

    public static Object cloneObject(Object obj) throws CloneNotSupportedException {
        try {
            return obj.getClass().getMethod("clone").invoke(obj);
        } catch (NoSuchMethodException e) {
            throw new CloneNotSupportedException("Object does not have a public clone() method: " + e.getMessage());
        } catch (IllegalAccessException e) {
            throw new CloneNotSupportedException("Cannot access clone() method: " + e.getMessage());
        } catch (java.lang.reflect.InvocationTargetException e) {
            throw new CloneNotSupportedException("Exception during clone() execution: " + e.getMessage());
        }
    }


    @Override
    protected Initialization clone() throws CloneNotSupportedException {
        return (Initialization) super.clone();
    }


}


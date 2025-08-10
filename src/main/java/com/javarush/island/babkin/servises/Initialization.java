package com.javarush.island.babkin.servises;

import com.javarush.island.babkin.organisms.animals.Animal;
import com.javarush.island.babkin.organisms.animals.herbivores.*;
import com.javarush.island.babkin.organisms.animals.predators.*;
import com.javarush.island.babkin.organisms.plants.Grass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import java.lang.Object;

public class Initialization extends Animal implements Cloneable {

    //        Мы записываем в мапу копии классов и с мапы по Строке выводим копию классов животных и их инициализируем

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

//    public Initialization() {
//        try {
//            mapCopyAnimals.put("Wolf", new Wolf().clone());
//            mapCopyAnimals.put("Rabbit", new Rabbit().clone());
//        } catch (CloneNotSupportedException e) {
//            throw new RuntimeException(e);
//        }
//    }

//    private Initialization(){}

//    public void putMapCopyAnimals(String str,Class clazz) {
//        try {
//            var clone = cloneExampleClass.getClass().clone();
//            mapCopyAnimals.put()
//            Initialization.mapCopyAnimals.put(str, new clazz().clone());
//        } catch (CloneNotSupportedException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public void putMapCopyAnimals(String str, Class<?> clazz) { // Class<?> чтобы принимать любой класс

        try {
            // Создаем экземпляр класса используя рефлексию.
            Object obj = clazz.getDeclaredConstructor().newInstance(); // getDeclaredConstructor() и newInstance() требуют обработки исключений

            // Проверяем, реализует ли объект Cloneable
            if (!(obj instanceof Cloneable)) {
                throw new IllegalArgumentException("Class " + clazz.getName() + " does not implement Cloneable.");
            }

            // Клонируем объект
            Object clonedObj = cloneObject(obj);

            // Добавляем клон в карту
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


    //    mapCopyAnimals.put("Wolf", new Wolf().clone());
//    mapCopyAnimals.put("Rabbit", new Rabbit().clone());


    //    Object rabbit3 = mapAnim2.get("Rabbit");
//    var exampleClass3 = ExampleClass.initClass(rabbit3.getClass());
//    var maxSizeAnimalCell2 = exampleClass3.getMaxSizeAnimalCell();
//        System.out.println(rabbit3);



//    Class clazz;
//    ExampleClass exampleClass;
    public ExampleClass cloneExampleClass;
//    public Rabbit cloneRabbitClass;


//    public Initialization(Class clazz) {
//        try {
//            var exampleClass = ExampleClass.initClass(clazz);
//            ExampleClass cloneExampleClass = exampleClass.clone();
//        } catch (CloneNotSupportedException e) {
//            throw new RuntimeException(e);
//            throw new RuntimeException("cloneExampleClass",e);
//        }

//    }

    public Initialization(Class clazz) {

            Class<? extends Class> aClass = clazz.getClass();

//            var cloneRabbitClass = clazz.clone();


    }

    public static void mapCopyAnimals() {
    }


    public ExampleClass getCloneExampleClass() {
        return cloneExampleClass;
    }

    @Override
    protected Initialization clone() throws CloneNotSupportedException {
        return (Initialization) super.clone();
    }

    //    public static ExampleClass getPrototype(exampleClass) {
//        try {
//            return getClone();
//        } catch (CloneNotSupportedException e) {
//            throw new RuntimeException(e);
//        }
//        Product product = new Product("Macbook Pro", 3000);
//        Product copyOfProduct = (Product) product.clone();
//    }

//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }

//    public static ExampleClass getClone() throws CloneNotSupportedException {
//        return (ExampleClass) exampleClass.clone();
//    }


//    private int countAnimal;
//    private double packweight;
//    private double foodAllPack;

//        public Initialization(int countAnimal, double packweight, double foodAllPack){
//            this.countAnimal =
//        }


//    private double wiegthOneAnimal;
//
//    private static AnnotationAnimals initialAnimal;

//        public int getCountAnimal() {
//            countAnimal = RandomeImportance.getRandomQuantity(new ExampleClas().getMaxSizeAnimalCell());
//        }

//        public double getPackweight() {
//            packweight = getWiegthOneAnimal() * getCountAnimal();
//        }
//
//        public double getFoodAllPack() {
//            foodAllPack = getCountAnimal() * initialAnimal.wiegthEating();
//        }

//    public static AnnotationAnimals getAnnotationAnimals() {
//        return initialAnimal;
//    }

//        public static double getWiegthOneAnimal() {
//            return getAnnotationAnimals().wiegthOneAnimal();
//        }


    //        AnnotationAnimals initialAnimal = (AnnotationAnimals) animalClass.getAnnotation(AnnotationAnimals.class);






}


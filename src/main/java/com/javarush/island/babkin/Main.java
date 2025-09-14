package com.javarush.island.babkin;


import com.javarush.island.babkin.map.MapGame;
import com.javarush.island.babkin.organisms.animals.*;
import com.javarush.island.babkin.organisms.animals.herbivores.Rabbit;
import com.javarush.island.babkin.organisms.animals.predators.Wolf;
import com.javarush.island.babkin.organisms.plants.Grass;
import com.javarush.island.babkin.randoms.RandomImportance;
import com.javarush.island.babkin.servises.ExampleClass;
import com.javarush.island.babkin.servises.GenerationOrganizm;
import com.javarush.island.babkin.servises.Initialization;



import java.lang.annotation.Annotation;
import java.util.*;

import static com.javarush.island.babkin.servises.Initialization.mapCopyAnimals;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        int bound = 3;

//		for(int i = 0; i < 100; i++) {
        int value = 1 + new Random().nextInt(bound);
        System.out.println(value);
//		}

        //создаем игровую карту





        Set<ExampleClass>[][] gameMap = new HashSet[3][3];

        for (int i = 0; i < gameMap.length; i++) {
            for (int j = 0; j < gameMap[i].length; j++) {
                gameMap[i][j] = new HashSet<>();
            }
        }




// Заселение мира

//        var mapGame = MapGame.getMapGame();
//        var animalsClass = Animal.animalsClass;
//        var randomQuantity = RandomImportance.getRandomQuantity(animalsClass.size());
//
//        for (int i = 0; i < mapGame.length; i++) {
//            for (int j = 0; j < mapGame[i].length; j++) {
//                Set<ExampleClass> setRandomAnimal = new HashSet<>();
//                for(int x = 0; x < randomQuantity; x++){
//                    var randomClass = RandomImportance.getRandomQuantity(animalsClass.size());
//                    var nameAnimal = animalsClass.get(randomClass);
//                    var classExample = Animal.mapAnimals.get(nameAnimal);
//                    var add = setRandomAnimal.add(ExampleClass.initClass(classExample));
////                    System.out.println(randomQuantity);
////                    System.out.println(nameAnimal);
////                    System.out.println(classExample);
//                }
//                mapGame[i][j] = setRandomAnimal;
//                System.out.println(mapGame[i][j]);
//            }
//        }

        var generationOrganizm = GenerationOrganizm.getGenerationOrganizm();


        for (Object obj : generationOrganizm) {
            System.out.println(obj);
        }
//
        for (int i = 0; i < generationOrganizm.length; i++) {
            for (int j = 0; j < generationOrganizm[i].length; j++) {
                System.out.println("i - " + i + "j - " + j + " ; mapGame[i][j] - " + generationOrganizm[i][j]);
            }
        }

        System.out.println("------------------------------------------------------------------------------------------");

//создаем экземпляры классов
        Set<ExampleClass> setAnimal = new HashSet<>();
        var exampleClass6 = ExampleClass.initClass(Rabbit.class);

        setAnimal.add(exampleClass6);
        setAnimal.add(ExampleClass.initClass(Wolf.class));
        setAnimal.add(ExampleClass.initClass(Rabbit.class));

        gameMap[0][0] = setAnimal;

//        for (Set<ExampleClass> obj : gameMap) {
//            System.out.println(obj);
//            obj.stream().forEach(x -> System.out.println(x.getWiegthOneAnimal()));
//        }


        System.out.println("888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888");

        setAnimal.stream()

                .peek(e ->
                        System.out.println(
                                "e.getWiegthOneAnimal()" + e.getWiegthOneAnimal() +
                                        "e.getMaxSizeAnimalCell()" + e.getMaxSizeAnimalCell() +
                                        "e.getMaxSpeedCell()" + e.getMaxSpeedCell() +
                                        "e.getWiegthEating()" + e.getWiegthEating()+
                                        "e.getCountAnimal()" + e.getCountAnimal() +
                                        "e.getPackweight()" + e.getPackweight() +
                                        "e.getFoodAllPack()" + e.getFoodAllPack()

                        )
                )
                .forEach(System.out::println);

        var rabbit4 = new Rabbit();
        System.out.println("setAnimal - " + setAnimal);
        var contains = setAnimal.contains(rabbit4);
        System.out.println("contains - " + contains);

//в каждой ячейке будет мапа с ключом класса, и с самим классом с его характеристиками
        Map<? super Animal, ? super Animal> map = new HashMap<>();
        map.put(new Rabbit(), new Rabbit());

        System.out.println("map.equals(\"Rabbit\")  ---" + map.containsKey(rabbit4));





        Grass grass = new Grass();
        grass.setBirthGrass();
        double countGrass = grass.getCountGrass();

        System.out.println("Main countGrass" + countGrass);

        Rabbit rabbit = new Rabbit(value, countGrass);


        double remainGrass = rabbit.eat();
        grass.setCountGrass(remainGrass);

        double countGrass2 = grass.getCountGrass();

        System.out.println(remainGrass + "remainGrass");
        System.out.println(countGrass2 + "countGrass2");

        // TODO

        init(Rabbit.class);
        System.out.println(init(Rabbit.class) + " -  init(Rabbit.class)");
        init(Wolf.class);
        System.out.println(init(Wolf.class) + " -  init(Wolf.class)");

        //   Вес одного животного, кг 2
//   Максимальное количество животных этого вида на одной клетке 150
//   Скорость перемещения, не более чем, клеток за ход 2
//   Сколько килограммов пищи нужно животному для полного насыщения

        //при инициал рандомно животных распологаем жл Максимальное количество
//        int countAnimal = RandomeImportance.getRandomQuantity(initialAnimal.maxSizeAnimalCell());
        // вес всей стаи double packweight = wiegthOneAnimal * countAnimal;
//        сколько кг всей стаи нужно для утоления голода
//        double foodAllPack = countAnimal * initialAnimal.wiegthEating();


//        animalInitialization


        //проверка инициализации животных в массив и выбора еее оттуд по классу и аннотации

        List<? super Animal> animals = new ArrayList<>();
        animals.add(new Rabbit());
        animals.add(new Wolf());

        System.out.println(animals.getFirst().getClass() + " -  animals.getFirst().getClass()");

        System.out.println(animals.get(1).getClass() + " -  animals.get(1).getClass()");

        init(animals.get(1).getClass());

        Map<String, ? super Animal> mapAnim = new HashMap<>();
        mapAnim.put("Wolf", new Wolf());
        mapAnim.put("Rabbit", new Rabbit());

        System.out.println("mapAnim.get(\"Wolf\").getClass() ------ " + mapAnim.get("Wolf").getClass());

        System.out.println();

        for (int i = 0; i < Animal.animalsClass.size(); i++) {
            if ("Wolf".equals(Animal.animalsClass.get(i))) {
                System.out.println(Animal.animalsClass.get(i) + i);
            }
        }


        System.out.println(Animal.animalsClass.get(0));
        //проверка инициализации животных в массив и выбора еее оттуд по классу и аннотации

        var exampleClass1 = ExampleClass.initClass(Rabbit.class);
        System.out.println(exampleClass1.getClass() + " - exampleClass1");



        try {
            var cloneRabbit = exampleClass1.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }



        Class<Rabbit> rabbitClass = Rabbit.class;
        Rabbit rabbit1 = new Rabbit();

//        Мы получаем клон и из клона выкачиваем экземпляр класса с аннотациями

        System.out.println("Animal.animalsClass.get(7) - " + Animal.animalsClass.get(7));
        String s = Animal.animalsClass.get(7);





        var clone = new Rabbit().clone();
        Object rabbit2 = mapAnim.get("Rabbit");
//        Class<?> aClass1 = new rabbit2.getClass();

        var exampleClass2 = ExampleClass.initClass(clone.getClass());
        var maxSizeAnimalCell1 = exampleClass2.getMaxSizeAnimalCell();
        System.out.println("maxSizeAnimalCell1 - " + maxSizeAnimalCell1);


//        Мы записываем в мапу копии классов и с мапы по Строке выводим копию классов животных и их инициализируем
        Map<String, ? super Animal> mapAnim2 = new HashMap<>();
        mapAnim2.put("Wolf", new Wolf().clone());
        mapAnim2.put("Rabbit", new Rabbit().clone());

        Object rabbit3 = mapAnim2.get("Rabbit");
        var exampleClass3 = ExampleClass.initClass(rabbit3.getClass());
        var maxSizeAnimalCell2 = exampleClass3.getMaxSizeAnimalCell();
        System.out.println("maxSizeAnimalCell2 - " + maxSizeAnimalCell2);


//        Initialization init =  new Initialization(exampleClass1.getClass());
//        var cloneExampleClass = init.getCloneExampleClass();

        System.out.println(Initialization.getMapCopyAnimals());
//        mapCopyAnimals.put("Boa", new Boa());
//        mapCopyAnimals.put("Wolf", new Wolf());
//        mapCopyAnimals.put("Rabbit", new Rabbit());
        Initialization.defaultFillingMapCopyAnimals();


//        Logic автоматическое заполнение копиями классов

        var string = Initialization.getMapCopyAnimals().toString();
        System.out.println(string);
//        получение строки животное по номеру
//        получение объекта животного по ключу название животного
//        получение экземпляра класса животного
//        получение полей у экземпляра класса

        var str1 = Animal.animalsClass.get(0);
        var object1 = mapCopyAnimals.get(str1);
        System.out.println("object1 --- " + object1);
        Class<?> aClass123 = object1.getClass();
        var exampleClass4 = ExampleClass.initClass(aClass123);
        var maxSizeAnimalCell3 = exampleClass4.getMaxSizeAnimalCell();
        System.out.println("maxSizeAnimalCell3 --- " + maxSizeAnimalCell3);





        //        Рандомное (по строке) инициализация на карту экземпляров классов
        //        с рандомными значениями(параметрами) и их кол-во

        for (int i = 0; i < 2; i++) {
            var randomQuantity123 = RandomImportance.getRandomQuantity(3);
            var s1 = Animal.animalsClass.get(randomQuantity123);
            var o = mapCopyAnimals.get(s1);

            System.out.println(randomQuantity123);
            System.out.println(s1);
            System.out.println(o);
        }

        var countCopyAnimals = Initialization.getCountCopyAnimals();
        System.out.println("countCopyAnimals - " +  countCopyAnimals);

//        for (int i = 0; i < 10; i++) {
            var random = RandomImportance.getRandom(countCopyAnimals);
            var s2 = Animal.animalsClass.get(0);
            var o2 = mapCopyAnimals.get(s2);

            System.out.println(o2);
//        }

        Class<?> aClass1 = o2.getClass();

        var exampleClass5 = ExampleClass.initClass(aClass1);

        var wiegthOneAnimal1 = exampleClass5.getWiegthOneAnimal();
        var maxSizeAnimalCell4 = exampleClass5.getMaxSizeAnimalCell();
        var maxSpeedCell1 = exampleClass5.getMaxSpeedCell();
        var wiegthEating1 = exampleClass5.getWiegthEating();

        var countAnimal1 = exampleClass5.getCountAnimal();
        var packweight1 = exampleClass5.getPackweight();
        var foodAllPack1 = exampleClass5.getFoodAllPack();

        System.out.println(wiegthOneAnimal1);
        System.out.println(maxSizeAnimalCell4);
        System.out.println(maxSpeedCell1);
        System.out.println(wiegthEating1);

        System.out.println(countAnimal1);
        System.out.println(packweight1);
        System.out.println(foodAllPack1);

//      кушать по классу определяем тип животного и попался ли на его пути тип который он может кушать
//      если может то с определенной долей вероятности он его съедает (рандом)
//
        Rabbit rab = new Rabbit();
        var length = Animal.probabilityEat;
        System.out.println(Arrays.deepToString(length));

//        MULTIPLICATION_TABLE = new int[10][10];
//
//        for (int i = 0; i < MULTIPLICATION_TABLE.length; i++) {
//            for (int j = 0; j < MULTIPLICATION_TABLE[i].length; j++) {
//                MULTIPLICATION_TABLE[i][j] = (i + 1) * (j + 1);
//            }
//
//        }
//
//        for (int[] massive : MULTIPLICATION_TABLE) {
//            for (int value : massive) {
//                System.out.print(value + " ");
//            }
//            System.out.println();
//        }

//        По классу определяем текст(кто), по тексту номер в листе
//        по номеру определяем номер вхождения 1го массива
//        далее классу определяем текст (кого) кушаем, по тексту номер в листе
//        по номеру определяем номер вхождения массива (вероятность съедания)



//        var str1 = Animal.animalsClass.get(0);


        for (int i = 0; i < Animal.probabilityEat.length; i++) {
            if (0 == i) {
                for (int j = 0; j < Animal.probabilityEat[i].length; j++) {
                    if (7 == j) {
                        System.out.print(Animal.probabilityEat[i][j]);
                    }
                }
                System.out.println();
            }
        }




//  номер класса нашего животного
        int thisNumberClassAnimal = 0;
//  номер класса другого животного
        int thenNumberClassAnimal = 7;




        var elementAtIndex = Optional.of(Animal.probabilityEat)
                .filter(arr -> arr.length > thisNumberClassAnimal)
                .map(arr -> arr[thisNumberClassAnimal])
                .filter(row -> row.length > thenNumberClassAnimal)
                .map(row -> row[thenNumberClassAnimal])
                .get();

        System.out.println("elementAtIndex - " + elementAtIndex);



        System.out.println("---------------------------------------------------------------------------------");

        var wiegthOneAnimal = exampleClass1.getWiegthOneAnimal();
        System.out.println(wiegthOneAnimal + " - wiegthOneAnimal");
        var countAnimal = exampleClass1.getCountAnimal();
        var foodAllPack = exampleClass1.getFoodAllPack();
        var maxSpeedCell = exampleClass1.getMaxSpeedCell();
        var packweight = exampleClass1.getPackweight();
        var maxSizeAnimalCell = exampleClass1.getMaxSizeAnimalCell();
        var wiegthEating = exampleClass1.getWiegthEating();

        System.out.println(countAnimal + " - wcountAnimal");
        System.out.println(foodAllPack + " - wfoodAllPack");
        System.out.println(maxSpeedCell + " - wmaxSpeedCell");
        System.out.println(packweight + " - wpackweight");
        System.out.println(maxSizeAnimalCell + " - wmaxSizeAnimalCell");
        System.out.println(wiegthEating + " - wwiegthEating");



        for (Annotation annotation : exampleClass1.getClass().getAnnotations()) {
            System.out.println(annotation);
        }
        for (Class<?> aClass : exampleClass1.getClass().getClasses()) {
            System.out.println(aClass);
        }


        System.out.println("---------------------------------------------------------------------------------");


        var exampleClass = ExampleClass.initClass(new Rabbit().getClass());

        System.out.println(Optional.ofNullable(exampleClass).getClass() + " - exampleClass");


    }

    //Создаю клсасс инициализации для объектов




    public static boolean init(Class animalClass) {
        if (!animalClass.isAnnotationPresent(AnnotationAnimals.class)) {
            throw new RuntimeException("animalClass param is not AnnotationAnimals");
        }


        AnnotationAnimals initialAnimal = (AnnotationAnimals) animalClass.getAnnotation(AnnotationAnimals.class);
        System.out.println(initialAnimal.wiegthOneAnimal());
        System.out.println(initialAnimal.maxSizeAnimalCell());
        System.out.println(initialAnimal.maxSpeedCell());
        System.out.println(initialAnimal.wiegthEating());

        return true;
    }


}

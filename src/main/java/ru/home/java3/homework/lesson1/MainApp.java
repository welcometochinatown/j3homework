package ru.home.java3.homework.lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class MainApp {
    /*
    1. Написать метод, который меняет два элемента массива местами
    (массив может быть любого ссылочного типа);
    2. Написать метод, который преобразует массив в ArrayList;
    3. Задача:
        a. Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
        b. Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу
        фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
        c. Для хранения фруктов внутри коробки можно использовать ArrayList;
        d. Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта
        и их количество: вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
        e. Внутри класса Box сделать метод compare(), который позволяет сравнить текущую
        коробку с той, которую подадут в compare() в качестве параметра. true – если их массы
        равны, false в противоположном случае. Можно сравнивать коробки с яблоками и
        апельсинами;
        f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
        Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
        Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются
        объекты, которые были в первой;
        g. Не забываем про метод добавления фрукта в коробку.
    */

    public static void main(String[] args) {
        // Тесты для задания №3

        Apple apple = new Apple();
        Orange orange = new Orange();

        // Создаем коробку с яблоками
        Box<Apple> box1 = new Box<>();
        box1.addFruit(apple);
        box1.addFruit(apple);
        box1.addFruit(apple);
        System.out.println("Вес 1й коробки: " + box1.getWeight());

        // Создаем коробку с апельсинами
        Box<Orange> box2 = new Box<>();
        box2.addFruit(orange);
        box2.addFruit(orange);
        box2.addFruit(orange);
        System.out.println("Вес 2й коробки: " + box2.getWeight());

        // Сравниваем коробки
        System.out.println("Результат сравнения коробок: " + box1.compare(box2));

        // Перекладываем фрукти в другую коробку
        // Создадим дополнительные коробки
        Box<Apple> box3 = new Box<>();
        System.out.println(box3.getWeight());
        Box<Orange> box4 = new Box<>();
        System.out.println(box4.getWeight());
        box1.transferToDifferentBox(box3);
        box2.transferToDifferentBox(box4);
        System.out.println(box3.getWeight());
        System.out.println(box4.getWeight());

        /*========================================================*/


        // Тесты для заданий №1 и №2
        String[] strings = {"A", "B"};
        System.out.println(Arrays.toString(strings));
        swapPlaces(strings);
        System.out.println(Arrays.toString(strings));

        Fruit fruit1 = new Fruit(1.2f);
        Fruit fruit2 = new Fruit(1.2f);

        Object[] objects = {fruit1, fruit2};
        System.out.println("До свапа index[0] : " + objects[0]);
        System.out.println("До свапа index[1] : " + objects[1]);
        swapPlaces(objects);
        System.out.println("После свапа index[0] : " + objects[0]);
        System.out.println("После свапа index[1] : " + objects[1]);
        System.out.println(convertToList(objects));

        System.out.println(convertToList(strings));
    }

    public static void swapPlaces(Object[] objects) {
        Object temp = objects[0];
        objects[0] = objects[1];
        objects[1] = temp;
    }

    public static <T> ArrayList<T> convertToList(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }
}

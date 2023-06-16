package ru.home.java3.homework.lesson1;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> fruits;

    public Box() {
        fruits = new ArrayList<T>();
    }

    public float getWeight() {
        float boxWeight = 0.0f;
        for (int i = 0; i < fruits.size(); i++) {
            boxWeight += fruits.get(i).getWeight();
        }
        return boxWeight;
    }

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public boolean compare(Box<?> differentBox) {
        return Math.abs(this.getWeight() - differentBox.getWeight()) < 0.01;
    }

    public void transferToDifferentBox(Box<T> differentBox) {
        for (int i = 0; i < this.fruits.size(); i++) {
            differentBox.addFruit(this.fruits.get(i));
        }
        this.fruits.clear();
    }
}

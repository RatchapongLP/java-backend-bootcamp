package io.javabrains.javacollections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
Write code that calls the getFruits method and then iterates over the collection, printing each element to console
 */

public class IteratorExercise {
    public static void main(String[] args) {
        FruitSupplier fruitSupplier = new FruitSupplier();
        Collection<String> fruits = fruitSupplier.getFruits();

        System.out.println("Iterating over fruits with iterator.next():");
        Iterator<String> iterator = fruits.iterator();
        while (iterator.hasNext()) {
            String fruit = iterator.next();
            System.out.println(fruit);
//            fruits.add("orange"); // This will cause ConcurrentModificationException on next iterator.next() call
//            fruits.add("grape");
//            System.out.println("fruits after adding: " + fruits);
//            fruits.remove("orange");
//            fruits.remove("grape");
//            System.out.println("fruits after removing: " + fruits);
        }

        System.out.println("\nIterating over fruits with for-each loop:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}


class FruitSupplier {
    public Collection<String> getFruits() {
        ArrayList<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");
        return list;
    }

}
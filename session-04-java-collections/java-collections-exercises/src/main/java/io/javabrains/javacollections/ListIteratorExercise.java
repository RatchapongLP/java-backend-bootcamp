package io.javabrains.javacollections;

/*
Print the list in forward and reverse order using iterators only
*/

import java.util.ArrayList;
import java.util.ListIterator;

public class ListIteratorExercise {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Item 1");
        list.add("Item 2");
        list.add("Item 3");
        list.add("Item 4");
        list.add("Item 5");

        ListIterator<String> iterator = list.listIterator();

        while (iterator.hasNext()) {
            String item = iterator.next();
            System.out.println("Forward: " + item);
//            iterator.remove();
//            System.out.println("List after removals: " + list + ", size: " + list.size());
        }
        System.out.println();

        while (iterator.hasPrevious()) {
            String item = iterator.previous();
            System.out.println("Reverse: " + item);
        }
    }
}

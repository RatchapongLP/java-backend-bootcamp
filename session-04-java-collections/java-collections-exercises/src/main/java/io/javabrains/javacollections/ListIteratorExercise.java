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
            System.out.println("Current List: " + list + ", size: " + list.size());

            int index = iterator.previousIndex();
            String item = iterator.previous();
            System.out.println("index: " + index + ", Item: " + item);

//            System.out.println("Reverse: " + item);

            iterator.remove(); // Must be called ONCE and AFTER a call to next() or previous()
            System.out.println("List after 1st removal: " + list + ", size: " + list.size());

            iterator.add("New Item " + (index + 1)); // Can be called multiple times
            iterator.add("New Item " + (index + 2));
            System.out.println("List after additions: " + list + ", size: " + list.size());

            iterator.previous();
            iterator.remove();
            iterator.previous();
            iterator.remove();
            System.out.println("List after cleanup removals: " + list + ", size: " + list.size() + "\n");
        }
    }
}

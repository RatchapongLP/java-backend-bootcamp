package io.javabrains.javacollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Compare {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>(List.of(
                new Person("Alice", "Smith", 25, new Date()),
                new Person("Bob", "Johnson", 30, new Date()),
                new Person("Charlie", "Williams", 22, new Date()),
                new Person("David", "Brown", 28, new Date())
        ));

        Collections.sort(people);
        System.out.println("People sorted by age:");
        people.forEach(System.out::println);

        Collections.sort(people, new PersonNameComparator());
        System.out.println("People sorted by first name:");
        people.forEach(System.out::println);
    }
}

package io.javabrains.javacollections;

/*
Generate a Person class with the member variables firstName, lastName, age, lastModifiedDate.
Generate equals and hashcode methods using member variables firstName, lastName, age
Compare two instances of Person that have the same data
*/

import java.util.*;

public class EqualsAndHashCode {

    public static void main(String[] args) {
        Person p1 = new Person("John", "Doe", 30, new Date());
        Person p2 = new Person("John", "Doe", 30, new Date());
        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);
        System.out.println("p1.equals(p2): " + p1.equals(p2));
        System.out.println("p1.hashCode(): " + p1.hashCode());
        System.out.println("p2.hashCode(): " + p2.hashCode());
    }
}

class Person implements Comparable<Person>{
    private String firstName;
    private String lastName;
    private int age;
    private Date lastModifiedDate;

    public Person(String firstName, String lastName, int age, Date lastModifiedDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return this.age == person.age &&
                Objects.equals(this.firstName, person.firstName) &&
                Objects.equals(this.lastName, person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", lastModifiedDate=" + lastModifiedDate +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return Integer.compare(this.age, o.age);
    }
}

class PersonNameComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        if (p1.getFirstName() == null && p2.getFirstName() == null) {
            if (p1.getLastName() == null && p2.getLastName() == null) {
                return 0;
            } else if (p1.getLastName() == null) {
                return -1;
            } else if (p2.getLastName() == null) {
                return 1;
            }
            return p1.getLastName().compareTo(p2.getLastName());
        }

        if (p1.getFirstName() == null) {
            return -1;
        }

        if (p2.getFirstName() == null) {
            return 1;
        }

        return p1.getFirstName().compareTo(p2.getFirstName());
    }
}

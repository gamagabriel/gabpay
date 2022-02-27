package application;

import entities.Person;

public class Main {

    public static void main(String[] args) {

        Person person = Person.builder().balance(300.0).build();

        System.out.println(person);


    }
}

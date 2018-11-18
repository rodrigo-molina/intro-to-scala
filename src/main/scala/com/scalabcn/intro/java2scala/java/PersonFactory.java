package com.scalabcn.intro.java2scala.java;

public class PersonFactory {
    public static Person aPerson(Long id, String name, String surname, Gender gender) {
        return new Person(id, name, surname, gender);
    }
}

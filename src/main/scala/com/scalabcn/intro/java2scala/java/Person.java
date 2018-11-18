package com.scalabcn.intro.java2scala.java;

import java.util.Objects;

public class Person {
    final private Long id;

    final private String name;
    final private String surname;
    final private Gender gender;

    public Person(Long id, String name, String surname, Gender gender) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "{ name: " + name + ", surname: " + surname + ", gender: " + gender + " }";
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

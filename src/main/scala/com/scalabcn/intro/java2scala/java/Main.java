package com.scalabcn.intro.java2scala.java;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.scalabcn.intro.java2scala.java.DogFactory.aDog;
import static com.scalabcn.intro.java2scala.java.PersonFactory.aPerson;

public class Main {
    private final static Person CHUCK = aPerson(1L, "Chuck", "Norris", Gender.MALE);
    private final static Person CHUCKA = aPerson(2L, "Chucka", "Norras", Gender.FEMALE);
    private final static Person BARB = aPerson(3L, "Barbara", "Liskov", Gender.FEMALE);
    private final static Person LUIS = aPerson(4L, "Luis", "Miguel", Gender.MALE);

    public static void main(String[] args) {
        final List<Person> persons = Arrays.asList(
                CHUCK,
                CHUCK,
                CHUCKA,
                BARB,
                LUIS
        );

        final List<Dog> dogs = Arrays.asList(
                aDog(CHUCK.getId(), "Makina"),
                aDog(CHUCK.getId(), "Firulais"),
                aDog(LUIS.getId(), "Pipi"));

        // ALL
        System.out.println("ALL");
        persons.stream()
                .forEach(System.out::println);

        // FILTER
        System.out.println("FILTER");
        persons.stream()
                .filter(hasGender(Gender.MALE).and(nameContains("Chu")))
                .map(personToString())
                .forEach(System.out::println);

        // REDUCE
        System.out.println("REDUCE");
        String reduce =
                persons.stream()
                        .filter(hasGender(Gender.FEMALE))
                        .map(Person::getName) // CANT DO IT ALL TOGETHER
                        .reduce("", (n, acc) -> acc + "," + n);
        System.out.println(reduce);

        // FIND THOSE WITH DOGS
        System.out.println("FIND THOSE WITH DOGS");
        persons.stream()
                .filter(p -> dogs.stream()
                        .filter(d -> p.getId().equals(d.getOwnerId())).findFirst().isPresent())
                .distinct()
                .forEach(System.out::println);

        // OR BETTER
        System.out.println("FIND THOSE WITH DOGS 2");
        final Map<Long, Person> personMap = persons.stream().distinct().collect(Collectors.toMap(Person::getId, p -> p));

        dogs.stream()
                .map(dog -> personMap.get(dog.getOwnerId()))
                .distinct()
                .forEach(System.out::println);
    }


    private static Function<Person, String> personToString() {
        return person -> "Stringify: " + person;
    }

    private static Predicate<Person> hasGender(Gender gender) {
        return person -> person.getGender().equals(gender);
    }

    private static Predicate<Person> nameContains(String name) {
        return person -> person.getName().contains(name);
    }
}

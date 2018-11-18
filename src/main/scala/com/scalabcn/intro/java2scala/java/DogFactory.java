package com.scalabcn.intro.java2scala.java;

public class DogFactory {
    public static Dog aDog(Long ownerId, String name) {
        return new Dog(ownerId, name);
    }
}

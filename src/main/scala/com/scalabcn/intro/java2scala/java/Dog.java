package com.scalabcn.intro.java2scala.java;

import java.util.Objects;

public class Dog {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dog)) return false;
        Dog dog = (Dog) o;
        return Objects.equals(ownerId, dog.ownerId) &&
                Objects.equals(name, dog.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(ownerId, name);
    }

    private final Long ownerId;
    private final String name;

    public Dog(Long ownerId, String name) {
        this.name = name;
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public Long getOwnerId() {
        return ownerId;
    }
}

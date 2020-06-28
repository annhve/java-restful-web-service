package com.annhve.learningproject.animals;

public class Animal {
    private final long id;
    private final String animalName;

    public Animal(long id, String animalName) {
        this.id = id;
        this.animalName = animalName;
    }

    public long getId() {
        return id;
    }

    public String getAnimalName() {
        return animalName;

    }
}

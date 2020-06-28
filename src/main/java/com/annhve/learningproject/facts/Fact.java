package com.annhve.learningproject.facts;

public class Fact {
    private final long id;
    private final String animalFact;

    public Fact(long id, String animalFact) {
        this.id = id;
        this.animalFact = animalFact;
    }

    public long getId() {
        return id;
    }

    public String getAnimalFact() {
        return animalFact;

    }
}


package com.annhve.learningproject.animals;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnimalController {
    private static final String template = "Hello, your totem animal is ";
    private static final AtomicLong counter = new AtomicLong();
    private static List<Animal> animals = new ArrayList<>();

    static {
        animals.add(new Animal(
                counter.incrementAndGet(),
                "snail"
        ));
        animals.add(new Animal(
                counter.incrementAndGet(),
                "penguin"
        ));
        animals.add(new Animal(
                counter.incrementAndGet(),
                "giraffe"
        ));
        animals.add(new Animal(
                counter.incrementAndGet(),
                "elephant"
        ));
        animals.add(new Animal(
                counter.incrementAndGet(),
                "koala"
        ));
    }

    @RequestMapping("/animals")
    public List<Animal> animals(@RequestParam(value = "name", required = false, defaultValue = "") String name) {
        if (name != null && !name.isEmpty()) {
            return animals.stream().filter((animal -> animal.getAnimalName().equalsIgnoreCase(name))).collect(Collectors.toList());
        } else {
            return animals;
        }
    }
}

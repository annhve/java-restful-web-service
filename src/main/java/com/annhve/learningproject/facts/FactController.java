package com.annhve.learningproject.facts;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import com.annhve.learningproject.animals.Animal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FactController {
    private static final String template = "Hello, your totem animal is ";
    private static final AtomicLong counter = new AtomicLong();
    private static List<Fact> facts = new ArrayList<>();

    static {
        facts.add(new Fact(
                counter.incrementAndGet(),
                "A snail can sleep for three years"
        ));
        facts.add(new Fact(
                counter.incrementAndGet(),
                "Nearly three percent of the ice in Antarctic glaciers is penguin urine"
        ));
        facts.add(new Fact(
                counter.incrementAndGet(),
                "Giraffes have no vocal chords"
        ));
        facts.add(new Fact(
                counter.incrementAndGet(),
                "Elephants are the only animal that can't jump"
        ));
        facts.add(new Fact(
                counter.incrementAndGet(),
                "The fingerprints of a koala are so indistinguishable from humans that they have on occasion been confused at a crime scene."
        ));
    }

    @RequestMapping("/facts")
    public List<Fact> facts(@RequestParam(value = "name", required = false, defaultValue = "") String name) {
        if (name != null && !name.isEmpty()) {
            return facts.stream().filter((fact -> fact.getAnimalFact().equalsIgnoreCase(name))).collect(Collectors.toList());
        } else {
            return facts;
        }
    }
}

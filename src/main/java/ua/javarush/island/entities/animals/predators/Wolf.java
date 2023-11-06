package ua.javarush.island.entities.animals.predators;

import ua.javarush.island.domain.Predator;
import ua.javarush.island.entities.Entity;
import ua.javarush.island.utilities.Config;
import ua.javarush.island.entities.animals.herbivores.*;

import java.util.HashMap;
import java.util.Map;


@Config(fileName = "animals/predators/wolf.yaml")
public class Wolf extends Predator {

    {
        Map<Entity, Integer> eatableTable = new HashMap<>() {{
            put(new Horse(), 10);
            put(new Reindeer(), 15);
            put(new Rabbit(), 60);
            put(new Mouse(), 80);
            put(new Goat(), 60);
            put(new Sheep(), 70);
            put(new Boar(), 15);
            put(new Buffalo(), 10);
            put(new Duck(), 40);
        }};

        super.setEatableTable(eatableTable);

    }

}


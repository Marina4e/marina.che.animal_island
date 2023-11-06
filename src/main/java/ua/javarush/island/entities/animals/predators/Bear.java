package ua.javarush.island.entities.animals.predators;

import ua.javarush.island.domain.Predator;
import ua.javarush.island.entities.Entity;
import ua.javarush.island.utilities.Config;
import ua.javarush.island.entities.animals.herbivores.*;

import java.util.HashMap;
import java.util.Map;

@Config(fileName = "animals/predators/bear.yaml")
public class Bear extends Predator {

    {
        Map<Entity, Integer> eatableTable = new HashMap<>() {{
            put(new Snake(), 80);
            put(new Horse(), 40);
            put(new Reindeer(), 80);
            put(new Rabbit(), 80);
            put(new Mouse(), 90);
            put(new Goat(), 70);
            put(new Sheep(), 70);
            put(new Boar(), 50);
            put(new Buffalo(), 20);
            put(new Duck(), 10);
        }};

        super.setEatableTable(eatableTable);

    }

}



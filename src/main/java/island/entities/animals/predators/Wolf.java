package island.entities.animals.predators;

import island.domain.Predator;
import island.entities.Entity;
import island.entities.animals.herbivores.*;
import island.utilities.Config;

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
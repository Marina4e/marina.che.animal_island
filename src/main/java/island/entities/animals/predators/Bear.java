package island.entities.animals.predators;

import island.domain.Predator;
import island.entities.Entity;
import island.entities.animals.herbivores.*;
import island.utilities.Config;

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
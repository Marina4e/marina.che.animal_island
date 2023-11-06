package ua.javarush.island.entities.animals.predators;

import ua.javarush.island.domain.Predator;
import ua.javarush.island.entities.Entity;
import ua.javarush.island.entities.animals.herbivores.Duck;
import ua.javarush.island.entities.animals.herbivores.Mouse;
import ua.javarush.island.entities.animals.herbivores.Rabbit;
import ua.javarush.island.utilities.Config;

import java.util.HashMap;
import java.util.Map;

@Config(fileName = "animals/predators/eagle.yaml")
public class Eagle extends Predator {

    {
        Map<Entity, Integer> eatableTable = new HashMap<>() {{
            put(new Fox(), 10);
            put(new Rabbit(), 90);
            put(new Mouse(), 90);
            put(new Duck(), 80);
        }};

        super.setEatableTable(eatableTable);

    }

}



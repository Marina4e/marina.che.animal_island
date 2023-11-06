package ua.javarush.island.entities.animals.predators;

import ua.javarush.island.domain.Predator;
import ua.javarush.island.entities.Entity;
import ua.javarush.island.entities.animals.herbivores.Caterpillar;
import ua.javarush.island.entities.animals.herbivores.Duck;
import ua.javarush.island.entities.animals.herbivores.Mouse;
import ua.javarush.island.entities.animals.herbivores.Rabbit;
import ua.javarush.island.utilities.Config;

import java.util.HashMap;
import java.util.Map;

@Config(fileName = "animals/predators/fox.yaml")
public class Fox extends Predator {

    {
        Map<Entity, Integer> eatableTable = new HashMap<>() {{
            put(new Rabbit(), 70);
            put(new Mouse(), 90);
            put(new Duck(), 60);
            put(new Caterpillar(), 40);
        }};

        super.setEatableTable(eatableTable);

    }

}


package ua.javarush.island.entities.animals.predators;

import ua.javarush.island.domain.Predator;
import ua.javarush.island.entities.Entity;
import ua.javarush.island.entities.animals.herbivores.Duck;
import ua.javarush.island.entities.animals.herbivores.Mouse;
import ua.javarush.island.entities.animals.herbivores.Rabbit;
import ua.javarush.island.utilities.Config;

import java.util.HashMap;
import java.util.Map;

@Config(fileName = "animals/predators/snake.yaml")
public class Snake extends Predator {

    {
        Map<Entity, Integer> eatableTable = new HashMap<>() {{
            put(new Fox(), 15);
            put(new Rabbit(), 20);
            put(new Mouse(), 40);
            put(new Duck(), 10);
        }};

        super.setEatableTable(eatableTable);

    }

}


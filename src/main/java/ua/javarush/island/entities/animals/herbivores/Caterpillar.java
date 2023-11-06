package ua.javarush.island.entities.animals.herbivores;

import ua.javarush.island.domain.Herbivore;
import ua.javarush.island.entities.Entity;
import ua.javarush.island.entities.plants.Plant;
import ua.javarush.island.utilities.Config;

import java.util.HashMap;
import java.util.Map;

@Config(fileName = "animals/herbivores/caterpillar.yaml")
public class Caterpillar extends Herbivore {

    {
        Map<Entity, Integer> eatableTable = new HashMap<>() {{
            put(new Plant(), 100);
        }};

        super.setEatableTable(eatableTable);

    }

}


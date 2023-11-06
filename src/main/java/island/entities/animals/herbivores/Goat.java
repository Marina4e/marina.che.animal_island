package island.entities.animals.herbivores;

import island.domain.Herbivore;
import island.entities.Entity;
import island.entities.plants.Plant;
import island.utilities.Config;

import java.util.HashMap;
import java.util.Map;

@Config(fileName = "animals/herbivores/goat.yaml")
public class Goat extends Herbivore {

    {
        Map<Entity, Integer> eatableTable = new HashMap<>() {{
            put(new Plant(), 100);
        }};

        super.setEatableTable(eatableTable);

    }

}

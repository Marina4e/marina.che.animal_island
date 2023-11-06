package island.entities.animals.herbivores;

import island.domain.Herbivore;
import island.entities.Entity;
import island.entities.plants.Plant;
import island.utilities.Config;

import java.util.HashMap;
import java.util.Map;

@Config(fileName = "animals/herbivores/boar.yaml")
public class Boar extends Herbivore {

    {
        Map<Entity, Integer> eatableTable = new HashMap<>() {{
            put(new Mouse(), 50);
            put(new Caterpillar(), 90);
            put(new Plant(), 100);
        }};

        super.setEatableTable(eatableTable);

    }

}

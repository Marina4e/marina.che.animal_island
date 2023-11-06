package island.entities.animals.predators;

import island.domain.Predator;
import island.entities.Entity;
import island.entities.animals.herbivores.Duck;
import island.entities.animals.herbivores.Mouse;
import island.entities.animals.herbivores.Rabbit;
import island.utilities.Config;

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


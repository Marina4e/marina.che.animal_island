package island.entities.animals.predators;

import island.domain.Predator;
import island.entities.Entity;
import island.entities.animals.herbivores.Caterpillar;
import island.entities.animals.herbivores.Duck;
import island.entities.animals.herbivores.Mouse;
import island.entities.animals.herbivores.Rabbit;
import island.utilities.Config;

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
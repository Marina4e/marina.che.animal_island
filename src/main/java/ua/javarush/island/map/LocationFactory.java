package ua.javarush.island.map;

import ua.javarush.island.entities.Entity;
import ua.javarush.island.utilities.Settings;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class LocationFactory {
    public Location create(int x, int y) {
        Location location = new Location();
        location.setX(x);
        location.setY(y);
        location.setEntityList(createEntities());
        return location;
    }

    private List<Entity> createEntities() {
        List<Entity> entityList = new ArrayList<>();
        Random random = new Random();

        Settings.entitySet.forEach(obj -> entityList.addAll(createEntityBatch(random, obj.getMaxAmount(), obj)));

        return entityList;
    }

    private List<Entity> createEntityBatch(Random random, int count, Supplier<Entity> supplier) {
        List<Entity> batch = new ArrayList<>();
        for (int i = 0; i < random.nextInt(count); i++) {
            batch.add(supplier.get());
        }
        return batch;
    }

}



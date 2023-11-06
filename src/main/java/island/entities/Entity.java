package island.entities;

import island.map.GameMap;
import island.map.Location;
import island.utilities.YamlConfigReader;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.function.Supplier;

@Getter
@Setter
public abstract class Entity implements Supplier {

    private String name;
    private String icon;
    private double maxWeight;
    private int maxAmount;
    private int maxSpeed;
    private double maxFood;

    private Map<Entity, Integer> eatableTable;

    {
        YamlConfigReader configReader = new YamlConfigReader(this.getClass());
        HashMap<String, Object> configMap = configReader.getConfigMap();
        try {
            name = (String) configMap.get("name");
            icon = (String) configMap.get("icon");
            maxWeight = (Double) configMap.get("maxWeight");
            maxAmount = (Integer) configMap.get("maxAmount");
            maxSpeed = (Integer) configMap.get("maxSpeed");
            maxFood = (Double) configMap.get("maxFood");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Entity get() {
        return this;
    }

    public Location move(Location location) {

        GameMap gameMap = GameMap.getInstance();

        int newX = location.getX();
        int newY = location.getY();
        Random random = new Random();

        for (int step = 0; step < 2; step++) {
            int randomDirection = random.nextInt(4);

            switch (randomDirection) {
                case 0 -> { // право
                    if (newY < gameMap.getLocations()[0].length - 1) {
                        newY++;
                    }
                }
                case 1 -> { // ліво
                    if (newY > 0) {
                        newY--;
                    }
                }
                case 2 -> { // вверх
                    if (newX > 0) {
                        newX--;
                    }
                }
                case 3 -> { // вниз
                    if (newX < gameMap.getLocations().length - 1) {
                        newX++;
                    }
                }
            }
        }

        Location newLocation = gameMap.getLocation(newX, newY);

        if ((newX != location.getX() || newY != location.getY()) && isCanMove(newLocation)) {
            return newLocation;
        } else {
            return null;
        }
    }

    private boolean isCanMove(Location location) {
        long count = location.getEntityList().stream().filter(obj ->
                obj.equals(this)
        ).count();
        return (count <= this.maxAmount);
    }

    public Entity createNewEntity() {
        try {
            Class<? extends Entity> clazz = this.getClass();
            Constructor<? extends Entity> constructor = clazz.getDeclaredConstructor();
            return constructor.newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return Objects.equals(name, entity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}

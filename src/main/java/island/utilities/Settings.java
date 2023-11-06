package island.utilities;

import island.entities.Entity;
import island.entities.animals.herbivores.*;
import island.entities.animals.predators.*;
import island.entities.plants.Plant;
import island.map.GameMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Settings {

    public static final String SALUTATION = "Давайте створимо острів! ";
    public static final String CREATE_MAP = "Введіть розмір мапи острова!";
    public static final String INPUT_ROWS = "Введіть довжину острова: ";
    public static final String INPUT_COLS = "Введіть ширину острова: ";
    public static final String NOT_KNOW_ERROR = "Упс! Щось пішло не так";
    public static int ROWS;
    public static int COLS;

    public static final int PERIOD = 6;
    public static final int TIMEOUT = 29;

    public static final List<? extends Entity> entitySet = new ArrayList<>(Arrays.asList(
            new Wolf(), new Snake(), new Fox(), new Bear(), new Eagle(), new Horse(), new Reindeer(),
            new Rabbit(), new Mouse(), new Goat(), new Sheep(), new Boar(), new Buffalo(), new Duck(), new Caterpillar(),
            new Plant()
    ));

    public static long calculateTotalEntityCount(GameMap gameMap) {
        return Stream.of(gameMap.getLocations())
                .flatMap(Stream::of)
                .mapToLong(location -> location.getEntityList().size())
                .sum();
    }

    public static void infoTotalEntity(GameMap gameMap) {
        Map<Entity, Long> entityCountMap = Stream.of(gameMap.getLocations())
                .flatMap(Stream::of)
                .flatMap(location -> location.getEntityList().stream())
                .collect(Collectors.groupingBy(
                        entity -> entity,
                        Collectors.counting()
                ));

        entityCountMap.forEach((entity, count) -> {
            System.out.print(entity.getIcon() + " " + count + " ");
        });
        System.out.println();
    }
}

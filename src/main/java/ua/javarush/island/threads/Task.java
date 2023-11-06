package ua.javarush.island.threads;

import ua.javarush.island.map.GameMap;
import ua.javarush.island.utilities.Settings;

public class Task implements Runnable {
    @Override
    public void run() {

        GameMap gameMap = GameMap.getInstance();

        for (var locations : gameMap.getLocations()) {
            for (var location : locations) {
                synchronized (location) {
                    location.moveEntity();
                    location.eatEntity();
                    location.reproduceEntity();
                }
            }
        }

        long sizeAfter = Settings.calculateTotalEntityCount(gameMap);
        System.out.println("Кількість істот: " + sizeAfter);
        Settings.infoTotalEntity(gameMap);
    }
}


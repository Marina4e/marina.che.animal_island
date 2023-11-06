package island.threads;

import island.map.GameMap;
import island.utilities.Settings;

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

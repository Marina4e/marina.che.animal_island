package island.map;

import island.utilities.Settings;

public class GameMap {
    private static GameMap instance;
    private Location[][] locations;

    private GameMap() {
        createMap();
    }

    public Location[][] getLocations() {
        return locations;
    }

    public Location getLocation(int x, int y) {
        return locations[x][y];
    }

    public static GameMap getInstance() {
        if (instance == null) {
            instance = new GameMap();
        }
        return instance;
    }

    private void createMap() {

        locations = new Location[Settings.ROWS][Settings.COLS];

        LocationFactory locationFactory = new LocationFactory();

        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                locations[i][j] = locationFactory.create(i, j);
            }
        }
    }

}
